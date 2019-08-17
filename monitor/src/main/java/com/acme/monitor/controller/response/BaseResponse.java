package com.acme.monitor.controller.response;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BaseResponse implements Serializable {

	private static final long serialVersionUID = -6335600199054977761L;
	public static final String SUCCESS = "SUCCESS";
	public static final String ERROR = "ERROR";

	@JsonProperty(value = "status")
	private String status;

	@JsonProperty(value = "message")
	private String message;

	private Object data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public BaseResponse() {
		// TODO Auto-generated constructor stub
	}

	public BaseResponse(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public BaseResponse(String status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

}
