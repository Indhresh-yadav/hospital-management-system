package org.ind.hospitalmanagementsystem.dto;


import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String password;
	private Long mobile;
	private String specialization;
	  @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
	  
	  private List<Patient> patients;
	
}
