package org.ind.hospitalmanagementsystem.dao;

import java.util.Optional;

import org.ind.hospitalmanagementsystem.dto.Patient;
import org.ind.hospitalmanagementsystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class PatientDao {
	@Autowired
	private PatientRepository patientRepository;
	
	public Patient savePatient(Patient patient) {
		return  patientRepository.save(patient);
	}
	
	public Patient findById(Integer id) {
		Optional<Patient> patientdb=patientRepository.findById(id);
		
		if(patientdb!=null) {
			 return patientdb.get();
		}else {
			return null;
		}
	}
	public void deletePatient(Integer id) {
		 patientRepository.deleteById(id);
		
	}
	
	 public Patient patientLogin(String email) {
		 return patientRepository.findByEmail(email);
	 }

}
