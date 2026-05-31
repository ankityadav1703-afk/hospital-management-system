package com.Project.hospitalMangement.repository;

import com.Project.hospitalMangement.dto.BloodGroupCountResponseEntity;
import com.Project.hospitalMangement.entity.Patient;
import com.Project.hospitalMangement.entity.type.BloodGroupType;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);

    List<Patient> findByNameContaining(String query);

    @Query("SELECT p FROM Patient p WHERE p.bloodGroup = :bloodGroup")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("""
            SELECT new com.Project.hospitalMangement.dto.BloodGroupCountResponseEntity(
            p.bloodGroup,
            COUNT(p))
            FROM Patient p
            GROUP BY p.bloodGroup
            """)
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
    int updateNameWithId(@Param("name") String name,
                         @Param("id") Long id);

    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments")
 //   @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments a LEFT JOIN FETCH a.doctor")
    List<Patient> findAllPatientWithAppointment();
}