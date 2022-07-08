package com.xworkz.springAnnotationORM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SportA {
	
	@Autowired
	private TeamA team;
	
	
	public SportA( TeamA team) {
		this.team = team;
		System.out.println("Sport Bean");
	}

}
