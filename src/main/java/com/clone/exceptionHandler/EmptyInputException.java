package com.clone.exceptionHandler;

/**** Author:Sumit *****/

public class EmptyInputException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public EmptyInputException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

}
