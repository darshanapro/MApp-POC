package com.acme.monitor.controller.response;

import java.io.Serializable;

public class LoginReponse implements Serializable {

	private static final long serialVersionUID = 3564126484762686875L;

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LoginReponse() {
		// TODO Auto-generated constructor stub
	}

	public LoginReponse(String token) {
		super();
		this.token = token;
	}

}
