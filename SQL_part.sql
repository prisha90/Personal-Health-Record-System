create database dbs_project;

-- entity tables:
	
CREATE TABLE users
( 	id int NOT NULL auto_increment,
	u_name varchar(25),
	pass varchar(25),
	f_name varchar(15),
    l_name varchar(15),
    weight float,
    height float,
    dob date,
    sex enum('F', 'M', 'Others'),
    
    primary key(id)
);

CREATE TABLE users_ph
(	id int,
	phone_id int NOT NULL,
	phone_no decimal(10,0),
    foreign key(id) REFERENCES users(id)
    ON DELETE CASCADE,
    PRIMARY KEY(id, phone_id)
);
	
CREATE TABLE appointments 
( 	app_no int NOT NULL auto_increment,
	adate date,
    atime time,
    doctor varchar(30),
    diagnosis1 varchar(50),
    diagnosis2 varchar(50),
	diagnosis3 varchar(50),
	primary key(app_no)
);

CREATE TABLE vaccine
(	 v_id int NOT NULL auto_increment,
	 id int,
	 v_name varchar(20),
     due_date date,
     taken enum('Yes', 'No') NOT NULL,
     primary key (v_id),
     foreign key(id) REFERENCES users(id)
     ON DELETE CASCADE 
);

CREATE TABLE medicine
(	med_id int NOT NULL auto_increment,
	id int,
	med_name varchar(20),
    strength decimal(4,2),
    start_date date,
    end_date date,
    mtime time,
    primary key(med_id),
    foreign key(id) REFERENCES users(id)
    ON DELETE CASCADE
);

CREATE TABLE lab_report
(	lr_id int NOT NULL ,
	id int,
	lr_name varchar(25),
    lr_status enum('Treatment over', 'Treatment ongoing'),
    primary key(lr_id),
    foreign key(id) REFERENCES users(id)
    ON DELETE CASCADE
);

CREATE TABLE cycle_reminder
(	c_id int NOT NULL auto_increment,
	id int,
	start_date date,
    cycle_length int,
    cycle_gap int,
    primary key(c_id),
    foreign key(id) REFERENCES users(id)
    ON DELETE CASCADE
);

CREATE TABLE family_history
(	s_no int NOT NULL auto_increment,
	id int,
	disease varchar(25),
    relation varchar(15),
    primary key(s_no),
    foreign key(id) REFERENCES users(id)
    ON DELETE CASCADE
);

CREATE TABLE disease
(	d_id int NOT NULL auto_increment,
	id int,
	d_name varchar(20),
    primary key(d_id),
    foreign key(id) REFERENCES users(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- relationship tables:

CREATE TABLE makes 
(	app_no int,
	id int,
    foreign key(id) REFERENCES users(id)
    ON DELETE CASCADE,
    foreign key(app_no) REFERENCES appointments(app_no)
    ON DELETE CASCADE,
    primary key(app_no)
);



show databases;
use dbs_project;
show tables;
use healthrecord;
desc cycle_reminder;
desc vaccine;
desc disease;
desc family_history;
desc appointments;
select * from appointments;
desc users;

insert into users values(1, 'Vishesh', 'Arora', 20021104, 'M');
insert into appointments values (NULL,20210421, 120000, 'D1', 'Cancer',NULL, NULL);
insert into disease values(NULL, 1, 'asthma');

select * from disease
where id = 1;

select * from users;