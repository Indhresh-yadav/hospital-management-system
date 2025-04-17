package org.ind.hospitalmanagementsystem.repository;

import org.ind.hospitalmanagementsystem.dto.Patient;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PatientRepository  extends JpaRepository<Patient, Integer>{

	public Patient findByEmail(String email);
}
