package com.apartmentfinder.util;

import org.apache.commons.lang3.StringUtils;

import com.apartmentfinder.dto.ApartmentSearchRequestDTO;

/**
 * @author singh_sh
 *
 */
public class ApartmentSearchUtil {


	public static String trim(String s, int width) {
		if (StringUtils.isNotEmpty(s)) {
			s = s.trim();
			if (s.length() > width)
				return s.substring(0, width - 1) + ".";
		}
		return s;

	}


	public static String buildSearchQuery(String paramName, String paramValue,String searchStr){

		if (StringUtils.isNotEmpty(paramValue) && StringUtils.isNotEmpty(paramName)) {
			if (StringUtils.isNotEmpty(searchStr)) {
				searchStr += "&" + paramName + "=" + paramValue;
			} else {
				searchStr = paramName + "=" + paramValue;
			}
		}
		return searchStr;
	}


	public static String buildSearchQuery(ApartmentSearchRequestDTO apartmentSearchRequestDTO){
		String searchCriteria = null;

		searchCriteria = buildSearchQuery("bedrooms", apartmentSearchRequestDTO.getApartmentType(), searchCriteria);
		searchCriteria = buildSearchQuery("bathrooms", apartmentSearchRequestDTO.getNumberOfBathrooms(), searchCriteria);
		searchCriteria = buildSearchQuery("min_price", apartmentSearchRequestDTO.getMinCost(), searchCriteria);
		searchCriteria = buildSearchQuery("max_price", apartmentSearchRequestDTO.getMaxCost(), searchCriteria);
		if(apartmentSearchRequestDTO.isRentControlled()){
			searchCriteria = buildSearchQuery("query", "rent+control", searchCriteria);
		}

		return searchCriteria;
	}

}
