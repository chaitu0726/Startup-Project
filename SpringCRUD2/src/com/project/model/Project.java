package com.project.model;

public class Project {
	
	private int projetcId;
	private String projectName;
	private String projectTechnology;
	private String projectDuration;
	private String projectDescription;
	private String projectBidAmount;
	private int comapanyId;
	private String flag;
	
	public Project() {
		super();
	}

	public Project(int projetcId, String projectName, String projectTechnology, String projectDuration,
			String projectDescription, String projectBidAmount, int comapanyId, String flag) {
		super();
		this.projetcId = projetcId;
		this.projectName = projectName;
		this.projectTechnology = projectTechnology;
		this.projectDuration = projectDuration;
		this.projectDescription = projectDescription;
		this.projectBidAmount = projectBidAmount;
		this.comapanyId = comapanyId;
		this.flag = flag;
	}

	public int getProjetcId() {
		return projetcId;
	}

	public void setProjetcId(int projetcId) {
		this.projetcId = projetcId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectTechnology() {
		return projectTechnology;
	}

	public void setProjectTechnology(String projectTechnology) {
		this.projectTechnology = projectTechnology;
	}

	public String getProjectDuration() {
		return projectDuration;
	}

	public void setProjectDuration(String projectDuration) {
		this.projectDuration = projectDuration;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectBidAmount() {
		return projectBidAmount;
	}

	public void setProjectBidAmount(String projectBidAmount) {
		this.projectBidAmount = projectBidAmount;
	}

	public int getComapanyId() {
		return comapanyId;
	}

	public void setComapanyId(int comapanyId) {
		this.comapanyId = comapanyId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	

}
