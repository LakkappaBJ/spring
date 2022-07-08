package com.xworkz.hibernateToSpring.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries({
		@NamedQuery(name = "MobileEntity.getAll", query = "from MobileEntity")
		
})

@Entity
@Table(name = "phoneDetails")
public class MobileEntity {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "MOBID")
	private int mobId;
	@Column(name = "MODELNAME")
	private String modelName;
	@Column(name = "MODELNO")
	private double modelNo;
	@Column(name = "MEMORY")
	private String memory;
	@Column(name = "BATTERYCAPACITY")
	private String batCapacity;

	public MobileEntity() {

	}

	public MobileEntity(int mobId, String modelName, double modelNo, String memory, String batCapacity) {

		this.mobId = mobId;
		this.modelName = modelName;
		this.modelNo = modelNo;
		this.memory = memory;
		this.batCapacity = batCapacity;
	}

	public int getMobId() {
		return mobId;
	}

	public void setMobId(int mobId) {
		this.mobId = mobId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public double getModelNo() {
		return modelNo;
	}

	public void setModelNo(double modelNo) {
		this.modelNo = modelNo;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getBatCapacity() {
		return batCapacity;
	}

	public void setBatCapacity(String batCapacity) {
		this.batCapacity = batCapacity;
	}

	@Override
	public String toString() {
		return "MobileEntity [mobId=" + mobId + ", modelName=" + modelName + ", modelNo=" + modelNo + ", memory="
				+ memory + ", batCapacity=" + batCapacity + "]";
	}

}
