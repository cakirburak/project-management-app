CREATE SEQUENCE IF NOT EXISTS employee_seq;

CREATE TABLE IF NOT EXISTS employee (
	employee_id BIGINT NOT NULL DEFAULT nextval('employee_seq') PRIMARY KEY,
	email VARCHAR(100) NOT NULL,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS project_seq;

CREATE TABLE IF NOT EXISTS project (
	project_id BIGINT NOT NULL DEFAULT nextval('project_seq') PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	stage VARCHAR(100) NOT NULL,
	description VARCHAR(500) NOT NULL
);


CREATE TABLE IF NOT EXISTS project_employee (
	project_id BIGINT REFERENCES project, 
	employee_id BIGINT REFERENCES employee
);

create table users(
	username varchar_ignorecase(50) not null primary key,
	password varchar_ignorecase(500) not null,
	enabled boolean not null
);

create table authorities (
	username varchar_ignorecase(50) not null,
	authority varchar_ignorecase(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);