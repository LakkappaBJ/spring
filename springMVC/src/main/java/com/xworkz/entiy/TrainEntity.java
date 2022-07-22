package com.xworkz.entiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@NamedQueries({
	@NamedQuery(name = "getAll", query = "from TrainEntity")	
})
@Entity
@Table(name = "train")
public class TrainEntity {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TNO")
	private int trainNo;

	@Column(name = "TNAME")
	private String trainName;

	public TrainEntity() {
		//System.out.println(this.getClass().getSimpleName() + " invoked");
	}

	public TrainEntity(int trainNo, String trainName) {
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
		return "TrainEntity [trainNo=" + trainNo + ", trainName=" + trainName + "]";
	}
}
