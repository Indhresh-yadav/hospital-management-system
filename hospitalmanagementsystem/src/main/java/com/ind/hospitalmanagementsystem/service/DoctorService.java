package com.ind.hospitalmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ind.hospitalmanagementsystem.dao.DoctorDao;
import com.ind.hospitalmanagementsystem.dto.Admin;
import com.ind.hospitalmanagementsystem.dto.Doctor;
import com.ind.hospitalmanagementsystem.exception.EmailNotFound;
import com.ind.hospitalmanagementsystem.exception.InvalidId;
import com.ind.hospitalmanagementsystem.util.EmailService;
import com.ind.hospitalmanagementsystem.util.ResponseStructure;

@Service
public class DoctorService {
	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private EmailService emailService;
	
	ResponseStructure<Doctor> structure=new ResponseStructure<Doctor>();
	ResponseStructure<List<Doctor>> liStructure=new ResponseStructure<List<Doctor>>();
	// to save 
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(Doctor doctor){
		structure.setData(doctorDao.saveDoctor(doctor));
		structure.setMsg("doctor data insereted sucessfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		//emailService.sendAccountconfirmationMail(doctor.getEmail());
		return new ResponseEntity<ResponseStructure<Doctor>>(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Doctor>> findById(Integer id){
		Doctor doctordb=doctorDao.findById(id);
		if(doctordb!=null) {
			structure.setData(doctordb);
			structure.setMsg("doctor data fetched sucessfully");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			//emailService.sendAccountconfirmationMail(doctor.getEmail());
			return new ResponseEntity<ResponseStructure<Doctor>>(structure,HttpStatus.ACCEPTED);
		}else {
			throw new InvalidId("Id not found");
		}
	}
	public ResponseEntity<ResponseStructure<Doctor>> deleteDoctor(Integer id){
		Doctor doctordb=doctorDao.findById(id);
		if(doctordb!=null) {
			doctorDao.deleteDoctor(id);
			structure.setData(doctordb);
			structure.setMsg("doctor data deleted sucessfully");
			structure.setStatusCode(HttpStatus.NO_CONTENT.value());
			//emailService.sendAccountconfirmationMail(doctor.getEmail());
			return new ResponseEntity<ResponseStructure<Doctor>>(structure,HttpStatus.NO_CONTENT);
		}else {
			throw new InvalidId("Id not found");
		}
	}
	
	
	
	public ResponseEntity<ResponseStructure<Doctor>> doctorLogin(String email, String password){
		Doctor doctorDatabase=doctorDao.doctorLogin(email);
		if(doctorDatabase!=null && doctorDatabase.getPassword().equals(password)) {
			
			structure.setData(doctorDatabase);
			structure.setMsg("doctor login sucess fully");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Doctor>>(structure,HttpStatus.ACCEPTED);
		}else {
			throw new EmailNotFound("email are password incoorect");
		}
	}
	public ResponseEntity<ResponseStructure<Doctor>> updateDoctor(Doctor doctor){
		Doctor updateDoctor=doctorDao.findById(doctor.getDid());
		if(updateDoctor!=null) {
			doctorDao.saveDoctor(doctor);
			structure.setData(updateDoctor);
			structure.setMsg("doctor data deleted sucessfully");
			structure.setStatusCode(HttpStatus.OK.value());
			//emailService.sendAccountconfirmationMail(doctor.getEmail());
			return new ResponseEntity<ResponseStructure<Doctor>>(structure,HttpStatus.OK);
		}else {
			throw new InvalidId("Id not found");
		}
	}
	
	public ResponseEntity<ResponseStructure< List<Doctor>>> fetchAll(){
		liStructure.setData(doctorDao.fetchAll());
		liStructure.setMsg("doctor details fetched sucessfully");
		liStructure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<List<Doctor>>>(liStructure,HttpStatus.ACCEPTED);
		
	}
	
}
