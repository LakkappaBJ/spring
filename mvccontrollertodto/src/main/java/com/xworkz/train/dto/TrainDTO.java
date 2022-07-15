package com.xworkz.train.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "getAll", query = "from TrainDTO")
@Entity
@Table(name = "train")
public class TrainDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TNO")
	private int trainNo;

	@Column(name = "TNAME")
	private String trainName;

	public TrainDTO() {
		//System.out.println(this.getClass().getSimpleName() + " invoked");
	}

	public TrainDTO(int trainNo, String trainName) {
		super();
		this.trainNo = trainNo;
		this.trainName = trainName;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	@Override
	public String toString() {
		return "TrainDTO [trainNo=" + trainNo + ", trainName=" + trainName + "]";
	}
}
