package com.ind.hospitalmanagementsystem.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ind.hospitalmanagementsystem.exception.DoctorId;
import com.ind.hospitalmanagementsystem.util.ResponseStructure;

@RestControllerAdvice
public class DoctorExceptionHandler {
	ResponseStructure<String> responseStructure=new ResponseStructure<String>();
	@ExceptionHandler(DoctorId.class)
	public ResponseEntity<ResponseStructure<String>> doctotIdNotFound(DoctorId doctorId){
		responseStructure.setData(doctorId.getMessage());
		responseStructure.setMsg("Your Enter Id is Invalid");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
}
