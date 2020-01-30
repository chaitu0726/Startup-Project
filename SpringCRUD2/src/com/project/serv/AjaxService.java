package com.project.serv;

public interface AjaxService {

	public boolean isUsernameExist(String username);
	public boolean isGstExist(String gst);
	public boolean isPanExist(String pan);
	public boolean isGstExistCompany(String gst);
	public boolean isGstExistStartup(String gst);
	
}
