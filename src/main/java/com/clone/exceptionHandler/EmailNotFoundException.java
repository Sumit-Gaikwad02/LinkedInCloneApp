package com.clone.exceptionHandler;

/**** Author:Sumit *****/

public class EmailNotFoundException extends RuntimeException {

	private String errorMessage;
	private static final long serialVersionUID = 1L;

	public EmailNotFoundException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
