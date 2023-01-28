package com.hms.clinic.suyesha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Patient {

	@Id  
	@GeneratedValue
	private String pid;
	
	private String name;
	
	private String dob;
	
	private String gender;
	
	private String bloodGroup;
	
	private String email;
	
	private String address;
	
	private Integer mobile;
	
	private String cghsPrivate;
}
