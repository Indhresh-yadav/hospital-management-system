package com.ind.hospitalmanagementsystem.exceptionhandler;

import java.security.InvalidAlgorithmParameterException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ind.hospitalmanagementsystem.exception.EmailNotFound;
import com.ind.hospitalmanagementsystem.exception.InvalidId;
import com.ind.hospitalmanagementsystem.util.ResponseStructure;

@RestControllerAdvice
public class AdminHandler {
	
	ResponseStructure<String> structure=new ResponseStructure<String>();
	@ExceptionHandler(EmailNotFound.class)
	public ResponseEntity<ResponseStructure<String>> invalidEmailPassword(EmailNotFound emailNotFound){
		structure.setData(emailNotFound.getMessage());
		structure.setMsg("email are password invalid");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(InvalidId.class)
	public ResponseEntity<ResponseStructure<String>> invalidEmailPassword(InvalidId invalidId){
		structure.setData(invalidId.getMessage());
		structure.setMsg("email are password invalid");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
 
}
