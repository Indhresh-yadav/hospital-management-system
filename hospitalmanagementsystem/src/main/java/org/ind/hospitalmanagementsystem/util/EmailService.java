package org.ind.hospitalmanagementsystem.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class EmailService {
	 	@Autowired
	    private JavaMailSender mailSender;

	    public void sendAccountconfirmationMail(String to) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setFrom("gollaindresh201@gmail.com");
	        message.setSubject("conformation Regards to your account");
	        message.setText("account created sucessfully");

	        mailSender.send(message);
	    }
	    
	    public void sendUpdateDetailsMail(String to) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setFrom("gollaindresh201@gmail.com");
	        message.setSubject("update Regards to your account");
	        message.setText("your account details updated sucessfully");

	        mailSender.send(message);
	    }
	    
	    public void sendLoginMail(String to) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setFrom("gollaindresh201@gmail.com");
	        message.setSubject("login Regards to your account");
	        message.setText("your account login sucessfully");

	        mailSender.send(message);
	    }
	    
	    public void sendDeleteMail(String to) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setFrom("gollaindresh201@gmail.com");
	        message.setSubject("Delete Regards to your account");
	        message.setText("your account details deleted sucessfully sucessfully");

	        mailSender.send(message);
	    }



}
