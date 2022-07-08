package com.xworkz.hibernateToSpring.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.hibernateToSpring.dao.MobileDAOImpl;
import com.xworkz.hibernateToSpring.dto.MobileEntity;

public class MobileTester {

	public static void main(String[] args) {
		// MobileDAOImpl mobileDAOImpl = new MobileDAOImpl();
		// mobileDAOImpl.getAllMobiles();

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContexts.xml");
		MobileDAOImpl daoImpl = applicationContext.getBean(MobileDAOImpl.class);
		daoImpl.getAllMobiles();
		

	}

}
