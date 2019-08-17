package com.acme.monitor.util;

public class Constants {

	// TODO : move some of value to adempier.properties for dynamic chages
	public static final int ACCESS_TOKEN_VALIDITY_MINUTES = 30; // minutes
	public static final long ACCESS_TOKEN_VALIDITY = (ACCESS_TOKEN_VALIDITY_MINUTES * 60 * 1000); // milliseconds
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
}
