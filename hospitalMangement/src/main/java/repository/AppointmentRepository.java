package com.Project.hospitalMangement.repository;

import com.Project.hospitalMangement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}