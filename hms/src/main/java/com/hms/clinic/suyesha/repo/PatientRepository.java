package com.hms.clinic.suyesha.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.clinic.suyesha.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, String> {

}
