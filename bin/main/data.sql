INSERT INTO confidence_level (identifier, name, level) VALUES (1, 'Low', 1);
INSERT INTO confidence_level (identifier, name, level) VALUES (2, 'Below Average', 2);
INSERT INTO confidence_level (identifier, name, level) VALUES (3, 'Average', 3);
INSERT INTO confidence_level (identifier, name, level) VALUES (4, 'Above Average', 4);
INSERT INTO confidence_level (identifier, name, level) VALUES (5, 'High', 5);

INSERT INTO technology (identifier, name) VALUES (1, 'Java');
INSERT INTO technology (identifier, name) VALUES (2, 'Spring');
INSERT INTO technology (identifier, name) VALUES (3, 'SQL');
INSERT INTO technology (identifier, name) VALUES (4, 'HTML/JavaScript/CSS');
INSERT INTO technology (identifier, name) VALUES (5, 'C++');
INSERT INTO technology (identifier, name) VALUES (6, 'C#');
INSERT INTO technology (identifier, name) VALUES (7, 'C');
INSERT INTO technology (identifier, name) VALUES (8, 'PHP');
INSERT INTO technology (identifier, name) VALUES (9, 'System Management');

INSERT INTO applicant (identifier, first_name, last_name, date_of_birth, email_address, phone_number, street_name, house_number, city_name, zip_code) VALUES (1, 'Cyril', 'Halmo', '1986-11-26', 'cyril.halmo@gmx.ch', '078 722 59 41', 'Kirchackerstrasse', 7, 'Riniken', 5223);

INSERT INTO skill (identifier, technology_id, confidence_level_id, applicant_id) VALUES (1, 1, 4, 1);
INSERT INTO skill (identifier, technology_id, confidence_level_id, applicant_id) VALUES (2, 2, 4, 1);
INSERT INTO skill (identifier, technology_id, confidence_level_id, applicant_id) VALUES (3, 3, 3, 1);
INSERT INTO skill (identifier, technology_id, confidence_level_id, applicant_id) VALUES (4, 4, 3, 1);
INSERT INTO skill (identifier, technology_id, confidence_level_id, applicant_id, further_information) VALUES (5, 5, 2, 1, 'Obschon ich im Studium auch in diesem Fach sehr gute Noten schrieb, würde ich mich nicht als erfahren in C++ beszeichnen.');
INSERT INTO skill (identifier, technology_id, confidence_level_id, applicant_id) VALUES (6, 6, 2, 1);