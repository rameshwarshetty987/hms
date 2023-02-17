package com.hms.clinic.suyesha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="Patient")
public class Patient {

	@Id  
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String pid;
	
	private String name;
	
	private String dob;
	
	private String gender;
	
	private String bloodGroup;
	
	private String email;
	
	private String address;
	
	private Long mobile;
	
	private String cghsPrivate;
}
