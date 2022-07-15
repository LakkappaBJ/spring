package com.xworkz.train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.train.service.TrainService;

@Component
@RequestMapping("/")
public class TrainController {
	@Autowired
	private TrainService trainService;

	public TrainController() {
		System.out.println(this.getClass().getSimpleName() + " is created");
	}

	@RequestMapping("/getPage")
	public String getPage() {
		System.out.println("getPage() invoked");
		return "/WEB-INF/train.html";
	}

	@RequestMapping(value = "/readValuesFromPage")
	public String readValuesFromPage(@RequestParam int trainNo, @RequestParam String trainName) {
		System.out.println("readValuesFromPage() invoked");
		System.out.println("trainNo= " + trainNo);
		System.out.println("trainName= " + trainName);
		trainService.saveData(trainNo, trainName);
		return "/WEB-INF/train.html";
	}
	
	@RequestMapping("/getAllTrains")
	public String getImg() {
		System.out.println("getAllTrains() invoked ");
		trainService.getAllTrains();
		return "/WEB-INF/ReadAllTrains.html";
	}
}
