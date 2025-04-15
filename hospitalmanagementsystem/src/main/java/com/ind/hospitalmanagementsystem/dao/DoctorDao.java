package com.ind.hospitalmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ind.hospitalmanagementsystem.dto.Doctor;
import com.ind.hospitalmanagementsystem.repository.DoctorRepository;

@Repository
public class DoctorDao {
	@Autowired
	private DoctorRepository doctorRepository;
	// to save the doctor details
	public Doctor saveDoctor(Doctor doctor){
		return doctorRepository.save(doctor);
	}
	// to find the doctor details based on id
	public Doctor findById(Integer id) {
		
		Optional<Doctor> doctorId=doctorRepository.findById(id);
		if(doctorId.isPresent()) {
			 return doctorId.get();
		}else {
			return null;
		}
	}
	
	// to fetch all doctor details
	
	public List<Doctor> findAll(){
		return doctorRepository.findAll();
		
	}
	// to delete the doctor details
	
	public void deleteDoctor(Integer id) {
		doctorRepository.deleteById(id);
	}
	
	public Doctor loginEmail(String email) {
		return doctorRepository.findByEmail(email);
	}
}



















