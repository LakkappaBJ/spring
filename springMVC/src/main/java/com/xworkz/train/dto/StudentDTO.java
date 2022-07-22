package com.xworkz.train.dto;

public class StudentDTO {
	
	
	private String firstname;

	private String middlename;

	private String lastname;

	private String course;

	private String gender;

	private long countrycode;

	private String phone;

	private String address;

	private String email;

	private String password;

	private String pswRepeat;

	public StudentDTO(String firstname, String middlename, String lastname, String course, String gender,
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

	public StudentDTO() {
		super();
	}

	public String getfirstname() {
		return firstname;
	}

	public void setfirstname(String firstname) {
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
		return "StudentDTO [firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname
				+ ", course=" + course + ", gender=" + gender + ", countrycode=" + countrycode + ", phone=" + phone
				+ ", address=" + address + ", email=" + email + ", password=" + password + ", pswRepeat=" + pswRepeat
				+ "]";
	}

}
