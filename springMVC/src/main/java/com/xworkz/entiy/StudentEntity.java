package com.xworkz.entiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQuery(name = "StudentEntity.getByName",query = "from StudentEntity where firstname=:FirstName")
@Table(name = "student_details")
@Entity
public class StudentEntity {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "FIRSTNAME")
	private String firstname;

	@Column(name = "MIDDLENAME")
	private String middlename;

	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name = "COURSE")
	private String course;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "COUNTRYCODE")
	private long countrycode;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "PSWREPEAT")
	private String pswRepeat;

	public StudentEntity() {
		System.out.println(this.getClass().getSimpleName() + " bean created");
	}

	public StudentEntity(String firstname, String middlename, String lastname, String course, String gender,
			long countrycode, String phone, String address, String email, String password, String pswRepeat) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.course = course;
		this.gender = gender;
		this.countrycode = countrycode;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.password = password;
		this.pswRepeat = pswRepeat;
	}

	public String getUfirstname() {
		return firstname;
	}

	public void setUfirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(long countrycode) {
		this.countrycode = countrycode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPswRepeat() {
		return pswRepeat;
	}

	public void setPswRepeat(String pswRepeat) {
		this.pswRepeat = pswRepeat;
	}

	@Override
	public String toString() {
		return "StudentEntity [ufirstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname
				+ ", course=" + course + ", gender=" + gender + ", countrycode=" + countrycode + ", phone=" + phone
				+ ", address=" + address + ", email=" + email + ", password=" + password + ", pswRepeat=" + pswRepeat
				+ "]";
	}

}
