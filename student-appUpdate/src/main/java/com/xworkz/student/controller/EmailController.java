package com.xworkz.student.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.student.dto.EmailDTO;
import com.xworkz.student.service.EmailService;
import com.xworkz.student.service.EmailServiceImpl;


@RequestMapping("/")
@Controller
public class EmailController {
private static final Logger logger=Logger.getLogger(EmailController.class.getName());
	
	@Autowired
	private EmailService emailService;
	
	public EmailController() {
		//System.out.println(this.getClass().getSimpleName()+" bean created");
		logger.info(this.getClass().getSimpleName()+" bean created---------------------");
	}
	
	/*
	 * @RequestMapping("/getWelcomePage.student") public String getWelcomePage() {
	 * System.out.println("getWelcomePage() invoked"); return "email"; }
	 */
	@RequestMapping("/emailTemplate.student")
	public String getEmailtemplate() {
		//System.out.println("getEmailtemplate() invoked");
		logger.info("getEmailtemplate() invoked");
		return "emailTemplate";
	}
	
	
	
	@RequestMapping(value = "/sendEmail.student", method = {RequestMethod.GET,RequestMethod.POST})
	public String sendEmail(@ModelAttribute EmailDTO emailDTO, Model model) {
		System.out.println(emailDTO);
		boolean isValidateEmail = this.emailService.validateEmail(emailDTO);
		if (isValidateEmail) {
			boolean isMailSent = this.emailService.sendEmail(emailDTO);
			if (isMailSent) {
				model.addAttribute("msg", "Email sent successfully");
			}
			else {
				model.addAttribute("Errmsg", "something went wrong..try again!!");
			}
		}else {
			model.addAttribute("Errmsg", "entering invalid data!!");
			Map<String, String> map = EmailServiceImpl.map;
			model.addAttribute("Email", map.get("EMAIL"));
			model.addAttribute("Subject", map.get("SUBJECT"));
			model.addAttribute("Desc", map.get("DESCRIPTION"));
			
		}
		return "emailTemplate";
	}
	
	
}
