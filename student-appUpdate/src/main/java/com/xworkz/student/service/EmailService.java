package com.xworkz.student.service;

import com.xworkz.student.dto.EmailDTO;

public interface EmailService {
	boolean validateEmail(EmailDTO emailDTO);
	boolean sendEmail(EmailDTO emailDTO);

}
