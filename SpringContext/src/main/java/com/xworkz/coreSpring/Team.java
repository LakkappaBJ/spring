package com.xworkz.coreSpring;

public class Team {
	Player player;

	public Team(Player player) {
		this.player = player;
		System.out.println(this.getClass().getSimpleName()+" Object is created");	}
	
}
