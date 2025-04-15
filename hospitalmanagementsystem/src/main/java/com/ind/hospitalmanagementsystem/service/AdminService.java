package com.ind.hospitalmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ind.hospitalmanagementsystem.dao.AdminDao;
import com.ind.hospitalmanagementsystem.dto.Admin;
import com.ind.hospitalmanagementsystem.util.ResponseStructure;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
	
		public Admin saveAdmin(Admin admin) {
		return 	 adminDao.saveAdmin(admin);
		}
		
		public ResponseEntity<ResponseStructure<Admin>> adminLogin(String username,String password) {
			Admin admindb=adminDao.adminLogin(username);
			if(admindb!=null && admindb.getPassword().equals(password)) {
				responseStructure.setData(admindb);
				responseStructure.setMsg("admin login sucessfully");
				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.ACCEPTED);
			}else {
				return null;
			}
		}
}
