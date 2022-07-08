package com.xworkz.coreSpring;

public class Sport {
	Team team;

	public Sport(Team team) {
		this.team = team;
		System.out.println(this.getClass().getSimpleName() + " Object is created");
	}

}
