package com.clone.exceptionHandler;

/**** Author:Sumit *****/
public class invalidCredentials extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public invalidCredentials(String errorMessage) {
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
