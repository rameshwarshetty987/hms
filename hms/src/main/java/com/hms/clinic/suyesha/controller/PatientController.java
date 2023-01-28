package com.hms.clinic.suyesha.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.clinic.suyesha.dto.PatientDto;
import com.hms.clinic.suyesha.model.Patient;
import com.hms.clinic.suyesha.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
	
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PatientService service;
	

	public PatientController(PatientService service) {
		super();
		this.service = service;
	}



	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<PatientDto> create(@RequestBody PatientDto patientDto) {
		
		// convert DTO to entity
		Patient patientRequest = modelMapper.map(patientDto, Patient.class);
		Patient patient = service.save(patientRequest);
		
		// convert entity to DTO
		PatientDto patientResponse = modelMapper.map(patient, PatientDto.class);
		return new ResponseEntity<PatientDto>(patientResponse, HttpStatus.CREATED);
	}
}
