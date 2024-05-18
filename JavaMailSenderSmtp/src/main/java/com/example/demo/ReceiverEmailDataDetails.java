package com.example.demo;


public class ReceiverEmailDataDetails {
	
	private String receiverEmailId;
	private String emailContent;
	private String emailSubjectHeading;
	
	public ReceiverEmailDataDetails(String receiverEmailId, String emailContent, String emailSubjectHeading) {
		this.receiverEmailId = receiverEmailId;
		this.emailContent = emailContent;
		this.emailSubjectHeading = emailSubjectHeading;
	}
	
	
	public ReceiverEmailDataDetails() {
	}


	public String getReceiverEmailId() {
		return receiverEmailId;
	}
	public void setReceiverEmailId(String receiverEmailId) {
		this.receiverEmailId = receiverEmailId;
	}
	public String getEmailContent() {
		return emailContent;
	}
	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}
	public String getEmailSubjectHeading() {
		return emailSubjectHeading;
	}
	public void setEmailSubjectHeading(String emailSubjectHeading) {
		this.emailSubjectHeading = emailSubjectHeading;
	}
	
	
	@Override
	public String toString() {
		return "ReceiverEmailData [receiverEmailId=" + receiverEmailId + ", emailContent=" + emailContent
				+ ", emailSubjectHeading=" + emailSubjectHeading + "]";
	}
	
	
	
	

}
