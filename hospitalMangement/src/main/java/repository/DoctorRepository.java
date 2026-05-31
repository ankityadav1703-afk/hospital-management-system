package com.Project.hospitalMangement.repository;

import com.Project.hospitalMangement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}