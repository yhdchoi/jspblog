package com.yhdc.jspblog.exception;

public class ApiRequestException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7807050074960861275L;

	public ApiRequestException(String message) {
		super(message);
	}

	public ApiRequestException(String message, Throwable cause) {
		super(message, cause);
	} 

}
