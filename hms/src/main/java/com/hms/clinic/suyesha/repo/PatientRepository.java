package com.hms.clinic.suyesha.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.clinic.suyesha.model.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

}
