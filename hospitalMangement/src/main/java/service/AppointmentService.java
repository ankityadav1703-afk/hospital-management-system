package com.Project.hospitalMangement.service;

import com.Project.hospitalMangement.entity.Appointment;
import com.Project.hospitalMangement.entity.Doctor;
import com.Project.hospitalMangement.entity.Patient;

import com.Project.hospitalMangement.repository.AppointmentRepository;
import com.Project.hospitalMangement.repository.DoctorRepository;
import com.Project.hospitalMangement.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment,
                                            Long doctorId,
                                            Long patientId) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        if (appointment.getId()!= null) {
            throw new IllegalArgumentException("Appointment should not already have ID");
        }

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        patient.getAppointments().add(appointment);

        return appointmentRepository.save(appointment);
    }
    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId,Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);
        doctor.getAppointments().add(appointment);
        return appointment;
    }
}