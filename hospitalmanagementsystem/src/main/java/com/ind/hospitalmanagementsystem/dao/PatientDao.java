package com.ind.hospitalmanagementsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ind.hospitalmanagementsystem.dto.Patient;
import com.ind.hospitalmanagementsystem.repository.PatientRepository;

@Repository
public class PatientDao {
	@Autowired
	private PatientRepository patientRepository;
	//to save the patient
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	// to find the patient details
	public Patient findById(Integer id) {
	 Optional<Patient> patientid=patientRepository.findById(id);
	 if(patientid.isPresent()) {
		return  patientid.get();
	 }else {
		 return null;
	 }
	}
	// to login patient
	public Patient loginPatient(String email) {
		return patientRepository.findByEmail(email);
	}
	// to delete the patient
	
	public void deletePatient(Integer id) {
		patientRepository.deleteById(id);
	}
	
}
