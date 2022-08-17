package com.xworkz.student.dto;

import org.apache.log4j.Logger;


public class EmailDTO {
	private static final Logger logger=Logger.getLogger(EmailDTO.class.getName());

	private String emailId;
	private String subject;
	private String description;

	public EmailDTO() {
		logger.info(this.getClass().getSimpleName() + " Bean created");
	}

	public EmailDTO(String emailId, String subject, String description) {
		super();
		this.emailId = emailId;
		this.subject = subject;
		this.description = description;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "EmailDTO [emailId=" + emailId + ", subject=" + subject + ", description=" + description + "]";
	}

}
