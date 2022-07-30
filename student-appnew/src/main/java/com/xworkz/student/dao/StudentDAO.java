package com.xworkz.student.dao;

import java.util.List;

import com.xworkz.student.entity.StudentEntity;

public interface StudentDAO {

	boolean saveStudentDetails(StudentEntity studentEntity);

	StudentEntity findStudentEntityByStudentName(String studentName);

	List<StudentEntity> getAllStudeInfo();

	boolean deleteByStudentName(String studentName);

	boolean updateStudentEntityByName(StudentEntity studentEntity);

}
