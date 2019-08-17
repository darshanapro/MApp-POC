package com.acme.monitor.controller.request;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ClientRequest implements Serializable {

	private static final long serialVersionUID = -2552934931207259571L;

	private int client_id;

	private String name;

	public ClientRequest() {
		// TODO Auto-generated constructor stub
	}

	public ClientRequest(int client_id, String name) {
		super();
		this.client_id = client_id;
		this.name = name;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
