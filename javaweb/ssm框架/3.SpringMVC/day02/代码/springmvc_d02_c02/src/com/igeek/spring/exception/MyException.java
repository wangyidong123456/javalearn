package com.igeek.spring.exception;

public class MyException extends Exception{
	private String message;

	public MyException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

	
	
	
}
