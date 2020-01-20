package com.project.bean;

public class StartUp {
	
	private String name;
	private String gstId;
	private long contactNo;
	private String email;
	private String password;
	private String date;
	private String discription;
	private int noOfEmployee;
	private String pan;
	private int startUpId;
	//String email; //fk of user
	
	public StartUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StartUp(String email) {
		super();
		this.email = email;
	}




	
	public StartUp(String name, String gstId, long contactNo, String email, String password, String date,
			String discription, int noOfEmployee, String pan, int startUpId) {
		super();
		this.name = name;
		this.gstId = gstId;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
		this.date = date;
		this.discription = discription;
		this.noOfEmployee = noOfEmployee;
		this.pan = pan;
		this.startUpId = startUpId;
	}

	public int getStartUpId() {
		return startUpId;
	}

	public void setStartUpId(int startUpId) {
		this.startUpId = startUpId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public int getNoOfEmployee() {
		return noOfEmployee;
	}

	public void setNoOfEmployee(int noOfEmployee) {
		this.noOfEmployee = noOfEmployee;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGstId() {
		return gstId;
	}

	public void setGstId(String gstId) {
		this.gstId = gstId;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}
	
	
	
}
