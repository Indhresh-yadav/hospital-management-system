package com.ind.hospitalmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ind.hospitalmanagementsystem.dto.Admin;

public interface AdminRepository   extends JpaRepository<Admin, Integer> {
	public Admin findByUsername(String username);
}
