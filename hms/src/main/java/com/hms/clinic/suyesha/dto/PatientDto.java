package com.hms.clinic.suyesha.dto;

import lombok.Data;

@Data
public class PatientDto{
	
	/**
	 * @author raku
	 */

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
