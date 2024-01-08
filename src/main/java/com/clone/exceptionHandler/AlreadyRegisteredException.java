package com.clone.exceptionHandler;

/**** Author:Sumit *****/

public class AlreadyRegisteredException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public AlreadyRegisteredException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

}
