package org.ind.hospitalmanagementsystem.service;
import org.ind.hospitalmanagementsystem.dao.AdminDao;
import org.ind.hospitalmanagementsystem.dto.Admin;
import org.ind.hospitalmanagementsystem.exception.EmailNotFound;
import org.ind.hospitalmanagementsystem.util.EmailService;
import org.ind.hospitalmanagementsystem.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	
	
	ResponseStructure<Admin> structure=new ResponseStructure<Admin>();
	
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin){
		structure.setData(adminDao.saveAdmin(admin));
		structure.setMsg("admin data insereted sucessfully");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
	
		return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.ACCEPTED);
	
	}
	public ResponseEntity<ResponseStructure<Admin>> adminLogin(String username, String password){
		Admin adminDatabase=adminDao.adminLogin(username);
		if(adminDatabase!=null && adminDatabase.getPassword().equals(password)) {
			structure.setData(adminDatabase);
			structure.setMsg("admin login sucess fully");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.ACCEPTED);
		}else {
			throw new EmailNotFound("email are password incoorect");
		}
	}
	
}