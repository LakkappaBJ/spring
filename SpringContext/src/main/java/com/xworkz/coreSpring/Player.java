package com.xworkz.coreSpring;

public class Player {
	Coach coach;

	public Player(Coach coach) {
		this.coach = coach;
		System.out.println(this.getClass().getSimpleName()+" Object is created");	}

}
