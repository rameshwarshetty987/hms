package com.hms.clinic.suyesha.controller;

import java.util.List;

import javax.management.BadStringOperationException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hms.clinic.suyesha.dto.PatientDto;
import com.hms.clinic.suyesha.exception.PatientIDException;
import com.hms.clinic.suyesha.model.Patient;
import com.hms.clinic.suyesha.service.PatientService;

@CrossOrigin(origins = "*")
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

	//save 
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<PatientDto> create(@RequestBody PatientDto patientDto) {
		
		// convert DTO to entity
		Patient patientRequest = modelMapper.map(patientDto, Patient.class);
		Patient patient = service.save(patientRequest);
		
		// convert entity to DTO
		PatientDto patientResponse = modelMapper.map(patient, PatientDto.class);
		return new ResponseEntity<PatientDto>(patientResponse, HttpStatus.CREATED);
	}
	
	//find all 
	@RequestMapping(path = "/all",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Patient>>  findAllPatient() {
		 List<Patient> allPatient = service.findAllPatient();
		return new ResponseEntity<>(allPatient, HttpStatus.OK);
		
	}
	//find by id
	@RequestMapping(path="/patientId/{id}",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<PatientDto> findByPatientId(@PathVariable String id) throws PatientIDException {
		Patient findById = service.findById(id);
		PatientDto patientResponse = modelMapper.map(findById, PatientDto.class);
		return new ResponseEntity<PatientDto>(patientResponse,HttpStatus.OK);
	}
	//update PatientRecord using Id
	@RequestMapping(path = "/updatePatient/{id}", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<PatientDto> updatePatient(@PathVariable String id,@RequestBody PatientDto patientDto) throws PatientIDException {
		Patient updatePatient = service.updatePatient(id, patientDto);
		PatientDto patientResponse = modelMapper.map(updatePatient, PatientDto.class);
		return new ResponseEntity<PatientDto>(patientResponse,HttpStatus.OK);
	}
	//delete by Id
	
	@RequestMapping(path = "/mod/{id}",method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity deletePatient(@PathVariable String id) throws  PatientIDException{
		Patient deletePatient = service.deletePatient(id);
		return new ResponseEntity (deletePatient,HttpStatus.OK);
	}
	
}
