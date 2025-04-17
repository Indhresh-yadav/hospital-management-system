package org.ind.hospitalmanagementsystem.dao;


import org.ind.hospitalmanagementsystem.dto.Admin;
import org.ind.hospitalmanagementsystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



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
