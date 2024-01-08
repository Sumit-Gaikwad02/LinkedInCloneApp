package com.clone.exceptionHandler;

import com.clone.exceptionHandler.EmptyInputException;
import com.clone.exceptionHandler.EmailNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**** Author:Sumit *****/
@ControllerAdvice
public class GlobalExceptionHandler {

	// Exception if email is empty while saving student******
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<ErrorResponse> handlemptyInputException(EmptyInputException emptyInputException) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
				emptyInputException.getErrorMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	// Email not found exception*****
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EmailNotFoundException e) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getErrorMessage(),
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}

	// User already registered********
	@ExceptionHandler(AlreadyRegisteredException.class)
	public ResponseEntity<ErrorResponse> handleEntityNotFoundException(AlreadyRegisteredException e) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getErrorMessage(),
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}

//Id not found Exception****  
	@ExceptionHandler(invalidCredentials.class)
	public ResponseEntity<ErrorResponse> handleIdNotFoundException(invalidCredentials e) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getErrorMessage(),
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneralException(Exception e) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"An error occurred: " + e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}
}
