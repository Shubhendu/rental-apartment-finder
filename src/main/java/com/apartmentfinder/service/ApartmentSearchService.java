/**
 * 
 */
package com.apartmentfinder.service;

import java.util.List;

import org.jsoup.nodes.Document;

import com.apartmentfinder.dto.ApartmentSearchResponseDTO;
import com.apartmentfinder.dto.SearchResponse;

/**
 * @author singh_sh
 *
 */
public interface ApartmentSearchService {
	
	public Document readPage(String url);
	public List<ApartmentSearchResponseDTO>  extractListings(Document doc,String baseUrl);
	public void extractPaginationInformation(Document doc, SearchResponse searchResponse);

}
