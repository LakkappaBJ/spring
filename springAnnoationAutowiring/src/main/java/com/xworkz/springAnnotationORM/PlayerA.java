package com.xworkz.springAnnotationORM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class PlayerA {
	@Autowired
	CoachA coach;

	public PlayerA(	 CoachA coach) {
		this.coach = coach;
		System.out.println("PlayerA Bean");
	}

	public PlayerA() {
		System.out.println(this.getClass().getSimpleName() + " object/bean created");
	}
}
