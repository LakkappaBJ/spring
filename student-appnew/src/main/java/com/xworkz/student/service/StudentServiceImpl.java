package com.xworkz.student.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.xworkz.student.dao.StudentDAO;
import com.xworkz.student.dto.StudentDTO;
import com.xworkz.student.entity.StudentEntity;

@Service
public class StudentServiceImpl implements StudentService {
	private static StudentEntity studentEntity ;
	@Autowired
	private StudentDAO studentDAO;

	public static Map<String,String> map=new HashMap<>();
	
	public StudentServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " bean created");
	}

	@Override
	public boolean validateData(StudentDTO studentDTO) {
		System.out.println("VALIDATION IS START");
		boolean flag = false;
		if (studentDTO.getFirstname() != null && !studentDTO.getFirstname().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			map.put("firstname", "Firstname cannot be empty");
			return flag;
		}
		if (studentDTO.getMiddlename() != null && !studentDTO.getMiddlename().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			map.put("middlename", "Middlename cannot be empty");
			return flag;
		}

		if (studentDTO.getLastname() != null && !studentDTO.getLastname().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			map.put("lastname", "Lastname cannot be empty");
			return flag;
		}
		if (studentDTO.getCourse() != null && !studentDTO.getCourse().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			map.put("course", "Course cannot be empty");
			return flag;
		}
		
		if (studentDTO.getAddress() != null && !studentDTO.getAddress().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			map.put("address", "address cannot be empty");
			return flag;
		}
	
		return flag;
	}

	@Override
	public boolean saveStudentDetails(StudentDTO studentDTO) {
		boolean saveStudentDetails = false;
		try {
			System.out.println("service method " + studentDTO);
			StudentEntity studentEntity = new StudentEntity();
			BeanUtils.copyProperties(studentDTO, studentEntity);
			System.out.println("all studentDTO properties copied to studentEntity-> " + studentEntity);
			saveStudentDetails = this.studentDAO.saveStudentDetails(studentEntity);
			saveStudentDetails = true;
		} catch (Exception e) {
			System.err.println("DATA NOT PASSED TO DAO");
		}
		return saveStudentDetails;
	}

	@Override
	public boolean validationForSearchByName(String studentName) {
		boolean flag = false;
		if (studentName != null && !studentName.isEmpty()) {
			flag = true;
			System.out.println("--valid studentName--");
		} else {
			flag = false;
			System.err.println("--Invalid studentName--");
		}
		return flag;
	}

	@Override
	public StudentDTO findStudentEntityByStudentName(String studentName) {
		 studentEntity = this.studentDAO.findStudentEntityByStudentName(studentName);
		StudentDTO studentDTO = null;
		if (studentEntity != null) {
			studentDTO=new StudentDTO();
			BeanUtils.copyProperties(studentEntity, studentDTO);
		} else {
			System.out.println("TrainEntity is null...cannot copying");
		}
		return studentDTO;
	}

	@Override
	public List<Object> getAllStudeInfo() {
		ArrayList<Object> listOfObjects=null;
		List<StudentEntity> list = this.studentDAO.getAllStudeInfo();
		if (list!=null && !list.isEmpty() ) {
			listOfObjects = new ArrayList<>();
			for (StudentEntity studentEntity : list) {
			listOfObjects.add(studentEntity);
			System.out.println("----"+studentEntity.toString());
			}
		}
		return listOfObjects;
	}

	@Override
	public boolean validateDeleteByStudentName(String studentName) {
		boolean flag = false;
		if (studentName != null && !studentName.isEmpty()) {
			flag = true;
			System.out.println("--valid studentName--");
		} else {
			flag = false;
			System.err.println("--Invalid studentName--");
		}
		return flag;
	}

	@Override
	public boolean deleteByStudentName(String studentName) {
		boolean deleteByStudentName=false;
		deleteByStudentName = this.studentDAO.deleteByStudentName(studentName);
			return deleteByStudentName;
	}

	@Override
	public boolean updateStudentEntity(StudentDTO studentDTO) {
		//StudentEntity studentEntity = new StudentEntity();
		BeanUtils.copyProperties(studentDTO, studentEntity);
		return this.studentDAO.updateStudentEntityByName(studentEntity);
	}

}
