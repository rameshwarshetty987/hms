package com.hms.clinic.suyesha.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.management.BadStringOperationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.clinic.suyesha.dto.PatientDto;
import com.hms.clinic.suyesha.exception.PatientIDException;
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
	@Override
	public List<Patient> findAllPatient() {
		return repository.findAll();
	}
	@Override
	public Patient findById(String id) throws PatientIDException {
		Optional<Patient> findById = repository.findById(id);
		if(findById.isEmpty()) {
			throw new PatientIDException("Patient is not present");
		}else {
			return findById.get();
		}
	}
	@Override
	public Patient updatePatient(String id, PatientDto patientDto) throws PatientIDException {
		    Patient DBPatient = repository.findById(id).get();
		 if(repository.findById(id).isEmpty()) {
			 throw new PatientIDException("Patient id is not present");
		 } else {
			 if(Objects.nonNull(patientDto.getAddress()) && !"".contentEquals(patientDto.getAddress())) {
				 DBPatient.setAddress(patientDto.getAddress());
			 }
			 if(Objects.nonNull(patientDto.getBloodGroup()) && !"".equalsIgnoreCase(patientDto.getBloodGroup())) {
				 DBPatient.setBloodGroup(patientDto.getBloodGroup());
			 }
			 if(Objects.nonNull(patientDto.getCghsPrivate()) && !"".equalsIgnoreCase(patientDto.getCghsPrivate())) {
				 DBPatient.setCghsPrivate(patientDto.getCghsPrivate());
			 }
			 if(Objects.nonNull(patientDto.getDob()) && !"".equalsIgnoreCase(patientDto.getDob())) {
				 DBPatient.setDob(patientDto.getDob());
			 }
			 if(Objects.nonNull(patientDto.getEmail()) && !"".equalsIgnoreCase(patientDto.getEmail())) {
				 DBPatient.setEmail(patientDto.getEmail());
			 }
			 if(Objects.nonNull(patientDto.getGender()) && !"".equalsIgnoreCase(patientDto.getGender())) {
				 DBPatient.setGender(patientDto.getGender());
			 }
			 if(Objects.nonNull(patientDto.getMobile())) {
				 DBPatient.setMobile(patientDto.getMobile());
			 }
			 if(Objects.nonNull(patientDto.getName()) && !"".equalsIgnoreCase(patientDto.getName())) {
				 DBPatient.setName(patientDto.getName());
			 } 
		} 
		return repository.save(DBPatient);
	}
	@Override
	public Patient deletePatient(String id) throws PatientIDException {
		if(repository.findById(id).isEmpty()) {
			throw new PatientIDException("Id is not present");
		}else {
		return	repository.findById(id).get();
		}
	}
	

}
