package com.xworkz.train.service;

import com.xworkz.entiy.StudentEntity;
import com.xworkz.train.dto.StudentDTO;

public interface StudentService {
	public boolean validateData(StudentDTO studentDTO);
	public boolean saveAllUserData(StudentDTO studentDTO);
	public boolean validateStudentData(String studentName);
	public StudentEntity findStudentEntityByStudentName(String studentName);
	
	//public boolean saveUserData(String ufirstname, String middlename, String lastname, String course, String gender,
	//		long countrycode, String phone, String address, String email, String password, String pswRepeat);

	//public boolean validateData(String ufirstname, String middlename, String lastname, String course, String gender,
		//	long countrycode, String phone, String address, String email, String password, String pswRepeat);
}
