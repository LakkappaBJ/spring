package com.xworkz.student.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.student.dto.StudentDTO;
import com.xworkz.student.service.StudentService;
import com.xworkz.student.service.StudentServiceImpl;


@Controller
@RequestMapping("/")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	public StudentController() {
		System.out.println(this.getClass().getSimpleName()+" bean created");
	}
	
	@RequestMapping("/getIndexPage.student")
	public String getIndexPage() {
		System.out.println("getIndexPage() invoked");
		return "index";
	}
	//--------------------SAVE OPERATION----------------------------------
	@RequestMapping(value = "/saveStudentDetails.student",method = RequestMethod.POST )
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
		return "index";
	}
	
	//--------------------SEARCH OPERATION----------------------------------
	@RequestMapping(value = "/searchStudentDetailsByName.student", method = RequestMethod.POST)
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
				model.addAttribute("ErrMsg", " "+studentName+" keyword is not found...!!! try again");
			}
		}else {
			System.err.println("user data not valid");
			model.addAttribute("ErrrMsg", " your empty data is not found... Enter valid data");
		}
		return "index";
	}
	//---------------------------------------------------search method for update puprose-------------------------------------------------------------
	@RequestMapping(value = "/searchForUpdating.student",method = RequestMethod.POST)
	public String searchStudentNameForUpdating(@RequestParam String studentName, Model model) {
		System.out.println("searchForUpdating() invoked "+studentName);
		
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
				model.addAttribute("ErrMsg", " "+studentName+" keyword is not found...!!! try again");
			}
		}else {
			System.err.println("user data not valid");
			model.addAttribute("ErrMsg", " your empty data is not found... Enter valid data");
		}
		return "updateStudent";
	}
	
	//--------------------------------------------getAllStudentDetails------------------------------
	@RequestMapping(value = "/getAllStudentInfo.student",method = RequestMethod.GET)
	public String getAllStudentInfo(Model model) {
		System.out.println("getAllStudentInfo() invoked");
		List<Object> allStudeInfo = this.studentService.getAllStudeInfo();
		model.addAttribute("getAllStudentDetails", allStudeInfo);
		return "index";
	}
	//--------------------------------------------deleteByStudentName------------------------------
	@RequestMapping(value = "/deleteByName.student",method = RequestMethod.POST)
	public String deleteByStudentName(@RequestParam String studentName, Model model) {
		System.out.println("deleteByStudentName() invoked " + studentName);
		boolean isDataValidate = this.studentService.validateDeleteByStudentName(studentName);
		if (isDataValidate) {
			boolean deleteByStudentName = this.studentService.deleteByStudentName(studentName);
			if (deleteByStudentName) {
				model.addAttribute("DeleteSuccess",""+studentName+" is deleted successfully!!");
			} else
				model.addAttribute("DeleteMSG", ""+studentName+" is not found..please valid name");
		} else {
			System.err.println("user not found");
			model.addAttribute("ErrorMsg", "data is not found... Enter valid data");
		}
		return "index";
	}
	
	@RequestMapping(value = "/updateStudentDetails.student",method = RequestMethod.POST)
	public String updateStudentEntity(@ModelAttribute StudentDTO studentDTO,Model model){
		System.out.println("updateStudentDetails() invoked");
		boolean isUserDataValidate = this.studentService.validateData(studentDTO);
		if(isUserDataValidate) {
			boolean isUpdatedStudentEntity = this.studentService.updateStudentEntity(studentDTO);
			if (isUpdatedStudentEntity) {
				System.out.println("User data have been updated in database");
				model.addAttribute("success", " Data is updated successfully ");
			}else {
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
		return "index";
	}
	
}
