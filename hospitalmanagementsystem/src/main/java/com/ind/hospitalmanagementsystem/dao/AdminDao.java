package com.ind.hospitalmanagementsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ind.hospitalmanagementsystem.dto.Admin;
import com.ind.hospitalmanagementsystem.repository.AdminRepository;

@Repository
public class AdminDao {
	@Autowired
	private AdminRepository adminRepository;
	
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	 public Admin adminLogin(String username) {
		 return adminRepository.findByUsername(username);
	 }

}
