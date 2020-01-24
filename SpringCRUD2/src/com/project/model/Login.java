package com.project.model;

public class Login {

		private String username;
		private String password;
		private int flag;
		
		public Login() {
			super();
			// TODO Auto-generated constructor stub
		}

		
		public Login(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}


		public Login(String username, String password, int flag) {
			super();
			this.username = username;
			this.password = password;
			this.flag = flag;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public int getFlag() {
			return flag;
		}


		public void setFlag(int flag) {
			this.flag = flag;
		}
		
		
		
		
}
