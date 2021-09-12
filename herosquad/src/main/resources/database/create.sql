CREATE DATABASE herosquad;

\c herosquad;

CREATE TABLE heroes
 (id SERIAL PRIMARY KEY,
 description VARCHAR,
 completed BOOLEAN,
 categoryid INTEGER);

CREATE TABLE squads
(id SERIAL PRIMARY KEY,
 name VARCHAR);


CREATE DATABASE herosquad_test WITH TEMPLATE herosquad;

CREATE TABLE DB_Errors
         (ErrorID        INT IDENTITY(1, 1),
          UserName       VARCHAR(100),
          ErrorNumber    INT,
          ErrorState     INT,
          ErrorSeverity  INT,
          ErrorLine      INT,
          ErrorProcedure VARCHAR(MAX),
          ErrorMessage   VARCHAR(MAX),
          ErrorDateTime  DATETIME)
GO