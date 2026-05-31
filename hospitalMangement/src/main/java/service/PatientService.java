package com.Project.hospitalMangement.service;

import com.Project.hospitalMangement.repository.PatientRepository;
import com.Project.hospitalMangement.entity.Patient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    @Transactional
    public Patient getPatientById(Long id) {

        Patient p1 = patientRepository.findById(id).orElseThrow();

        Patient p2 =  patientRepository.findById(id).orElseThrow();

        System.out.println(p1==p2);

       // p1.setName("yoyo");

        //patientRepository.save(p1);

        return p1;
    }
}
