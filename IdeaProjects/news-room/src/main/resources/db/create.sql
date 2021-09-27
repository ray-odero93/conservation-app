SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 company VARCHAR,
 division VARCHAR,
 phone VARCHAR,
 website VARCHAR,
 email VARCHAR
);

CREATE TABLE IF NOT EXISTS departmentnews (
 id int PRIMARY KEY auto_increment,
 name VARCHAR
);

CREATE TABLE IF NOT EXISTS newsdetails (
 id int PRIMARY KEY auto_increment,
 writtenby VARCHAR,
 rating VARCHAR,
 content VARCHAR,
 departmentid INTEGER,
 createdat BIGINT
);
CREATE TABLE IF NOT EXISTS department_departmentnews (
 id int PRIMARY KEY auto_increment,
 departmentnewsid INTEGER,
 departmentid INTEGER
);