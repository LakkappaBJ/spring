package com.xworkz.train.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.entiy.StudentEntity;
import com.xworkz.train.dao.StudentDAO;
import com.xworkz.train.dto.StudentDTO;

@Component
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	public static Map<String, String> map=new HashMap<>();
	
	public StudentServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " bean created");
	}
	@Override
	public boolean validateData(StudentDTO studentDTO) {
		boolean flag=false;
		try {
			if (!studentDTO.getfirstname().isEmpty()) {
		//	System.out.println("Service layer validate");
			flag=true;
		}else {
			flag=false;
			map.put("firstname", "Firstname cannot be empty");
			return flag;
		}
		
			
		if (!studentDTO.getMiddlename().isEmpty()) {
			flag=true;
		}else {
			flag=false;
			map.put("middlename", "Middlename cannot be empty");
			return flag;
		}
		
		if (!studentDTO.getLastname().isEmpty()) {
			flag=true;
		}else {
			flag=false;
			map.put("lastname", "Lastname cannot be empty");
			return flag;
		}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
		
	}

	@Override
	public boolean saveAllUserData(StudentDTO studentDTO) {
		StudentEntity studentEntity = new StudentEntity(studentDTO.getfirstname(), studentDTO.getMiddlename(),
				studentDTO.getLastname(), studentDTO.getCourse(), studentDTO.getGender(), studentDTO.getCountrycode(),
				studentDTO.getPhone(), studentDTO.getAddress(), studentDTO.getEmail(), studentDTO.getPassword(),
				studentDTO.getPswRepeat());

		boolean isstudentEntitySaved=this.studentDAO.saveStudentDetails(studentEntity);
		return isstudentEntitySaved;
	}
	//-----------------------------------------searching---------------------------
	
	@Override
	public boolean validateStudentData(String studentName) {
		boolean flag = false;
		try {
			if (!studentName.isEmpty() && studentName != null) {
				flag = true;
				System.out.println("studentName valid ");
			} else {
				flag = false;
			}

		} catch (Exception e) {
			System.out.println("Invalid studentname");
		}

		return flag;
	}

	@Override
	public StudentEntity findStudentEntityByStudentName(String studentName) {

		System.out.println("findStudentEntityByStudentName() invoked by " + this.getClass().getSimpleName());
		return this.studentDAO.findStudentEntityByStudentName(studentName);
	}
	

	
	/*
	 * 
	 * @Override public boolean validateData(String ufirstname, String middlename,
	 * String lastname, String course, String gender, long countrycode, String
	 * phone, String address, String email, String password, String pswRepeat) {
	 * boolean flag = false; if(ufirstname!=null) { flag=true; } return flag; }
	 * 
	 * @Override public boolean saveUserData(String ufirstname, String middlename,
	 * String lastname, String course, String gender, long countrycode, String
	 * phone, String address, String email, String password, String pswRepeat) {
	 * 
	 * return false;
	 * 
	 */

	


}
