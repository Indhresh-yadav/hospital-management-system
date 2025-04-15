package com.ind.hospitalmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ind.hospitalmanagementsystem.dto.Admin;
import com.ind.hospitalmanagementsystem.service.AdminService;
import com.ind.hospitalmanagementsystem.util.ResponseStructure;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/indhreshyadav")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@PostMapping("/saveadmin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin){
		return adminService.saveAdmin(admin);
	}
	@GetMapping("/adminlogin")
	public ResponseEntity<ResponseStructure<Admin>> adminLogin(@RequestParam  String username ,@RequestParam String password){
		return adminService.adminLogin(username, password);
		
	}

}
