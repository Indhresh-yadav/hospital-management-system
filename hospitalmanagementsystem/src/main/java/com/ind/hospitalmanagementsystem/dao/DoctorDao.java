package com.ind.hospitalmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ind.hospitalmanagementsystem.dto.Admin;
import com.ind.hospitalmanagementsystem.dto.Doctor;
import com.ind.hospitalmanagementsystem.repository.DoctorRepository;

@Repository
public class DoctorDao {
	@Autowired
	private DoctorRepository doctorRepository;
	 
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	public Doctor findById(Integer id) {
		Optional<Doctor> doctordb=doctorRepository.findById(id);
		
		if(doctordb!=null) {
			 return doctordb.get();
		}else {
			return null;
		}
	}
	public void deleteDoctor(Integer id) {
		 doctorRepository.deleteById(id);
		
	}
	
	 public Doctor doctorLogin(String email) {
		 return doctorRepository.findByEmail(email);
	 } public List<Doctor> fetchAll(){
		 return doctorRepository.findAll();
	 }

}
