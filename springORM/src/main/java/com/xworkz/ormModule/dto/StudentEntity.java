package com.xworkz.ormModule.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name="student_details")
@NamedQuery(name="StudentEntity.findAll",query = "from StudentEntity")
public class StudentEntity {
	
	@Id
	@Column(name="STUDID")
	private int studentId;
	@Column(name="STUD_NAME")
	private String studentName;
	
	@Column(name="STUD_DEPT")
	private String studentDept;
	
	@Column(name="COURSE")
	private String course;
	
	@Column(name="BLOODGROUP")
	private String bloodGroup;

	public StudentEntity(int studentId, String studentName, String studentDept, String course, String bloodGroup) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDept = studentDept;
		this.course = course;
		this.bloodGroup = bloodGroup;
	}
	
	public StudentEntity() {
		System.out.println("default con");
	}


	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentDept() {
		return studentDept;
	}

	public void setStudentDept(String studentDept) {
		this.studentDept = studentDept;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", studentName=" + studentName + ", studentDept=" + studentDept
				+ ", course=" + course + ", bloodGroup=" + bloodGroup + "]";
	}

}
