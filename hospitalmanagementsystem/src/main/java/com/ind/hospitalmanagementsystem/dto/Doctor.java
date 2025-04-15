package com.ind.hospitalmanagementsystem.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int did;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String password;
	private String specialization;
	private long mobile;
	 @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL) 
	 // One doctor can have many patients
	 @JsonIgnore
	 private List<Patient> patients;
}
