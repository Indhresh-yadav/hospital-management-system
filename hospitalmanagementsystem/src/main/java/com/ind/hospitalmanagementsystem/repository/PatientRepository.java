package com.ind.hospitalmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ind.hospitalmanagementsystem.dto.Patient;

public interface PatientRepository  extends JpaRepository<Patient, Integer>{

		Patient findByEmail(String email);
}
