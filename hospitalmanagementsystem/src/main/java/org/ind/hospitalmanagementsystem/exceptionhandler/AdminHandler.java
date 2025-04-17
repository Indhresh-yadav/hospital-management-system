package org.ind.hospitalmanagementsystem.exceptionhandler;



import org.ind.hospitalmanagementsystem.exception.EmailNotFound;
import org.ind.hospitalmanagementsystem.exception.InvalidId;
import org.ind.hospitalmanagementsystem.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



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
