package com.xworkz.ormModule;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.ormModule.dao.StudentDAOImpl;
import com.xworkz.ormModule.dto.StudentEntity;

public class TesterORM {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationConext.xml");
		StudentDAOImpl studentDAOImpl = applicationContext.getBean(StudentDAOImpl.class);
		StudentEntity studentEntity = new StudentEntity();
		studentDAOImpl.showAll(studentEntity);

	}

}
