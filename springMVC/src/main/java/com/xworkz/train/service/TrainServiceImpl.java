package com.xworkz.train.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.train.dao.TrainDAO;

@Component
public class TrainServiceImpl implements TrainService{
	@Autowired
	private TrainDAO trainDAO;

	public TrainServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " invoked");
	}

	public boolean saveData(int trainNo, String trainName) {
		System.out.println("validation start in Service layer");
		boolean flag = false;
		if (trainNo > 0 && trainName != null) {
			int data = trainDAO.saveData(trainNo, trainName);
			flag = true;
		} else {
			System.out.println("Invalid Credencials");
		}
		return flag;
	}

	@Override
	public void getAllTrains() {
		trainDAO.getAllTrains();
	}


	

}
