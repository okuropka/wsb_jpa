insert into address (id, address_line1, address_line2, city, postal_code)
values (1, 'xx', 'yy', 'city', '62-030'),
       (2, 'xx2', 'yy2', 'city2', '62-031'),
       (3, 'xx3', 'yy3', 'city2', '62-031');

insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_entity_id)
values (1, 'imieDoktora', 'nazwiskoDoktora', '666333999', 'doktorDoktor@przychodnia.pl', '444756', 'OCULIST', 2);

insert into patient (id, first_name, last_name, is_woman, height_cm, date_of_birth, telephone_number, email, patient_number, address_entity_id)
values (1, 'imiePacjenta', 'nazwiskoPacjenta', 0, 185, '2024-04-05', '333999666', 'inspicjentKowalski@pochtah.pl', '12745', 1),
       (2, 'imiePacjentki', 'nazwiskoPacjenta2', 1, 160, '1999-04-05', '999333666', 'pacjent2@200ml.pl', '11111', 3),
       (3, 'imiePacjentki2', 'nazwiskoPacjenta', 1, 170, '2024-04-05', '333999666', 'halinaMalina@pi.com', '88888', 1);

insert into medicalTreatment (id, description, treatment_type)
values (1, 'amputacja rogoowki', 'RTG'),
       (2, 'Podanie syropku na kaszel', 'USG');

insert into visit (id, description, time, doctor_id, patient_id, medical_treatment_entity_id)
values (1, 'zabieg', '2024-04-05', 1, 1, 2),
       (2, 'operacja', '2022-04-06', 1, 1, 1),
       (3, 'zabieg', '2024-04-07', 1, 2, 2);