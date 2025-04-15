package com.ind.hospitalmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ind.hospitalmanagementsystem.dao.DoctorDao;
import com.ind.hospitalmanagementsystem.dto.Doctor;
import com.ind.hospitalmanagementsystem.dto.Patient;
import com.ind.hospitalmanagementsystem.exception.DoctorId;
import com.ind.hospitalmanagementsystem.util.Email;
import com.ind.hospitalmanagementsystem.util.ResponseStructure;

@Service
public class DoctorService {
	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private Email email;
	ResponseStructure<List<Doctor>> listStructure=new ResponseStructure<List<Doctor>>();
	ResponseStructure<Doctor> responseStructure=new ResponseStructure<Doctor>();
	ResponseStructure<List<Patient>> structure=new ResponseStructure<List<Patient>>();
	// to save the doctor details
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(Doctor doctor){
		responseStructure.setData(doctorDao.saveDoctor(doctor));
		responseStructure.setMsg("Doctors data insereted");
		responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
		email.doctorRegisterMail(doctor.getEmail());
		return new ResponseEntity<ResponseStructure<Doctor>>(responseStructure,HttpStatus.ACCEPTED);
	}
	// to find the doctor details
	
	public ResponseEntity<ResponseStructure<Doctor>> findById(Integer id){
		Doctor doctorId=doctorDao.findById(id);
		if(doctorId!=null) {
			responseStructure.setData(doctorId);
			responseStructure.setMsg("doctor detailed fetched sucessfully");
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Doctor>>(responseStructure,HttpStatus.ACCEPTED);
		}else {
			throw new DoctorId("doctor id not found");
		}
	}
	// to fetch all doctor details
	public ResponseEntity<ResponseStructure<List<Doctor>>> findAll(){
		List<Doctor> doctorDetails=doctorDao.findAll();
		if(doctorDetails!=null) {
			listStructure.setData(doctorDetails);
			listStructure.setMsg("doctor details fetched sucessfully");
			listStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<List<Doctor>>>(listStructure,HttpStatus.ACCEPTED);
		}else {
			throw new DoctorId("doctors details fetched failed");
		}
	}
	// to update the doctor details
	public ResponseEntity<ResponseStructure<Doctor>> updateDoctor(Doctor doctor){
		Doctor updateDoctor=doctorDao.findById(doctor.getDid());
		if(updateDoctor!=null) {
			responseStructure.setData(doctorDao.saveDoctor(doctor));
			responseStructure.setMsg("doctor specilization sucessfully");
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			email.doctorRegisterMail(doctor.getEmail());
			return new ResponseEntity<ResponseStructure<Doctor>>(responseStructure,HttpStatus.ACCEPTED);
		}else {
			throw new DoctorId("doctor id is not found");
		}
	}
	
	// to delete doctor details
	
	public ResponseEntity<ResponseStructure<Doctor>> deleteDoctor(Integer id){
		Doctor  deleteDoctor=doctorDao.findById(id);
		if(deleteDoctor!=null) {
			doctorDao.deleteDoctor(id);
			responseStructure.setData(deleteDoctor);
			responseStructure.setMsg("doctor details deleted sucessfully");
			responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
			return  new ResponseEntity<ResponseStructure<Doctor>>(responseStructure,HttpStatus.NO_CONTENT);
		}else {
			throw new DoctorId("doctor id not found");
		}
	}
	//to login
	
	public ResponseEntity<ResponseStructure<Doctor>> loginDoctor(String email,String password){
		Doctor loginDoctor=doctorDao.loginEmail(email);
		if(loginDoctor!=null && loginDoctor.getPassword().equals(password)) {
			
			responseStructure.setData(loginDoctor);
			responseStructure.setMsg("login sucessfilly");
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Doctor>>(responseStructure,HttpStatus.ACCEPTED);
		}else {
			throw new DoctorId("invalid  email");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Patient>>> fetchPatient(int did){
		Doctor doctor=doctorDao.findById(did);
		if(doctor!=null) {
			List<Patient> patients=doctor.getPatients();
			structure.setData(patients);
			structure.setMsg("Patient details");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Patient>>>(structure,HttpStatus.FOUND);
		} else {
			throw new DoctorId("not found");
		}
	}
	
}


















