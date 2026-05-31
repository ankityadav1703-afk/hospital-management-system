package com.Project.hospitalMangement;

import com.Project.hospitalMangement.service.InsuranceService;
import com.Project.hospitalMangement.service.AppointmentService;
import com.Project.hospitalMangement.entity.Insurance;
import com.Project.hospitalMangement.entity.Patient;
import com.Project.hospitalMangement.entity.Appointment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance() {

        Insurance insurance = Insurance.builder()
                .policynumber(123456L)
                .provider("HDFC")
                .validUntil(LocalDateTime.of(2030, 12, 12, 0, 0))
                .build();

        Patient patient =
                insuranceService.assignInsuranceToPatient(insurance, 1L);

        System.out.println(patient);

        var newpatient =  insuranceService.disaccociateInsuranceFromPatient(patient.getId());

        System.out.println(newpatient);
    }

    @Test
    public void testCreateAppointment() {

        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026, 12, 20, 10, 30))
                .reason("Cancer")
                .build();

        var newAppointment = appointmentService.createNewAppointment(appointment, 1L, 2L);

        System.out.println(newAppointment);

        var updateedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(),3l);

        System.out.println(updateedAppointment);
    }
}