package com.xworkz.train.dao;

import com.xworkz.entiy.StudentEntity;

public interface StudentDAO {
	public boolean saveStudentDetails(StudentEntity studentEntity);

	public StudentEntity findStudentEntityByStudentName(String studentName);
}
