package com.ind.hospitalmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ind.hospitalmanagementsystem.dao.DoctorDao;
import com.ind.hospitalmanagementsystem.dao.PatientDao;
import com.ind.hospitalmanagementsystem.dto.Doctor;
import com.ind.hospitalmanagementsystem.dto.Patient;
import com.ind.hospitalmanagementsystem.exception.EmailNotFound;
import com.ind.hospitalmanagementsystem.exception.InvalidId;
import com.ind.hospitalmanagementsystem.util.EmailService;
import com.ind.hospitalmanagementsystem.util.ResponseStructure;

@Service
public class PatientService {
	
	@Autowired
	private PatientDao patientDao;
	@Autowired 
	private DoctorDao doctorDao;
	@Autowired
	private EmailService emailService;
	
	ResponseStructure<Patient> structure=new ResponseStructure<Patient>();
	ResponseStructure<List<Patient>> listsStructure=new ResponseStructure();
//	// to save 
//	public ResponseEntity<ResponseStructure<Patient>> savePatient(Patient patient, Integer id){
//		Doctor optionalDoctor=doctorDao.findById(id);
//		if(optionalDoctor!=null) {
//			
//		        // Set the existing doctor to the patient
//		 patient.setDoctor(optionalDoctor);
//		 structure.setData(patientDao.savePatient(patient));
//			structure.setMsg("patient data insereted sucessfully");
//			structure.setStatusCode(HttpStatus.CREATED.value());
//			//emailService.sendAccountconfirmationMail(doctor.getEmail());
//			return new ResponseEntity<ResponseStructure<Patient>>(structure,HttpStatus.CREATED);
//
//		  
//		}else {
//			throw new InvalidId("doctor is not there");
//		}
//		
//		
//	}
//	
	public ResponseEntity<ResponseStructure<Patient>> savePatient(Patient patient, Integer id) {
	    Doctor existingDoctor = doctorDao.findById(id);
	    
	    if (existingDoctor != null) {
	        // Associate the patient with the found doctor
	        patient.setDoctor(existingDoctor);

	        // Save the patient
	        Patient savedPatient = patientDao.savePatient(patient);

	        // Set response details
	        structure.setData(savedPatient);
	        structure.setMsg("Patient data inserted successfully");
	        structure.setStatusCode(HttpStatus.CREATED.value());

	        return new ResponseEntity<>(structure, HttpStatus.CREATED);
	    } else {
	        throw new InvalidId("Doctor with ID  not found");
	    }
	}
	
	
	
	public ResponseEntity<ResponseStructure<Patient>> findById(Integer id){
		Patient patientdb=patientDao.findById(id);
		if(patientdb!=null) {
			structure.setData(patientdb);
			structure.setMsg("doctor data fetched sucessfully");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			//emailService.sendAccountconfirmationMail(doctor.getEmail());
			return new ResponseEntity<ResponseStructure<Patient>>(structure,HttpStatus.ACCEPTED);
		}else {
			throw new InvalidId("Id not found");
		}
	}
	public ResponseEntity<ResponseStructure<Patient>> deletePatient(Integer id){
		Patient patientdb=patientDao.findById(id);
		if(patientdb!=null) {
			patientDao.deletePatient(id);
			structure.setData(patientdb);
			structure.setMsg("doctor data deleted sucessfully");
			structure.setStatusCode(HttpStatus.NO_CONTENT.value());
			//emailService.sendAccountconfirmationMail(doctor.getEmail());
			return new ResponseEntity<ResponseStructure<Patient>>(structure,HttpStatus.NO_CONTENT);
		}else {
			throw new InvalidId("Id not found");
		}
	}
//	
//	
//	
	public ResponseEntity<ResponseStructure<Patient>> patientLogin(String email, String password){
		Patient patientDatabase=patientDao.patientLogin(email);
		if(patientDatabase!=null && patientDatabase.getPassword().equals(password)) {
			
			structure.setData(patientDatabase);
			structure.setMsg("doctor login sucess fully");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Patient>>(structure,HttpStatus.ACCEPTED);
		}else {
			throw new EmailNotFound("email are password incoorect");
		}
	}
	public ResponseEntity<ResponseStructure<Patient>> updatePatient(Patient patient){
		Patient updatePatient=patientDao.findById(patient.getPid());
		if(updatePatient!=null) {
			patientDao.savePatient(patient);
			structure.setData(updatePatient);
			structure.setMsg("doctor data deleted sucessfully");
			structure.setStatusCode(HttpStatus.OK.value());
			//emailService.sendAccountconfirmationMail(doctor.getEmail());
			return new ResponseEntity<ResponseStructure<Patient>>(structure,HttpStatus.OK);
		}else {
			throw new InvalidId("Id not found");
		}
	}

}
