INSERT INTO patient(name, gender, birth_date, email, blood_group)
VALUES
('Rahul Sharma', 'Male', '2001-05-14', 'rah1@gmail.com', 'A_POSITIVE'),
('Priya Verma', 'Female', '1999-08-21', 'priya1@gmail.com', 'O_POSITIVE'),
('Aman Gupta', 'Male', '2003-01-10', 'aman1@gmail.com', 'O_POSITIVE'),
('Sneha Singh', 'Female', '2000-11-30', 'sneha1@gmail.com', 'O_POSITIVE'),
('Rohit Kumar', 'Male', '1998-07-18', 'rohit1@gmail.com', 'O_POSITIVE'),
('Anjali Mehta', 'Female', '2002-03-25', 'anjali1@gmail.com', 'O_POSITIVE');

INSERT INTO doctor (name, specialization, email)
 VALUES ('Amit Sharma', 'Cardiologist', 'amit.sharma@gmail.com');

 INSERT INTO doctor (name, specialization, email)
 VALUES ('Neha Verma', 'Dermatologist', 'neha.verma@gmail.com');

 INSERT INTO doctor (name, specialization, email)
 VALUES ('Rohit Singh', 'Neurologist', 'rohit.singh@gmail.com');

 INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id)
 VALUES
 ('2026-06-01 10:00:00', 'Regular Checkup', 1, 1),

 ('2026-06-01 11:30:00', 'Heart Consultation', 1, 2),

 ('2026-06-02 09:00:00', 'Skin Allergy Treatment', 2, 1),

 ('2026-06-02 14:00:00', 'Neurology Follow-up', 3, 3),

 ('2026-06-03 16:30:00', 'Blood Pressure Check', 1, 4),

 ('2026-06-04 12:00:00', 'Migraine Consultation', 3, 2);