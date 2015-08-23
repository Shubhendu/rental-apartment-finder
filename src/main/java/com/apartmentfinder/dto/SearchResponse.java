/**
 * 
 */
package com.apartmentfinder.dto;

import java.util.Calendar;
import java.util.List;

import com.apartmentfinder.enums.STATUS;

/**
 * @author singh_sh
 *
 */
public class SearchResponse {
	
	private STATUS status;
	private long startTime;
	private long executionTime;
	private String errorMessage;
	private String errorCode;
	private List<ApartmentSearchResponseDTO> apartmentSearchResponse;
	private int startingRecordCount;
	private int endingRecordCount;
	private int totalRecordsCount;
	private String nextPageUrl;
	

	public long getExecutionTime() {
		return executionTime;
	}
	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}
	public STATUS getStatus() {
		return status;
	}
	public void setStatus(STATUS status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public List<ApartmentSearchResponseDTO> getApartmentSearchResponse() {
		return apartmentSearchResponse;
	}
	public void setApartmentSearchResponse(List<ApartmentSearchResponseDTO> apartmentSearchResponse) {
		this.apartmentSearchResponse = apartmentSearchResponse;
	}
	public int getStartingRecordCount() {
		return startingRecordCount;
	}
	public void setStartingRecordCount(int startingRecordCount) {
		this.startingRecordCount = startingRecordCount;
	}
	public int getEndingRecordCount() {
		return endingRecordCount;
	}
	public void setEndingRecordCount(int endingRecordCount) {
		this.endingRecordCount = endingRecordCount;
	}
	public int getTotalRecordsCount() {
		return totalRecordsCount;
	}
	public void setTotalRecordsCount(int totalRecordsCount) {
		this.totalRecordsCount = totalRecordsCount;
	}
	public String getNextPageUrl() {
		return nextPageUrl;
	}
	public void setNextPageUrl(String nextPageUrl) {
		this.nextPageUrl = nextPageUrl;
	}
	
	public void startResponse() {
		startTime = Calendar.getInstance().getTimeInMillis();
	}

	public void endResponse() {
		long endTime = Calendar.getInstance().getTimeInMillis();
		this.setExecutionTime(endTime - this.startTime);
	}
	
}
