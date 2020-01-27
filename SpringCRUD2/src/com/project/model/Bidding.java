package com.project.model;

public class Bidding {

	private int bidId;
	private int projectId;
	private int companyId;
	private int startupId;
	private double bidAmount;
	private String bidDuration;
	private String bidStatus;
	
	
	
	
	public Bidding() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Bidding(int bidId, int projectId, int companyId, int startupId, double bidAmount, String bidDuration,
			String bidStatus) {
		super();
		this.bidId = bidId;
		this.projectId = projectId;
		this.companyId = companyId;
		this.startupId = startupId;
		this.bidAmount = bidAmount;
		this.bidDuration = bidDuration;
		this.bidStatus = bidStatus;
	}




	public int getBidId() {
		return bidId;
	}




	public void setBidId(int bidId) {
		this.bidId = bidId;
	}




	public int getProjectId() {
		return projectId;
	}




	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}




	public int getCompanyId() {
		return companyId;
	}




	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}




	public int getStartupId() {
		return startupId;
	}




	public void setStartupId(int startupId) {
		this.startupId = startupId;
	}




	public double getBidAmount() {
		return bidAmount;
	}




	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}




	public String getBidDuration() {
		return bidDuration;
	}




	public void setBidDuration(String bidDuration) {
		this.bidDuration = bidDuration;
	}




	public String getBidStatus() {
		return bidStatus;
	}

	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}
	
	
	
}
