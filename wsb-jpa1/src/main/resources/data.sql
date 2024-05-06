drop all objects;

CREATE TABLE Address (
                         id INT PRIMARY KEY,
                         addressLine1 VARCHAR(255),
                         addressLine2 VARCHAR(255),
                         city VARCHAR(255),
                         postalCode VARCHAR(10)
);

CREATE TABLE Doctor (
                        id INT PRIMARY KEY,
                        firstName VARCHAR(255),
                        lastName VARCHAR(255),
                        telephoneNumber VARCHAR(20),
                        email VARCHAR(255),
                        doctorNumber VARCHAR(20),
                        specialization VARCHAR(255),
                        address_id INT UNIQUE,
                        FOREIGN KEY (address_id) REFERENCES Address(id)
);

CREATE TABLE Patient (
                         id INT PRIMARY KEY,
                         firstName VARCHAR(255),
                         lastName VARCHAR(255),
                         isWoman bit,
                         telephoneNumber VARCHAR(20),
                         email VARCHAR(255),
                         patientNumber VARCHAR(20),
                         dateOfBirth DATE,
                         address_id INT UNIQUE,
                         FOREIGN KEY (address_id) REFERENCES Address(id)
);

CREATE TABLE MedicalTreatment (
                                  id INT PRIMARY KEY,
                                  treatment_description VARCHAR(255),
                                  type VARCHAR(100)
);

CREATE TABLE Visit (
                       id INT PRIMARY KEY,
                       visit_description VARCHAR(255),
                       time TIMESTAMP,
                       doctor_id INT,
                       patient_id INT,
                       medical_treatment_id int,
                       FOREIGN KEY (doctor_id) REFERENCES Doctor(id),
                       FOREIGN KEY (patient_id) REFERENCES Patient(id),
                       FOREIGN KEY (medical_treatment_id) REFERENCES MedicalTreatment(id)
);

insert into address (id, addressLine1, addressLine2, city, postalCode)
            values (1, 'xx', 'yy', 'city', '62-030'),
                   (2, 'xx2', 'yy2', 'city2', '62-031'),
                   (3, 'xx3', 'yy3', 'city2', '62-031');
insert into doctor (id, firstName, lastName, telephoneNumber, email, doctorNumber, specialization, address_id)
            values (1, 'imieDoktora', 'nazwiskoDoktora', '666333999', 'doktorDoktor@przychodnia.pl', '444756', 'OCULIST', 2);
insert into patient (id, firstName, lastName, isWoman, dateOfBirth, telephoneNumber, email, patientNumber, address_id)
            values (1, 'imiePacjenta', 'nazwiskoPacjenta', 0, '2024-04-05', '333999666', 'inspicjentKowalski@pochtah.pl', '12745', 1),
                   (2, 'imiePacjenta2', 'nazwiskoPacjenta2', 1, '1999-04-05', '999333666', 'pacjent2@200ml.pl', '11111', 3);
insert into medicalTreatment (id, treatment_description, type)
            values (1, 'amputacja rogoowki', 'RTG'),
                   (2, 'Podanie syropku na kaszel', 'podanie leku');
insert into visit (id, visit_description, time, doctor_id, patient_id, medical_treatment_id)
            values (1, 'zabieg', '2024-04-05', 1, 1, 2),
                   (2, 'operacja', '2024-04-07', 1, 2, 1),
                   (3, 'zabieg', '2022-04-05', 1, 1, 2);