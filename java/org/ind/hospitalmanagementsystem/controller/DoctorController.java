package org.ind.hospitalmanagementsystem.controller;


import java.util.List;

import org.ind.hospitalmanagementsystem.dto.Doctor;
import org.ind.hospitalmanagementsystem.service.DoctorService;
import org.ind.hospitalmanagementsystem.util.ResponseStructure;
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


@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/indhreshyadav")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@PostMapping("/savedoctor")
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(@RequestBody Doctor doctor){
		return doctorService.saveDoctor(doctor);
	}
	
	@GetMapping("/finddoctor/{id}")
	public ResponseEntity<ResponseStructure<Doctor>> findById(@PathVariable Integer id){
		return doctorService.findById(id);
	}
	
	@DeleteMapping("/deletedoctor/{id}")
	public ResponseEntity<ResponseStructure<Doctor>> deleteDoctor(@PathVariable Integer id){
		return doctorService.deleteDoctor(id);
	}
	
	@GetMapping("/doctorlogin")
	public ResponseEntity<ResponseStructure<Doctor>> adminLogin(@RequestParam  String email ,@RequestParam String password){
		return doctorService.doctorLogin(email, password);
		
	}
	@PutMapping("/updatedoctor")
	public ResponseEntity<ResponseStructure<Doctor>> updateDoctor(@RequestBody Doctor doctor){
		return doctorService.updateDoctor(doctor);
	}
	@GetMapping("/fetchdoctors")
	public ResponseEntity<ResponseStructure<List<Doctor>>> fetchAll(){
		return doctorService.fetchAll();
		
	}


}
