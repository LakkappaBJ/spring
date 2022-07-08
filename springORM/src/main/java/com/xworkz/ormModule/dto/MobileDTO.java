package com.xworkz.ormModule.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
//@NamedQuery(name="MobileDTO.getAll",query = "SELECT * FROM sakila.mobiledetails")
@Entity
@Table(name = "mobiledetails")
public class MobileDTO {
	@Column(name = "MOBID")
	private int mobId;
	@Column(name = "MODELNAME")
	private String medelName;
	@Column(name = "MODELNO")
	private String modelNo;
	@Column(name = "MEMORY")
	private String memory;
	@Column(name = "BATTERYCAPACITY")
	private String batteryCapacity;

	public MobileDTO() {
		// TODO Auto-generated constructor stub
	}

	public MobileDTO(int mobId, String medelName, String modelNo, String memory, String batteryCapacity) {
		super();
		this.mobId = mobId;
		this.medelName = medelName;
		this.modelNo = modelNo;
		this.memory = memory;
		this.batteryCapacity = batteryCapacity;
	}

	@Override
	public String toString() {
		return "MobileDTO [mobId=" + mobId + ", medelName=" + medelName + ", modelNo=" + modelNo + ", memory=" + memory
				+ ", batteryCapacity=" + batteryCapacity + "]";
	}

}
