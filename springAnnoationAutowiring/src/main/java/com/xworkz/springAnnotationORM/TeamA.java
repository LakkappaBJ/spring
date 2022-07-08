package com.xworkz.springAnnotationORM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class TeamA {
	@Autowired
	PlayerA player;

	public TeamA(PlayerA player) {
		this.player = player;
		System.out.println("TeamA ---------");
	}

	public TeamA() {
		System.out.println(this.getClass().getSimpleName() + " object/bean created");
	}
}
