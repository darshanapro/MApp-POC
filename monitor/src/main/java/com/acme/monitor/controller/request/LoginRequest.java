package com.acme.monitor.controller.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class LoginRequest implements Serializable {

	private static final long serialVersionUID = -1726044344421706616L;

	@NotNull
	private String username;

	@NotNull
	private String password;

	public LoginRequest() {
		// TODO Auto-generated constructor stub
	}

	public LoginRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
