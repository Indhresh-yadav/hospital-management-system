package com.ind.hospitalmanagementsystem.controller;

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

import com.ind.hospitalmanagementsystem.dto.Patient;
import com.ind.hospitalmanagementsystem.service.PatientService;
import com.ind.hospitalmanagementsystem.util.ResponseStructure;

@RestController
@RequestMapping("/indhreshyadav")
@CrossOrigin(origins = "*"  , methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.PATCH,RequestMethod.DELETE})
public class PatientController {
	@Autowired
	private PatientService patientService;
	@PostMapping("/addpatient/{did}")
	public ResponseEntity<ResponseStructure<Patient>> savePatient(@RequestBody Patient patient, @PathVariable int did){
		return patientService.savePatient(patient,did);
	}
	@GetMapping("/findpatient/{id}")
	public ResponseEntity<ResponseStructure<Patient>> findById(@PathVariable Integer id){
		return patientService.findById(id);
	}
	@GetMapping("/loginpatient")
	public ResponseEntity<ResponseStructure<Patient>> loginPatient(@RequestParam String  email,@RequestParam String password){
		return patientService.loginPatient(email, password);
	}
	@DeleteMapping("/deletepatient/{id}")
	public ResponseEntity<ResponseStructure<Patient>> deletePatient(@PathVariable Integer id){
		return patientService.deletePatient(id);
	}
	@PutMapping("/updatepatient")
	public ResponseEntity<ResponseStructure<Patient>> updatePatient(@RequestBody Patient patient){
		return patientService.updatePatient(patient);
	}
}
