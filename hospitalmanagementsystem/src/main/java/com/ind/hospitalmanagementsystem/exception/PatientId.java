package com.ind.hospitalmanagementsystem.exception;

public class PatientId  extends RuntimeException{
	String msg;

	public PatientId(String msg) {
		super(msg);;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	
}
