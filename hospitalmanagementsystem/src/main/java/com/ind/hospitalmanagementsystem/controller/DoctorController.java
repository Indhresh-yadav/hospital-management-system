package com.ind.hospitalmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ind.hospitalmanagementsystem.dto.Doctor;
import com.ind.hospitalmanagementsystem.dto.Patient;
import com.ind.hospitalmanagementsystem.service.DoctorService;
import com.ind.hospitalmanagementsystem.util.ResponseStructure;

@RestController
@RequestMapping("/indhreshyadav")
@CrossOrigin(origins = "*"  , methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.PATCH,RequestMethod.DELETE})
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	// to save the doctor details
	@PostMapping("/adddoctor")
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(@RequestBody Doctor doctor){
		return doctorService.saveDoctor(doctor);
	}
	// to find the doctors details based on id
	@GetMapping("/find/{id}")
	public ResponseEntity<ResponseStructure<Doctor>> findById(@PathVariable Integer id){
		return doctorService.findById(id);
	}
	// to update doctor details
	@GetMapping("/fetchdoctors")
	public ResponseEntity<ResponseStructure<List<Doctor>>> findAll(){
		return doctorService.findAll();
	}
	// to update the doctor details
	@PutMapping("/updatedoctor")
	public ResponseEntity<ResponseStructure<Doctor>> updateDoctor(@RequestBody Doctor doctor){
		return doctorService.updateDoctor(doctor);
	}
	// to delete the doctor details
	@DeleteMapping("/deletedoctor/{id}")
	public ResponseEntity<ResponseStructure<Doctor>>  deleteDoctor(@PathVariable Integer id){
		return doctorService.deleteDoctor(id);
	}
	// to login the doctor
	@GetMapping("/doctorlogin")
	public ResponseEntity<ResponseStructure<Doctor>> loginDoctor(@RequestParam String email, @RequestParam String password){
		return doctorService.loginDoctor(email, password);
	}
	
	@GetMapping("/fetchpatientdata/{did}")
	public ResponseEntity<ResponseStructure<List<Patient>>> findPatient(@PathVariable int did) {
		return doctorService.fetchPatient(did);
	}
	
}
