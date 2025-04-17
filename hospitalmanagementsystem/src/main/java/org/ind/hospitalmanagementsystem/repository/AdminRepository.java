package org.ind.hospitalmanagementsystem.repository;

import org.ind.hospitalmanagementsystem.dto.Admin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepository  extends JpaRepository<Admin, Integer>{
	
	public Admin findByUsername(String username);

}
