package com.acme.monitor.controller.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ClientResponse implements Serializable {

	private static final long serialVersionUID = 6014915951738883744L;

	private int client_id;

	private String name;

	public ClientResponse() {
		// TODO Auto-generated constructor stub
	}

	public ClientResponse(int client_id, String name) {
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
