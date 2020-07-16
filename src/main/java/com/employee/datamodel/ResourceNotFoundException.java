package com.employee.datamodel;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -326361694189849060L;
	private String errorCode;
	private String message;
	private Object resourceMissing;
	
	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String errorCode, String message, Object resourceMissing) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.resourceMissing = resourceMissing;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResourceMissing() {
		return resourceMissing;
	}

	public void setResourceMissing(Object resourceMissing) {
		this.resourceMissing = resourceMissing;
	}
	
	
	
}
