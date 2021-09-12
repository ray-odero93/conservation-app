CREATE DATABASE herosquad;

\c herosquad;

CREATE TABLE heroes
 (id SERIAL PRIMARY KEY,
 description VARCHAR,
 completed BOOLEAN,
 squadid INTEGER);

CREATE TABLE squads
(id SERIAL PRIMARY KEY,
 name VARCHAR);


CREATE DATABASE herosquad_test WITH TEMPLATE herosquad;

