package com.xworkz.springAnnotationORM;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class CoachA {
	String name;


	public CoachA(@Value("Lakkappa") String name) {
		
		this.name = name;
		System.out.println(this.getClass().getSimpleName()+" object/bean created");
		System.out.println("name is "+name);
	}
	
}
