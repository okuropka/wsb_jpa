--drop all objects;
insert into address (id, addressLine1, addressLine2, city, postalCode)
values (1, 'xx', 'yy', 'city', '62-030'),
       (2, 'xx2', 'yy2', 'city2', '62-031'),
       (3, 'xx3', 'yy3', 'city2', '62-031');

insert into doctor (id, firstName, lastName, telephoneNumber, email, doctorNumber, specialization, address_id)
values (1, 'imieDoktora', 'nazwiskoDoktora', '666333999', 'doktorDoktor@przychodnia.pl', '444756', 'OCULIST', 2);

insert into patient (id, firstName, lastName, isWoman, dateOfBirth, telephoneNumber, email, patientNumber, address_id)
values (1, 'imiePacjenta', 'nazwiskoPacjenta', 0, '2024-04-05', '333999666', 'inspicjentKowalski@pochtah.pl', '12745', 1),
       (2, 'imiePacjenta2', 'nazwiskoPacjenta2', 1, '1999-04-05', '999333666', 'pacjent2@200ml.pl', '11111', 3);

insert into medicalTreatment (id, treatmentDescription, type)
values (1, 'amputacja rogoowki', 'RTG'),
       (2, 'Podanie syropku na kaszel', 'podanie leku');

insert into visit (id, visitDescription, time, doctor_id, patient_id, medicalTreatment_id)
values (1, 'zabieg', '2024-04-05', 1, 1, 2),
       (2, 'operacja', '2024-04-07', 1, 2, 1),
       (3, 'zabieg', '2022-04-05', 1, 1, 2);