package com.xworkz.train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
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
		return "/WEB-INF/train.jsp";
	}

	@RequestMapping(value = "/readValuesFromPage")
	public String readValuesFromPage(@RequestParam int trainNo, @RequestParam String trainName, Model model) {
		System.out.println("readValuesFromPage() invoked");
		System.out.println("trainNo= " + trainNo);
		System.out.println("trainName= " + trainName);
		boolean saveData = trainService.saveData(trainNo, trainName);

		if (saveData) {
			System.out.println("User data is valid..");
		} else {
			System.out.println("User data is not valid.");
			model.addAttribute("errorMsg", "Enter valid user data");
		}
		return "/WEB-INF/train.jsp";
	}

	@RequestMapping("/getAllTrains")
	public String getImg() {
		System.out.println("getAllTrains() invoked ");
		trainService.getAllTrains();
		return "/WEB-INF/ReadAllTrains.html";
	}
	
}
