package com.hms.clinic.suyesha.service;

import java.util.List;

import com.hms.clinic.suyesha.dto.PatientDto;
import com.hms.clinic.suyesha.exception.PatientIDException;
import com.hms.clinic.suyesha.model.Patient;

public interface PatientService {
	
	public Patient save(Patient patient);
	public List<Patient>  findAllPatient();
	public Patient findById(String id) throws PatientIDException ;
	public Patient updatePatient(String id,PatientDto patientRequest) throws PatientIDException;
	public Patient deletePatient(String id) throws PatientIDException;
}
