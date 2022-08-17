package com.xworkz.student.service;


import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.student.controller.EmailController;
import com.xworkz.student.dto.EmailDTO;

@Service
public class EmailServiceImpl implements EmailService {
	private static final Logger logger=Logger.getLogger(EmailServiceImpl.class.getName());
	
	@Autowired
	private JavaMailSender javaMailSender;

public EmailServiceImpl() {
	logger.info(this.getClass().getSimpleName()+" bean created");

}
public static Map<String, String> map=new HashMap<>();
	@Override
	public boolean validateEmail(EmailDTO emailDTO) {
		
		boolean flag = false;
		if (!emailDTO.getEmailId().isEmpty() && emailDTO.getEmailId() != null) {
			flag = true;
		} else {
			flag = false;
			logger.info("email is null.. enter valid emailId and it's compulsory");
			map.put("EMAIL", "email is null.. enter valid emailId");
			return flag;
		}

		if (!emailDTO.getSubject().isEmpty() && emailDTO.getSubject() != null) {
			flag = true;
		} else {
			flag = false;
			logger.info("Subject is null");
			map.put("SUBJECT", "subject is null");
			return flag;
		}

		if (!emailDTO.getDescription().isEmpty() && emailDTO.getDescription() != null) {
			flag = true;
		} else {
			flag = false;
			logger.info("description is null.... enter description");
			map.put("DESCRIPTION", "description is null");
			return flag;
		}
		return flag;
	}

	@Override
	public boolean sendEmail(EmailDTO emailDTO) {
		boolean flag=false;
		try {
			logger.info("simpleMailMessage created");
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
			simpleMailMessage.setTo(emailDTO.getEmailId());
			simpleMailMessage.setFrom("sharathXworkz66@outlook.com");
			simpleMailMessage.setSubject(emailDTO.getSubject());
			simpleMailMessage.setText(emailDTO.getDescription());
			logger.debug("simpleMailMessage is created successfully "+simpleMailMessage);
			this.javaMailSender.send(simpleMailMessage);
			flag=true;
			return flag;
		} catch (Exception e) {
			logger.error(e.getMessage().getClass());
			e.printStackTrace();
		}
	
		return flag;
	}

}
