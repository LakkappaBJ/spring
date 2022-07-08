package com.xworkz.coreSpring;

public class Coach {
	String name;

	public Coach(String name) {
		this.name=name;
		System.out.println(name);
		System.out.println(this.getClass().getSimpleName()+" Object is created");	}
}
