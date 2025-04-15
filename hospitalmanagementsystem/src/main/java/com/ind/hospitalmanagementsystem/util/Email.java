package com.ind.hospitalmanagementsystem.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Email {
	@Autowired
  private JavaMailSender javaMailSender;
	
	public void doctorRegisterMail(String to) {
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setFrom("gollaindhresh@gmail.com");
		mailMessage.setSubject("Regards to health bridge hospital");
		mailMessage.setText("your account registration sucessfully completed ");
		javaMailSender.send(mailMessage);
	}
	public void patientRegisterMail(String to) {
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setFrom("gollaindhresh@gmail.com");
		mailMessage.setSubject("Regards to health bridge hospital");
		mailMessage.setText("your sucessfully registred  health bridge hospital \n \n well come to health bridge hospital");
		javaMailSender.send(mailMessage);
	}
	
	
}
