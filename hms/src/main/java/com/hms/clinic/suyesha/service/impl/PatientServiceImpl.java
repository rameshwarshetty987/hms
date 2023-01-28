package com.hms.clinic.suyesha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.clinic.suyesha.dto.PatientDto;
import com.hms.clinic.suyesha.model.Patient;
import com.hms.clinic.suyesha.repo.PatientRepository;
import com.hms.clinic.suyesha.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientRepository repository;
	@Override
	public Patient save(Patient patient) {
		return repository.save(patient);
	}

}
