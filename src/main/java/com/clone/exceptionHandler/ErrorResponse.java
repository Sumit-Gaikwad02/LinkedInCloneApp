package com.clone.exceptionHandler;

/**** Author:Sumit *****/

public class ErrorResponse {
	private int status;
	private String errorMessage;
	private long timestamp;

	// Constructor
	public ErrorResponse(int status, String errorMessage, long timestamp) {
		this.status = status;
		this.errorMessage = errorMessage;
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
