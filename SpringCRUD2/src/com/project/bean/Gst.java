package com.project.bean;

public class Gst {
	private String gstId;
	private String name;
	private String pan;
	
	
	public Gst() {
		super();
	}

	public Gst(String gstId) {
		super();
		this.gstId = gstId;
	}

	public Gst(String gstId, String name, String pan) {
		super();
		this.gstId = gstId;
		this.name = name;
		this.pan = pan;
	}


	public String getGstId() {
		return gstId;
	}


	public void setGstId(String gstId) {
		this.gstId = gstId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}
	
}
