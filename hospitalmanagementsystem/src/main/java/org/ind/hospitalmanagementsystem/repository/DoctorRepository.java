package org.ind.hospitalmanagementsystem.repository;


import org.ind.hospitalmanagementsystem.dto.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DoctorRepository  extends JpaRepository<Doctor, Integer>{
	
	public Doctor findByEmail(String email);

}
