package com.ind.hospitalmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ind.hospitalmanagementsystem.dao.DoctorDao;
import com.ind.hospitalmanagementsystem.dao.PatientDao;
import com.ind.hospitalmanagementsystem.dto.Doctor;
import com.ind.hospitalmanagementsystem.dto.Patient;
import com.ind.hospitalmanagementsystem.exception.DoctorId;
import com.ind.hospitalmanagementsystem.exception.InvalidEmail;
import com.ind.hospitalmanagementsystem.exception.PatientId;
import com.ind.hospitalmanagementsystem.util.Email;
import com.ind.hospitalmanagementsystem.util.ResponseStructure;

@Service
public class PatientService {
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private Email email;
	
	ResponseStructure<Patient> responseStructure=new ResponseStructure<Patient>();
	// to save patient 
	public ResponseEntity<ResponseStructure<Patient>> savePatient(Patient patient,int did){
		Doctor addDoctor=doctorDao.findById(did);
		
		if(addDoctor!=null) {
			patient.setDoctor(addDoctor);
			patientDao.savePatient(patient);
			responseStructure.setData(patient);
			responseStructure.setMsg("patient data  added sucessfully");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			email.patientRegisterMail(patient.getEmail());
			return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.CREATED);
		}else {
			throw new DoctorId("doctor id is not found");
		}
	}
	// to find the patient details
	
	public ResponseEntity<ResponseStructure<Patient>> findById(Integer id){
		Patient patientDetails=patientDao.findById(id);
		if(patientDetails!=null) {
			responseStructure.setData(patientDetails);
			responseStructure.setMsg("patient details fetched sucessfully");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.FOUND);
		}else {
			throw new PatientId("patient is not found");
		}
	}
	
	// to login the patient
	
	public ResponseEntity<ResponseStructure<Patient>> loginPatient(String email,String password){
		Patient patientDetails=patientDao.loginPatient(email);
		if(patientDetails!=null && patientDetails.getPassword().equals(password)) {
			responseStructure.setData(patientDetails);
			responseStructure.setMsg("patient login sucessfully");
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.ACCEPTED);
		}else {
			throw new InvalidEmail("invalid email are password");
		}
	}
	// to delete the patient
	
	public ResponseEntity<ResponseStructure<Patient>> deletePatient(Integer id){
		Patient deletePatient=patientDao.findById(id);
		if(deletePatient!=null) {
			patientDao.deletePatient(id);
			responseStructure.setData(deletePatient);
			responseStructure.setMsg("patient data deleted sucessfully");
			responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
			return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.NO_CONTENT);
		}else {
			throw new PatientId("in valid id");
		}
	}
	// to update the patient delete
	
	public ResponseEntity<ResponseStructure<Patient>> updatePatient(Patient patient){
		Patient updatePatient=patientDao.findById(patient.getPid());
		if(updatePatient!=null) {
			
			responseStructure.setData(patientDao.savePatient(patient));
			responseStructure.setMsg("patint deleted sucessfully");
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Patient>>(responseStructure,HttpStatus.ACCEPTED);
			
		}else {
			throw new PatientId("inavalid id");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
