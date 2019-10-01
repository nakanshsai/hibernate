package com.zensar.exception;

public class ServiceExceptions extends Exception {
	
	private String errorMessage;

	public  ServiceExceptions() {
		errorMessage="error:Service exception";
		 
	}
	
	public  ServiceExceptions(String errorMessage) {
		super();
		this.errorMessage=errorMessage;
		 
	}

	@Override
	public String toString() {
		return "ServiceException [errorMessage=" + errorMessage + "]";
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	

}
