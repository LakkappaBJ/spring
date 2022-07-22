package com.xworkz.train.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.entiy.StudentEntity;
import com.xworkz.train.dto.StudentDTO;
import com.xworkz.train.service.StudentService;
import com.xworkz.train.service.StudentServiceImpl;


@RequestMapping("/")
@Component
public class StudentController {
	public StudentController() {
		System.out.println(this.getClass().getSimpleName() + " bean created");
	}

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getPage() {
		System.out.println("getPage() invoked");
		return "/WEB-INF/studentAssets/student.jsp";

	}
	//@RequestParam("firstname") String ufirstname,
	//@RequestParam("middlename") String middlename, @RequestParam("lastname") String lastname,
	//@RequestParam("course") String course, @RequestParam String gender, @RequestParam long countrycode,
	//@RequestParam String phone, @RequestParam("address") String address, @RequestParam String email,
	//@RequestParam("psw") String password, @RequestParam String pswRepeat
	
//---------------------------------Inserting data into db-------------------------------
	@RequestMapping(value = "/studentDetails")
	public String saveDataIndb(@ModelAttribute StudentDTO studentDTO, Model model) {
		System.out.println("saveDataIndb() invoked");
		
		System.out.println(studentDTO);
		/*
		 * System.out.println(studentDTO.getfirstname());
		 * System.out.println(studentDTO.getMiddlename());
		 * System.out.println(studentDTO.getLastname());
		 * System.out.println(studentDTO.getCourse());
		 * System.out.println(studentDTO.getGender());
		 * System.out.println(studentDTO.getCountrycode());
		 * System.out.println(studentDTO.getPhone());
		 * System.out.println(studentDTO.getAddress());
		 * System.out.println(studentDTO.getEmail());
		 * System.out.println(studentDTO.getPassword());
		 * System.out.println(studentDTO.getPswRepeat());
		 */
		
	

		boolean isValidateData = this.studentService.validateData(studentDTO);
		if (isValidateData) {
			boolean isSaveUserData = this.studentService.saveAllUserData(studentDTO);
			if (isSaveUserData) {
				System.out.println("User data have been stored in database");
			} else {
				System.out.println("User data not stored in database");
			}
			
		} else {
			System.out.println("User data not valid");
			Map<String, String> map = StudentServiceImpl.map;
			model.addAttribute("FNAME",map.get("firstname"));
			model.addAttribute("MNAME", map.get("middlename"));
			model.addAttribute("LNAME", map.get("lastname"));
		}
		return "/WEB-INF/studentAssets/student.jsp";
	}
	
	//---------------------------------Search and get values-------------------------------
	@RequestMapping("/searchByName")
	public String searchByStudentName(@RequestParam String studentName, Model model) {
		System.out.println("searchByStudentName() invoked "+studentName);
		
		boolean validatestudentData = this.studentService.validateStudentData(studentName);
		if (validatestudentData) {
			StudentEntity studentEntity = this.studentService.findStudentEntityByStudentName(studentName);
			if (studentEntity != null) {

				model.addAttribute("FISRName", studentEntity.getUfirstname());
				model.addAttribute("Middlename", studentEntity.getMiddlename());
				model.addAttribute("Lastname", studentEntity.getLastname());
				model.addAttribute("Course", studentEntity.getCourse());
				model.addAttribute("Gender", studentEntity.getGender());
				model.addAttribute("Countrycode", studentEntity.getCountrycode());
				model.addAttribute("Phone", studentEntity.getPhone());
				model.addAttribute("Address", studentEntity.getAddress());
				model.addAttribute("Email", studentEntity.getEmail());
				model.addAttribute("Password", studentEntity.getPassword());
				model.addAttribute("PswRepeat", studentEntity.getPswRepeat());
			}else {
				model.addAttribute("ErrMsg", "Search not found "+studentName+" \n try again");
			}
		}else {
			model.addAttribute("ErrMsg", "Enter valid student name");
		}
		return "/WEB-INF/studentAssets/student.jsp";
	}
	
}
