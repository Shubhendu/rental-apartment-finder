/**
 * 
 */
package com.apartmentfinder.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apartmentfinder.dto.ApartmentSearchRequestDTO;
import com.apartmentfinder.dto.ApartmentSearchResponseDTO;
import com.apartmentfinder.dto.SearchResponse;
import com.apartmentfinder.enums.STATUS;
import com.apartmentfinder.service.ApartmentSearchService;
import com.apartmentfinder.util.ApartmentSearchUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author singh_sh
 *
 */
@Controller
public class ApartmentSearchController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApartmentSearchController.class);
	@Autowired 
	private ApartmentSearchService apartmentSearchService;

	@RequestMapping(value = "/",method=RequestMethod.GET)
	public String getMainPage(){
		return "index";
	}
	
	/**
	 * 
	 * @param ApartmentSearchRequestDTO
	 * @return SearchResponse object in JSON format. Response contains status, list of posting with their details,url and price
	 */
	
	@RequestMapping(value = "/rentalApartments",method=RequestMethod.POST)
	@ResponseBody
	public String getRentalApartments(@RequestBody ApartmentSearchRequestDTO apartmentSearchDTO) {
		String response = null;
		SearchResponse searchResponse = new SearchResponse();

		try {
			searchResponse.startResponse();
			String baseUrl = apartmentSearchDTO.getSelectedCityCraiglistUrl();
			String searchUrl = null;
			if(StringUtils.isEmpty(apartmentSearchDTO.getNextPageUrl())){
				String searchCriteria = ApartmentSearchUtil.buildSearchQuery(apartmentSearchDTO);
				searchUrl = baseUrl + "/search/apa?" + searchCriteria;
			}else{
				searchUrl = apartmentSearchDTO.getNextPageUrl();
			}
			
			Document doc = apartmentSearchService.readPage(searchUrl);
			if (doc != null) {
				List<ApartmentSearchResponseDTO> responseList = apartmentSearchService.extractListings(doc,baseUrl);
				searchResponse.setApartmentSearchResponse(responseList);
				apartmentSearchService.extractPaginationInformation(doc, searchResponse);
				searchResponse.endResponse();
			}
			searchResponse.setStatus(STATUS.SUCCESS);
		} catch (Exception e) {
			searchResponse.setStatus(STATUS.FAILURE);
			searchResponse.setErrorMessage("Failed to extract apartment listings");
			searchResponse.endResponse();
			LOGGER.error("Failed to extract apartment listings",e);
		}
		try{
			response = new ObjectMapper().writeValueAsString(searchResponse);
//			LOGGER.info("response: "+response);
		}catch(IOException e){
			LOGGER.error("Exception occured while parsing response",e);
		}
		return response;
	}
}
