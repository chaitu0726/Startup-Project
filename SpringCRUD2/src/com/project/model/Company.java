package com.project.model;

public class Company {

	private String gstId ;
	private String contactNo;
	private String email;
	private String password;
	private String description;
	private int companyId;
	private String compName;
	private String pan;
	
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Company(String gstId, String contactNo, String email, String password, String description, String compName,
			String pan) {
		super();
		this.gstId = gstId;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
		this.description = description;
		this.compName = compName;
		this.pan = pan;
	}


	public Company( String gstId, String contactNo, String email, String password, String description,
			int companyId, String compName, String pan) {
		super();
		
		this.gstId = gstId;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
		this.description = description;
		this.companyId = companyId;
		this.compName = compName;
		this.pan = pan;
	}

	public Company(String email) {
		super();
		this.email = email;
	}


	public String getGstId() {
		return gstId;
	}

	public void setGstId(String gstId) {
		this.gstId = gstId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}	
	
}