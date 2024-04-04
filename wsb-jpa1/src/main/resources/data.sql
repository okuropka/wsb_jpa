insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'xx', 'yy', 'city', '62-030');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (2, 'xx2', 'yy2', 'city2', '62-031');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (3, 'xx3', 'yy3', 'city2', '62-031');
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_entity_id)
            values (1, 'imieDoktora', 'nazwiskoDoktora', '666333999', 'doktorDoktor@przychodnia.pl', '444756', 'OCULIST', 2);
insert into patient (id, first_name, last_name, date_of_birth, telephone_number, email, patient_number, address_entity_id)
            values (1, 'imiePacjenta', 'nazwiskoPacjenta', '2024-04-05', '333999666', 'inspicjentKowalski@pochtah.pl', '12745', 1);
insert into patient (id, first_name, last_name, date_of_birth, telephone_number, email, patient_number, address_entity_id)
            values (2, 'imiePacjenta2', 'nazwiskoPacjenta2', '1999-04-05', '999333666', 'pacjent2@200ml.pl', '11111', 3);
insert into visit (id, description, time, doctor_entity_id, patient_entity_id)
            values (1, 'zabieg', '2024-04-05', 1, 1);
insert into visit (id, description, time, doctor_entity_id, patient_entity_id)
            values (2, 'recepta', '2024-04-05', 1, 2);
insert into medical_treatment (id, description, type, visit_id)
            values (1, 'amputacja rogoowki', 'RTG', 1);