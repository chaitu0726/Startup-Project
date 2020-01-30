package com.project.model;
public class Funding {

	private int fundId;
	private int startupId;
	private int companyId;
	private double fundAmount;
	private String fundStatus;
	private String fundDescription;
	private String flag;
	
	public Funding() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Funding(int fundId, int startupId, int companyId, double fundAmount, String fundStatus,
			String fundDescription, String flag) {
		super();
		this.fundId = fundId;
		this.startupId = startupId;
		this.companyId = companyId;
		this.fundAmount = fundAmount;
		this.fundStatus = fundStatus;
		this.fundDescription = fundDescription;
		this.flag = flag;
	}

	public int getFundId() {
		return fundId;
	}

	public void setFundId(int fundId) {
		this.fundId = fundId;
	}

	public int getStartupId() {
		return startupId;
	}
	public void setStartupId(int startupId) {
		this.startupId = startupId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public double getFundAmount() {
		return fundAmount;
	}
	public void setFundAmount(double fundAmount) {
		this.fundAmount = fundAmount;
	}
	public String getFundStatus() {
		return fundStatus;
	}
	public void setFundStatus(String fundStatus) {
		this.fundStatus = fundStatus;
	}
	public String getFundDescription() {
		return fundDescription;
	}
	public void setFundDescription(String fundDescription) {
		this.fundDescription = fundDescription;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

}