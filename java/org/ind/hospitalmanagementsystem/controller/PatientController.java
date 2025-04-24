package org.ind.hospitalmanagementsystem.controller;


import org.ind.hospitalmanagementsystem.dto.Patient;
import org.ind.hospitalmanagementsystem.service.PatientService;
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
public class PatientController {
	@Autowired
	private PatientService patientService;
	@PostMapping("/savepatient/{id}")
	public ResponseEntity<ResponseStructure<Patient>>  savePatient(@RequestBody Patient patient ,@PathVariable Integer id){
		return patientService.savePatient(patient, id);
	}
	
	
	
	@GetMapping("/findpatient/{id}")
	public ResponseEntity<ResponseStructure<Patient>> findById(@PathVariable Integer id){
		return patientService.findById(id);
	}
	
	@DeleteMapping("/deletepatient/{id}")
	public ResponseEntity<ResponseStructure<Patient>> deletePatient(@PathVariable Integer id){
		return patientService.deletePatient(id);
	}
	
	@GetMapping("/loginpatient")
	public ResponseEntity<ResponseStructure<Patient>> adminLogin(@RequestParam  String email ,@RequestParam String password){
		return patientService.patientLogin(email, password);
		
	}
	@PutMapping("/updatepatient")
	public ResponseEntity<ResponseStructure<Patient>> updateDoctor(@RequestBody Patient patient){
		return patientService.updatePatient(patient);
	}

}
