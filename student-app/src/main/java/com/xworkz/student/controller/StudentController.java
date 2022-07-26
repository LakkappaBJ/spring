package com.xworkz.student.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.student.dto.StudentDTO;
import com.xworkz.student.service.StudentService;
import com.xworkz.student.service.StudentServiceImpl;


@Component
@RequestMapping("/")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	public StudentController() {
		System.out.println(this.getClass().getSimpleName()+" bean created");
	}
	
	@RequestMapping("/getIndexPage")
	public String getIndexPage() {
		System.out.println("getIndexPage() invoked");
		return "/WEB-INF/index.jsp";
	}
	//--------------------SAVE OPERATION----------------------------------
	@RequestMapping("/saveStudentDetails")
	public String saveStudentDetails(@ModelAttribute StudentDTO studentDTO,Model model) {
		System.out.println("savestudentDetails() invoked");
		System.out.println("Reading data from page to Controller = " +studentDTO);
		boolean validateData = this.studentService.validateData(studentDTO);
		if (validateData) {
			boolean saveStudentDetails = this.studentService.saveStudentDetails(studentDTO);
			if (saveStudentDetails) {
				System.out.println("User data have been stored in database");
				model.addAttribute("success", " Data is stored successfully ");
			}
			else {
				System.err.println("User data not valid");
			}
		}else {
			System.err.println("Controller Student data is not valid");
			Map<String, String> map = StudentServiceImpl.map;
			model.addAttribute("FNAME", map.get("firstname"));
			model.addAttribute("MNAME", map.get("middlename"));
			model.addAttribute("LNAME", map.get("lastname"));
			model.addAttribute("COURSE", map.get("course"));
			model.addAttribute("ADDRESS", map.get("address"));
		}
		return "/WEB-INF/index.jsp";
	}
	
	//--------------------SEARCH OPERATION----------------------------------
	@RequestMapping("/searchStudentDetailsByName")
	public String searchStudentDetailsByName(@RequestParam String studentName, Model model) {
		System.out.println("searchStudentDetailsByName() invoked "+studentName);
		
		boolean validationForSearchByName = this.studentService.validationForSearchByName(studentName);
		if (validationForSearchByName) {
			StudentDTO studentDTO = this.studentService.findStudentEntityByStudentName(studentName);
			System.out.println("@@@@@@@@@@ "+studentDTO);
			if (studentDTO!=null) {
				model.addAttribute("FISRName", studentDTO.getFirstname());
				model.addAttribute("Middlename", studentDTO.getMiddlename());
				model.addAttribute("Lastname", studentDTO.getLastname());
				model.addAttribute("Course", studentDTO.getCourse());
				model.addAttribute("Gender", studentDTO.getGender());
				model.addAttribute("Countrycode", studentDTO.getCountrycode());
				model.addAttribute("Phone", studentDTO.getPhone());
				model.addAttribute("Address", studentDTO.getAddress());
				model.addAttribute("Email", studentDTO.getEmail());
				model.addAttribute("Password", studentDTO.getPassword());
				model.addAttribute("PswRepeat", studentDTO.getPswRepeat());
			}else {
				model.addAttribute("ErrMsg", "Search not found "+studentName+" try again");
			}
		}else {
			System.err.println("user data not valid");
		}
		return "/WEB-INF/index.jsp";
	}
	//--------------------------------------------getAllStudentDetails------------------------------
	@RequestMapping("/getAllStudentInfo")
	public String getAllStudentInfo(Model model) {
		System.out.println("getAllStudentInfo() invoked");
		List<Object> allStudeInfo = this.studentService.getAllStudeInfo();
		model.addAttribute("getAllStudentDetails", allStudeInfo);
		return "/WEB-INF/index.jsp";
	}
	//--------------------------------------------deleteByName------------------------------
	@RequestMapping("/deleteByName")
	public String deleteByName(@RequestParam String studentName, Model model) {
		System.out.println("deleteByName() invoked " + studentName);
		boolean deleteByName = this.studentService.validateDeleteByName(studentName);
		if (deleteByName) {
			boolean deleteByName2 = this.studentService.deleteByName(studentName);
			System.out.println(deleteByName2 +" getting inside controller");
			if (deleteByName2) {
				model.addAttribute("DeleteSuccess",""+studentName+" is deleted successfully!!");
			} else
				model.addAttribute("DeleteMSG", "delete "+studentName+"  not found..please valid name");
		} else {
			System.out.println("user not found");
		}
		return "/WEB-INF/index.jsp";
	}
}
