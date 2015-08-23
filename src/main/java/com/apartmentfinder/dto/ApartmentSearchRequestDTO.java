/**
 * 
 */
package com.apartmentfinder.dto;



/**
 * @author singh_sh
 *
 */
public class ApartmentSearchRequestDTO {

	private String apartmentType;
	private String numberOfBathrooms;
	private String minCost;
	private String maxCost;
	private String emailId;
	private String phoneNumber;
	private Boolean rentControlled;
	private String selectedCityCraiglistUrl;
	private String nextPageUrl;
	
	public String getApartmentType() {
		return apartmentType;
	}
	public void setApartmentType(String apartmentType) {
		this.apartmentType = apartmentType;
	}
	public String getNumberOfBathrooms() {
		return numberOfBathrooms;
	}
	public void setNumberOfBathrooms(String numberOfBathrooms) {
		this.numberOfBathrooms = numberOfBathrooms;
	}
	public String getMinCost() {
		return minCost;
	}
	public void setMinCost(String minCost) {
		this.minCost = minCost;
	}
	public String getMaxCost() {
		return maxCost;
	}
	public void setMaxCost(String maxCost) {
		this.maxCost = maxCost;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Boolean isRentControlled() {
		return rentControlled;
	}
	public void setRentControlled(Boolean rentControlled) {
		this.rentControlled = rentControlled;
	}

	
//	public static void sendEmailNotifications(String msgBody){
//		
//		// Assuming you are sending email from localhost
//	      String host = "localhost";
//
//	      // Get system properties
//	      Properties properties = System.getProperties();
//
//	      // Setup mail server
//	      properties.setProperty("mail.smtp.host", host);
//
//	      // Get the default Session object.
//	      Session session = Session.getDefaultInstance(properties);
//	      
//		try {
//            Message msg = new MimeMessage(session);
//			msg.setFrom(new InternetAddress("test_craiglist01@mailinator.com", "Example.com Admin"));
//            msg.addRecipient(Message.RecipientType.TO,new InternetAddress("test_craiglist@mailinator.com", "Mr. User"));
//            msg.setSubject("Your Example.com account has been activated");
//            msg.setText(msgBody);
//            Transport.send(msg);
//
//        } catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}catch (AddressException e) {
//			e.printStackTrace();        
//		} catch (MessagingException e) {
//        	e.printStackTrace();
//        }
//	}

	
	public String getSelectedCityCraiglistUrl() {
		return selectedCityCraiglistUrl;
	}
	public void setSelectedCityCraiglistUrl(String selectedCityCraiglistUrl) {
		this.selectedCityCraiglistUrl = selectedCityCraiglistUrl;
	}
	public String getNextPageUrl() {
		return nextPageUrl;
	}
	public void setNextPageUrl(String nextPageUrl) {
		this.nextPageUrl = nextPageUrl;
	}
	
			
			
}
