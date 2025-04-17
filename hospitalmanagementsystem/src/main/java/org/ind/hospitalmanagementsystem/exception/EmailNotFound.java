package org.ind.hospitalmanagementsystem.exception;

public class EmailNotFound  extends RuntimeException{

	String msg;

	public EmailNotFound(String msg) {
		super(msg);
		
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

	
	
	
}