package com.xworkz.coreSpring.Tester;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Coach coach = new Coach("Lucky");
//		Player player = new Player(coach);
//		Team team = new Team(player);
//		Sport sport = new Sport(team);
//		System.out.println(sport);
	}

}
