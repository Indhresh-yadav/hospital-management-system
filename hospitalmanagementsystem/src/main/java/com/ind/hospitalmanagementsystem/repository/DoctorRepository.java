package com.ind.hospitalmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ind.hospitalmanagementsystem.dto.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	 Doctor findByEmail(String email);
}
