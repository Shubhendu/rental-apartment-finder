/**
 * 
 */
package com.apartmentfinder.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.apartmentfinder.dto.ApartmentSearchResponseDTO;
import com.apartmentfinder.dto.SearchResponse;
import com.apartmentfinder.util.ApartmentSearchUtil;

/**
 * @author singh_sh
 *
 */
@Service
public class ApartmentSearchServiceImpl implements ApartmentSearchService{

	
	public static final Integer MAX_STRING_LENGTH = 40;
	private static final Logger LOGGER = LoggerFactory.getLogger(ApartmentSearchServiceImpl.class);
	
	
	/**
	 * 
	 * Returns the org.jsoup.nodes.Document object after reading the page provided by url parameter
	 * @param url
	 * @return Document
	 */
	@Override
	public Document readPage(String url) {
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			LOGGER.error("Failed to connect to the server",e);
		}
		
		return doc;
	}

	/**
	 * 
	 * Extracts Time of Ad posting and description of the posting from Craiglist
	 * @param baseUri
	 * @param elements
	 * @param apartmentSearchResponseDTO
	 */
	private void extractListingTimeDescriptionAndUrl(String baseUri, Elements elements, ApartmentSearchResponseDTO apartmentSearchResponseDTO){
		if(elements !=null && !elements.isEmpty()){
			Elements timeElements = elements.get(0).getElementsByTag("time");
			if(timeElements !=null && !timeElements.isEmpty()){
				String postingDate = timeElements.get(0).attr("datetime");
				apartmentSearchResponseDTO.setPostingDate(postingDate);
			}
			
			Elements descriptionElements  = elements.get(0).getElementsByAttributeValue("class", "hdrlnk");
			if(descriptionElements !=null && !descriptionElements.isEmpty()){
				String description =  ApartmentSearchUtil.trim(descriptionElements.text(),MAX_STRING_LENGTH);
				apartmentSearchResponseDTO.setDescription(description);
				String urlAttr = descriptionElements.get(0).getElementsByAttribute("abs:href").attr("href");
				String url = null;
				if(StringUtils.isNotEmpty(urlAttr) && urlAttr.contains("craigslist")){
					url = urlAttr;
				}else{
					url = baseUri + urlAttr;
				}
				
				apartmentSearchResponseDTO.setUrl(url);
			}
		}
	}
	
	/**
	 * Extracts Listings price, size and location from CraigList
	 * @param elements
	 * @param apartmentSearchResponseDTO
	 */
	private void extractListingPriceSizeAndLocation(Elements elements, ApartmentSearchResponseDTO apartmentSearchResponseDTO){

		if (elements != null && !elements.isEmpty()) {
			Elements pricingElements = elements.get(0).getElementsByAttributeValue("class", "price");
			if (pricingElements != null && !pricingElements.isEmpty()) {
				apartmentSearchResponseDTO.setPrice(pricingElements.text());
//				LOGGER.info("Price: "+pricingElements.text()+"\t");
			}
			Elements housingElements = elements.get(0).getElementsByAttributeValue("class", "housing");
			if (housingElements != null && !housingElements.isEmpty()) {
				String size = housingElements.text();
				if(StringUtils.isNotEmpty(size) && size.contains("-")){
					size = ApartmentSearchUtil.trim(size.split("-")[0].replaceAll("/", ""),MAX_STRING_LENGTH);
					size = size.replaceAll("br", " bedrooms");
					size = size.replaceAll("ft2", " sqr fts.");
				}
				apartmentSearchResponseDTO.setSize(size);
//				LOGGER.info("Housing: "+size+"\t");
			}
			Elements pnr = elements.get(0).getElementsByAttributeValue("class", "pnr");
			if (pnr != null && !pnr.isEmpty()) {
				Elements locationElements = pnr.get(0).getElementsByTag("small");
				if (locationElements != null && !locationElements.isEmpty()) {
					String location = locationElements.text();
					if (StringUtils.isNotEmpty(location)) {
						location = location.replaceAll("[()]","");
						location = StringUtils.capitalize(location);
						apartmentSearchResponseDTO.setLocation(location);
					}
					//LOGGER.info("Locations: "+ location);
				}
			}

		}


	}

	
	
	/**
	 * Extracts Listing Information from Craiglist. Takes baseUrl of the page and Document object as input.
	 * @param doc
	 * @param baseUrl
	 * @return List<ApartmentSearchResponseDTO>
	 */
	@Override
	public List<ApartmentSearchResponseDTO>  extractListings(Document doc,String baseUrl) {

		List<ApartmentSearchResponseDTO> apartmentSearchResponseDTOs = null;
		if(doc !=null){
			apartmentSearchResponseDTOs = new ArrayList<ApartmentSearchResponseDTO>();
			Elements listingElements = doc.select("p[class=row]");
			ApartmentSearchResponseDTO apartmentSearchResponseDTO = null;
			int count = 0;
			for(Element listingElement : listingElements){
				apartmentSearchResponseDTO = new ApartmentSearchResponseDTO();
				if(count >100) break;
				Elements plElements = listingElement.getElementsByAttributeValue("class", "pl");
				extractListingTimeDescriptionAndUrl(baseUrl, plElements, apartmentSearchResponseDTO);
				Elements l2Elements  = listingElement.getElementsByAttributeValue("class", "l2");
				extractListingPriceSizeAndLocation(l2Elements,apartmentSearchResponseDTO);
				apartmentSearchResponseDTOs.add(apartmentSearchResponseDTO);
				count ++;
			}

		}
		return apartmentSearchResponseDTOs;
	}

	/**
	 * Extracts pagination information from Craiglist listing page.
	 * @param doc
	 * @param searchResponse
	 */
	@Override
	public void extractPaginationInformation(Document doc, SearchResponse searchResponse) {

		Elements totalCountElements = doc.select("span[class=totalcount]");
		Elements rangeFromElements = doc.select("span[class=rangeFrom]");
		Elements rangeToElements = doc.select("span[class=rangeTo]");
		Elements nextPageUrlElements = doc.select("a[class=button next]");

		if (doc != null) {
			int  totalRecordsCount = 0;
			if (totalCountElements != null && !totalCountElements.isEmpty()) {
				String totalRecords = totalCountElements.get(0).text();
				try{
					 totalRecordsCount = Integer.valueOf(totalRecords);
				}catch(NumberFormatException e){
//					Suppress exception
					LOGGER.error("Total records count was not found:",e);
				}
				searchResponse.setTotalRecordsCount(totalRecordsCount);
				if(totalRecordsCount > 100){
					if (nextPageUrlElements != null && !nextPageUrlElements.isEmpty()) {
						String nextpageUrl = nextPageUrlElements.get(0).attr("abs:href");
						searchResponse.setNextPageUrl(nextpageUrl);
//						LOGGER.info("Next Page url: "+nextpageUrl);
					}
				}
				//LOGGER.info("Total records: "+totalRecords);
			}

			if (rangeFromElements != null && !rangeFromElements.isEmpty()) {
				String startingRecordCount = rangeFromElements.get(0).text();
				searchResponse.setStartingRecordCount(Integer.valueOf(startingRecordCount));
				//LOGGER.info("Staring records records: "+startingRecordCount);

			}
			if(rangeToElements !=null && !rangeToElements.isEmpty()){
				String endingRecordCount = rangeToElements.get(0).text();
				searchResponse.setEndingRecordCount(Integer.valueOf(endingRecordCount));
				//LOGGER.info("End records records: "+endingRecordCount);
			}


		}

	}
	
	
}
