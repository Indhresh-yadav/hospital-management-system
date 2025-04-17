package org.ind.hospitalmanagementsystem.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String password;
	private Long mobile;
	private int age;
	private String gender;
    @ManyToOne
    @JsonIgnore
	private Doctor doctor;
	
	

}