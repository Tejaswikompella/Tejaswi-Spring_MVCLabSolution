create schema studentrecord_database;

CREATE TABLE IF NOT EXISTS studentrecord_database.student(
id INT NOT NULL auto_increment,
firstname VARCHAR(10) NOT NULL,
lastname VARCHAR(10) NOT NULL,
country VARCHAR(15) NOT NULL,
PRIMARY KEY (id));

insert into studentrecord_database.student
(firstname,lastname,country)
values
('vamsi','krishna','india');

insert into studentrecord_database.student
(firstname,lastname,country)
values
('harshit','goud','canada');

insert into studentrecord_database.student
(firstname,lastname,country)
values
('tanya','sharma','india');

insert into studentrecord_database.student
(firstname,lastname,country)
values
('robin','sharma','new zealand');

insert into studentrecord_database.student
(firstname,lastname,country)
values
('mounica','v','usa');

select * from studentrecord_database.student;