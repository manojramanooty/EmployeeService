package com.employee.datamodel;

public class DuplicateDataException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -128151900842186522L;
	private String errorCode;
	private String errorMessage;
	private Employee availableResource;
	
	public DuplicateDataException() {
		super();
	}

	public DuplicateDataException(String errorCode, String errorMessage, Employee availableResource) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.availableResource = availableResource;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Employee getAvailableResource() {
		return availableResource;
	}

	public void setAvailableResource(Employee availableResource) {
		this.availableResource = availableResource;
	}
	
	
	
}
