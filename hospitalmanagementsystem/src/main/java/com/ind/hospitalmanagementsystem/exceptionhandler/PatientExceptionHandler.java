package com.ind.hospitalmanagementsystem.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ind.hospitalmanagementsystem.exception.InvalidEmail;
import com.ind.hospitalmanagementsystem.exception.PatientId;
import com.ind.hospitalmanagementsystem.util.ResponseStructure;

@RestControllerAdvice
public class PatientExceptionHandler {
	ResponseStructure<String> responseStructure=new ResponseStructure<String>();
	
	@ExceptionHandler(PatientId.class)
	public ResponseEntity<ResponseStructure<String>> patientIdNotFound(PatientId patientId){
		responseStructure.setData(patientId.getMessage());
		responseStructure.setData("invalid id");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<String>> invalidEmail(InvalidEmail invalidEmail){
		responseStructure.setData(invalidEmail.getMessage());
		responseStructure.setMsg("invalid mail are password");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
}
