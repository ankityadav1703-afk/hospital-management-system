package com.Project.hospitalMangement.entity;
import com.Project.hospitalMangement.entity.Patient;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(onlyExplicitlyIncluded = true)

public class  Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)  // patient is required and not nullable
    private Patient patient;

  //  @ManyToOne
    //@JoinColumn(name = "patient_id",nullable = false)
    //private Patient patient;

    @ManyToOne
    @JoinColumn(nullable = false)
    private  Doctor doctor;
}
