

DROP TABLE IF EXISTS PRACTICAS;
DROP TABLE IF EXISTS PROG_FORMATIVOS;
DROP TABLE IF EXISTS TUTORES;
DROP TABLE IF EXISTS ALUMNOS;
DROP TABLE IF EXISTS CONVENIOS;

CREATE TABLE ALUMNOS(
  DNI INT(9) PRIMARY KEY,
  NMATRICULA INT(5) UNIQUE, 
  APE1 VARCHAR(25) NOT NULL, 
  APE2 VARCHAR(25) NOT NULL,
  NOMBRE VARCHAR(25) NOT NULL, 
  FECNA DATE, 
  DIRECCION VARCHAR(50),
  POBLA VARCHAR(25),
  PROVINCIA VARCHAR(20), 
  CP INT(5), 
  TEL INT(9),
  TMOVIL INT(5), 
  EMAIL VARCHAR(20),
  AFCT VARCHAR(10)
);

CREATE TABLE CONVENIOS(
  NCONVENIO INT(3) PRIMARY KEY, 
  EMPRESA VARCHAR(50) UNIQUE,
  CIF VARCHAR(10) UNIQUE,
  REPRESENTANTE VARCHAR(50) NOT NULL,
  NIF VARCHAR(10) NOT NULL,
  DIRECCION VARCHAR(50) NOT NULL,
  POBLACION VARCHAR(25) NOT NULL,
  PROVINCIA VARCHAR(20) NOT NULL,
  CP INT(5) NOT NULL,
  TELEMP INT(9),
  CONTACTO VARCHAR(50),
  TELCON INT(9),
  TMOVIL INT(9),
  EMAIL VARCHAR(20),
  DISTANCIA INT(2)
);

CREATE TABLE  PROG_FORMATIVOS (
  NCONVENIO INT(3),
  NPROGRAMA INT(2),
  APRODUCTIVA VARCHAR(1000),
  AEVALUACION VARCHAR(1000),
  CTERMINAL VARCHAR(1000),
  PRIMARY KEY (NCONVENIO, NPROGRAMA),
  FOREIGN KEY (NCONVENIO) REFERENCES CONVENIOS(NCONVENIO)
);

CREATE TABLE  TUTORES( 
  NOMBTUTOR VARCHAR(50),
  NCONVENIO INT(3),
  TEL INT(9),
  TMOVIL INT(9),
  FOREIGN KEY (NCONVENIO) REFERENCES CONVENIOS(NCONVENIO),
  PRIMARY KEY (NOMBTUTOR, NCONVENIO)
);

CREATE TABLE PRACTICAS(
  NCONVENIO INT(3),
  NPROGRAMA INT(2),
  DNI INT(9),
  FECINI DATE,
  FECFIN DATE,
  CENTRO_TRABAJO VARCHAR(50),
  HORARIO VARCHAR(40),
  CURSO VARCHAR(10),
  NTUTOR VARCHAR(50),
  VALORACION VARCHAR(10),
  PRIMARY KEY (DNI, CURSO),
  FOREIGN KEY (DNI)  REFERENCES ALUMNOS(DNI),
  FOREIGN KEY (NTUTOR, NCONVENIO) REFERENCES TUTORES(NOMBTUTOR, NCONVENIO),
  FOREIGN KEY (NCONVENIO, NPROGRAMA) REFERENCES PROG_FORMATIVOS(NCONVENIO, NPROGRAMA)
);



INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(243456789, 12345, 'CASO', 'DE LOPEZ', 'SUSANA', 'RÍO TAJUÑA', 'ALCALA DE HENARES', 'MADRID', 28803, 918876543);

INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(237898757, 12346, 'FERNANDEZ', 'ABRIL', 'MANUEL', 'PL. JAZMÍN 6', 'ALCALA DE HENARES', 'MADRID', 28803, 918886543);

INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(243458740, 12347, 'ABAD', 'GOMEZ', 'ISABEL', 'NÚÑEZ DE GUZMÁN 38', 'ALCALA DE HENARES', 'MADRID', 28802, 918844543);

INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(243556789, 12350, 'CASO', 'DE LOPEZ', 'MANUEL', 'VAL 63', 'LOS SANTOS DE LA HUMOSA', 'MADRID', 28817, 918127654);

INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(982243456, 12300, 'CONDE', 'LOPEZ', 'ARCADIO', 'NARDO 6', 'ALCALA DE HENARES', 'MADRID', 28803, 918876543);

INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(243003456, 12301, 'HERNANDO', 'AGUIRRE', 'LUCIA', 'BUENDÍA 8', 'ALCALA DE HENARES', 'MADRID', 28803, 918571543);

INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(243456500, 12302, 'LOPEZ SERRANO', 'CARRERO', 'LOURDES', 'CÓNDOR 28', 'ARGANDA DEL REY', 'MADRID', 28500, 918704654);

INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(243381156, 12303, 'CASERO', 'PEREZ', 'JERONIMO', 'MÁRTIRES DE CAMARMA 13', 'CAMARMA DE ESTERUELAS', 'MADRID', 28816, 918857543);

INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(202369841, 12423, 'ALOSETE', 'PEREZ', 'MIGUEL ANGEL', 'PRADO DE SANTO DOMINGO 1', 'TORREJON', 'MADRID', 28850, 916757543);

INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(524517890, 12424, 'ALVAREZ', 'LOPEZ', 'RAMON', 'EMBAJADORES 7', 'CAMARMA DE ESTERUELAS', 'MADRID', 28816, 918307549);

INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(125695123, 12425, 'CANEDO', 'ROZAS', 'PEDRO', 'SENDERILLO 2', 'AJALVIR', 'MADRID', 28835, 914208543);

INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(258185239, 12426, 'CARBONELL', 'FRADE', 'MIGUEL', 'FLORES 4', 'ALCALA DE HENARES', 'MADRID', 28806, 918801543);

INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(22028115, 12427, 'ZAMBRANO', 'GARCIA', 'IVAN', 'TOLEDO 7', 'ALCALA DE HENARES', 'MADRID', 28807, 918585543);





INSERT INTO CONVENIOS (NCONVENIO, EMPRESA, CIF, REPRESENTANTE, NIF, DIRECCION, POBLACION, PROVINCIA, CP, TELEMP, CONTACTO, TELCON, DISTANCIA) 
VALUES (1, 'INSTITUTO TECNICO DE MATERIALES Y CONSTRUCCION', '12345678', 'MARTIN LOPEZ AGUDO', '102569842', 'PG IND LAS MONJAS', 'TORREJON DE ARDOZ', 'MADRID', 28850, '916568866', 'RAUL ALCAÍZ MARTIN', '916568866', 7);

INSERT INTO CONVENIOS (NCONVENIO, EMPRESA, CIF, REPRESENTANTE, NIF, DIRECCION, POBLACION, PROVINCIA, CP, TELEMP, CONTACTO, TELCON, DISTANCIA) 
VALUES (2, 'POLISEDA SL', '896521471', 'BLANCA ALVAREZ MADRID', '5252565856', 'CTRA CAMARMA 2,80', 'ALCALA DE HENARES', 'MADRID', 28806, '918885589', 'AMPARO ORTEGA ORTIZ', '918885589', 3);

INSERT INTO CONVENIOS (NCONVENIO, EMPRESA, CIF, REPRESENTANTE, NIF, DIRECCION, POBLACION, PROVINCIA, CP, TELEMP, CONTACTO, TELCON, DISTANCIA) 
VALUES (3, 'ROBERT BOSCH ESPAÑA FABRICA DE ALA DE HENARES', '561258745', 'CARMEN PEÑASCO RAMOS', '5451215470', 'AVDA MADRID 0042', 'ALCALA DE HENARES', 'MADRID', 28802, '918523002', 'EUGENIO SÁNCHEZ GUIJARRO', '918878411', 7);

INSERT INTO CONVENIOS (NCONVENIO, EMPRESA, CIF, REPRESENTANTE, NIF, DIRECCION, POBLACION, PROVINCIA, CP, TELEMP, CONTACTO, TELCON, DISTANCIA) 
VALUES (4, 'ALCALA INDUSTRIAL SA', '552121003', 'CARLOS NOGUEIRA CAMPOS', '023652087', 'CTRA ANTIGUA DEL AEROPUERTO DE TORREJON 1600', 'ALCALA DE HENARES', 'MADRID', 28806, '914782000', 'JUAN PEDRO MONTES TOLÓN', '914782021', 12);

INSERT INTO CONVENIOS (NCONVENIO, EMPRESA, CIF, REPRESENTANTE, NIF, DIRECCION, POBLACION, PROVINCIA, CP, TELEMP, CONTACTO, TELCON, DISTANCIA) 
VALUES (5, 'LABORATORIOS MEDICAMENTOS INTERNACIONALES SA', '032896325', 'DANIEL RAMIREZ NAVALES', '022563287', 'CL SOLANA 0026 PG IND NUMERO 1', 'TORREJON DE ARDOZ', 'MADRID', 28850, '916785000', 'PILAR GONZÁLEZ COLLADO', '916785056', 12);

INSERT INTO CONVENIOS (NCONVENIO, EMPRESA, CIF, REPRESENTANTE, NIF, DIRECCION, POBLACION, PROVINCIA, CP, TELEMP, CONTACTO, TELCON, DISTANCIA) 
VALUES (6, 'GESTORES DE CONTENIDOS EN INTERNET', '032512417', 'FERNANDO RÁBAGO BENITEZ', '923112907', 'CTRA M-300 (DE N-III A ALCALA DE HENARES) 29,9', 'ALCALA DE HENARES', 'MADRID', 28802, '918826503', 'MANUEL IGLESIAS GALLEGO', '918826503', 7);


INSERT INTO PROG_FORMATIVOS(NCONVENIO,NPROGRAMA)
VALUES (1,1);
INSERT INTO PROG_FORMATIVOS(NCONVENIO,NPROGRAMA)
VALUES (2,1);
INSERT INTO PROG_FORMATIVOS(NCONVENIO,NPROGRAMA)
VALUES (3,1);
INSERT INTO PROG_FORMATIVOS(NCONVENIO,NPROGRAMA)
VALUES (4,1);
INSERT INTO PROG_FORMATIVOS(NCONVENIO,NPROGRAMA)
VALUES (5,1);
INSERT INTO PROG_FORMATIVOS(NCONVENIO,NPROGRAMA)
VALUES (1,2);
INSERT INTO PROG_FORMATIVOS(NCONVENIO,NPROGRAMA)
VALUES (1,3);
INSERT INTO PROG_FORMATIVOS(NCONVENIO,NPROGRAMA)
VALUES (2,2);
INSERT INTO PROG_FORMATIVOS(NCONVENIO,NPROGRAMA)
VALUES (5,2);


INSERT INTO TUTORES (NOMBTUTOR, NCONVENIO, TEL)
VALUES ('RAUL ALCAÍZ MARTIN', 1, 916568866);

INSERT INTO TUTORES (NOMBTUTOR, NCONVENIO, TEL)
VALUES ('AMPARO ORTEGA ORTIZ', 2, 918885589);

INSERT INTO TUTORES (NOMBTUTOR, NCONVENIO, TEL)
VALUES ('JUAN PEDRO MONTES TOLÓN', 3, 914782021);

INSERT INTO TUTORES (NOMBTUTOR, NCONVENIO, TEL)
VALUES ('PILAR GONZÁLEZ COLLADO', 4, 916785056);

INSERT INTO TUTORES (NOMBTUTOR, NCONVENIO, TEL)
VALUES ('MANUEL IGLESIAS GALLEGO', 5, 918826503);

INSERT INTO TUTORES (NOMBTUTOR, NCONVENIO, TEL)
VALUES ('PILAR MANJAVACAS APARICIO', 1, 916568867);

INSERT INTO TUTORES (NOMBTUTOR, NCONVENIO, TEL)
VALUES ('TOMAS GALLEGO ANDUJAR', 1, 916568868);


INSERT INTO PRACTICAS(NCONVENIO, NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (1, 1, 982243456, '2002-04-01', '2002-06-15', '9:00 - 14:00 y 17:00 - 19:00', '2001-2002', 'RAUL ALCAÍZ MARTIN', 'APTO');

INSERT INTO PRACTICAS(NCONVENIO, NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (1, 1, 243003456, '2002-04-01', '2002-06-15', '8:00 - 15:45', '2001-2002', 'RAUL ALCAÍZ MARTIN', 'APTO');

INSERT INTO PRACTICAS(NCONVENIO, NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (2, 1, 243456500, '2002-04-01', '2002-06-15', '9:00 - 14:00 y 17:00 - 19:00', '2001-2002', 'AMPARO ORTEGA ORTIZ', 'APTO');

INSERT INTO PRACTICAS(NCONVENIO, NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (3, 1, 243381156, '2002-04-01', '2002-06-15', '9:00 - 14:00 y 17:00 - 19:00', '2001-2002', 'JUAN PEDRO MONTES TOLÓN', 'NO APTO');



INSERT INTO PRACTICAS(NCONVENIO, NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (1, 1, 243381156, '2002-04-01', '2002-06-15', '9:00 - 14:00 y 17:00 - 19:00', '2002-2003', 'RAUL ALCAÍZ MARTIN', 'APTO');

INSERT INTO PRACTICAS(NCONVENIO, NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (1, 2, 202369841, '2002-04-01', '2002-06-15', '9:00 - 14:00 y 17:00 - 19:00', '2002-2003', 'PILAR MANJAVACAS APARICIO', 'APTO');

INSERT INTO PRACTICAS(NCONVENIO, NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (1, 2, 524517890, '2002-04-01', '2002-06-15', '9:00 - 14:00 y 17:00 - 19:00', '2002-2003', 'TOMAS GALLEGO ANDUJAR', 'APTO');

INSERT INTO PRACTICAS(NCONVENIO, NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (2, 1, 125695123, '2002-04-01', '2002-06-15', '9:00 - 14:00 y 17:00 - 19:00', '2002-2003', 'AMPARO ORTEGA ORTIZ', 'APTO');

INSERT INTO PRACTICAS(NCONVENIO, NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (2, 1, 258185239, '2002-04-01', '2002-06-15', '9:00 - 14:00 y 17:00 - 19:00', '2002-2003', 'AMPARO ORTEGA ORTIZ', 'APTO');

INSERT INTO PRACTICAS(NCONVENIO, NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (3, 1, 22028115, '2002-04-01', '2002-06-15', '8:00 - 15:45', '2002-2003', 'JUAN PEDRO MONTES TOLÓN', 'APTO');
////////////////////////////////////////////////////////////
DROP TABLE IF EXISTS ALUMNOS CASCADE CONSTRAINTS;
DROP TABLE IF EXISTS CONVENIOS CASCADE CONSTRAINTS;
DROP TABLE IF EXISTS PRACTICAS CASCADE CONSTRAINTS;
DROP TABLE IF EXISTS PROG_FORMATIVOS CASCADE CONSTRAINTS;
DROP TABLE IF EXISTS TUTORES CASCADE CONSTRAINTS;



CREATE TABLE ALUMNOS(
DNI	NUMBER(9) PRIMARY KEY,
NMATRICULA	NUMBER(5) UNIQUE, 
APE1	VARCHAR2(25) NOT NULL, 
APE2	VARCHAR2(25) NOT NULL,
NOMBRE	VARCHAR2(25) NOT NULL, 
FECNA	DATE, 
DIRECCION	VARCHAR2(50),
POBLA	VARCHAR2(25),
PROVINCIA 	VARCHAR2(20), 
CP	NUMBER(5), 
TEL	NUMBER(9),
TMOVIL 	NUMBER(5), 
EMAIL	VARCHAR2(20),
AFCT	VARCHAR2(10));

CREATE TABLE CONVENIOS(
NCONVENIO	NUMBER(3) PRIMARY KEY, 
EMPRESA	VARCHAR2(50) UNIQUE,
CIF	VARCHAR2(10) UNIQUE,
REPRESENTANTE	VARCHAR2(50) NOT NULL,
NIF	VARCHAR2(10) NOT NULL,
DIRECCION	VARCHAR2(50) NOT NULL,
POBLACION	VARCHAR2(25) NOT NULL,
PROVINCIA	VARCHAR2(20) NOT NULL,
CP	NUMBER(5) NOT NULL,
TELEMP	NUMBER(9),
CONTACTO	VARCHAR2(50),
TELCON	NUMBER(9),
TMOVIL	NUMBER(9),
EMAIL	VARCHAR2(20),
DISTANCIA	NUMBER(2));

CREATE TABLE  PROG_FORMATIVOS (
NCONVENIO	NUMBER(3),
NPROGRAMA	NUMBER(2),
APRODUCTIVA	VARCHAR2(1000),
AEVALUACION	VARCHAR2(1000),
CTERMINAL	VARCHAR2(1000),
PRIMARY KEY (NCONVENIO, NPROGRAMA),
FOREIGN KEY (NCONVENIO) REFERENCES CONVENIOS);

CREATE TABLE  TUTORES( 
NOMBTUTOR	VARCHAR2(50),
NCONVENIO	NUMBER(3),
TEL	NUMBER(9),
TMOVIL	NUMBER(9),
FOREIGN KEY (NCONVENIO) REFERENCES CONVENIOS,
PRIMARY KEY (NOMBTUTOR, NCONVENIO));



CREATE TABLE PRACTICAS(
NCONVENIO	NUMBER(3),
NPROGRAMA	NUMBER(2),
DNI	NUMBER(9),
FECINI	DATE,
FECFIN	DATE,
CENTRO_TRABAJO	VARCHAR2(50),
HORARIO	VARCHAR2(20),
CURSO	VARCHAR2(10),
NTUTOR	VARCHAR2(50),
VALORACION	VARCHAR2(10),
PRIMARY KEY (DNI, CURSO),
FOREIGN KEY (DNI)  REFERENCES ALUMNOS,
FOREIGN KEY (NTUTOR, NCONVENIO) REFERENCES TUTORES(NOMBTUTOR, NCONVENIO),
FOREIGN KEY (NCONVENIO, NPROGRAMA)REFERENCES PROG_FORMATIVOS);



INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(243456789,12345,'CASO','DE LOPEZ','SUSANA','R�O TAJU�A','ALCALA DE HENARES','MADRID',28803 ,918876543);



INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(237898757,12346,'FERNANDEZ','ABRIL','MANUEL','PL. JAZM�N 6','ALCALA DE HENARES','MADRID',28803 ,918886543);
   

INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(243458740,12347,'ABAD','GOMEZ','ISABEL','N��EZ DE GUZM�N 38','ALCALA DE HENARES','MADRID',28802 ,918844543);


INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(243556789,12350,'CASO','DE LOPEZ','MANUEL','VAL 63','LOS SANTOS DE LA HUMOSA','MADRID',28817 ,918127654);


INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(982243456,12300,'CONDE','LOPEZ','ARCADIO','NARDO 6','ALCALA DE HENARES','MADRID',28803 ,918876543);

INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(243003456,12301,'HERNANDO','AGUIRRE','LUCIA','BUEND�A 8','ALCALA DE HENARES','MADRID',28803 ,918571543);


INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(243456500,12302,'LOPEZ SERRANO','CARRERO','LOURDES','C�NDOR 28','ARGANDA DEL REY','MADRID',28500 ,918704654);


INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(243381156,12303,'CASERO','PEREZ','JERONIMO','M�RTIRES DE CAMARMA 13','CAMARMA DE ESTERUELAS','MADRID',28816 ,918857543);

   INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(202369841,12423,'ALOSETE','PEREZ','MIGUEL ANGEL','PRADO DE SANTO DOMINGO 1','TORREJON','MADRID',28850 ,916757543);

INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(524517890,12424,'ALVAREZ','LOPEZ','RAMON','EMBAJADORES 7','CAMARMA DE ESTERUELAS','MADRID',28816 ,918307549);

INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(125695123,12425,'CANEDO','ROZAS','PEDRO','SENDERILLO 2','AJALVIR','MADRID',28835 ,914208543);

INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(258185239,12426,'CARBONELL','FRADE','MIGUEL','FLORES 4','ALCALA DE HENARES','MADRID',28806 ,918801543);

INSERT INTO ALUMNOS(DNI, NMATRICULA, APE1, APE2, NOMBRE, DIRECCION, POBLA, PROVINCIA, CP, TEL) 
VALUES(22028115,12427,'ZAMBRANO','GARCIA','IVAN','TOLEDO 7','ALCALA DE HENARES','MADRID',28807 ,918585543);











INSERT INTO CONVENIOS (NCONVENIO, EMPRESA, CIF, REPRESENTANTE, NIF, DIRECCION, POBLACION, PROVINCIA, CP, TELEMP, CONTACTO, TELCON, DISTANCIA) VALUES (1,'INSTITUTO TECNICO DE MATERIALES Y 
CONSTRUCCION',12345678,'MARTIN LOPEZ AGUDO', 102569842,'PG IND LAS MONJAS','TORREJON DE ARDOZ','MADRID',28850, 916568866,'RAUL ALCA�IZ MARTIN', 916568866,7);

INSERT INTO CONVENIOS (NCONVENIO, EMPRESA, CIF, REPRESENTANTE, NIF, DIRECCION, POBLACION, PROVINCIA, CP, TELEMP, CONTACTO, TELCON, DISTANCIA)
 VALUES (2,'POLISEDA SL',896521471,'BLANCA ALVAREZ MADRID', 5252565856,'CTRA CAMARMA 2,80','LCALA DE HENARES','MADRID',28806, 918885589,'AMPARO  ORTEGA ORTIZ', 918885589,3);

INSERT INTO CONVENIOS (NCONVENIO, EMPRESA, CIF, REPRESENTANTE, NIF, DIRECCION, POBLACION, PROVINCIA, CP, TELEMP, CONTACTO, TELCON, DISTANCIA) 
VALUES (3,'ROBERT BOSCH ESPA�A FABRICA DE ;ALA DE HENARES',561258745,'CARMEN PE�ASCO RAMOS', 5451215470,'AVDA MADRID 0042','ALCALA DE HENARES','MADRID',28802, 918523002,'EUGENIO S�NCHEZ GUIJARRO', 918878411,7);

INSERT INTO CONVENIOS (NCONVENIO, EMPRESA, CIF, REPRESENTANTE, NIF, DIRECCION, POBLACION, PROVINCIA, CP, TELEMP, CONTACTO, TELCON, DISTANCIA) VALUES (4,'ALCALA INDUSTRIAL SA',552121003,'CARLOS NOGUEIRA CAMPOS', 
023652087,'CTRA ANTIGUA DEL AEROPUERTO DE TORREJON 1600','ALCALA DE HENARES','MADRID',28806, 914782000,'JUAN PEDRO MONTES TOL�N', 914782021,12);

INSERT INTO CONVENIOS (NCONVENIO, EMPRESA, CIF, REPRESENTANTE, NIF, DIRECCION, POBLACION, PROVINCIA, CP, TELEMP, CONTACTO, TELCON, DISTANCIA) 
VALUES (5,'LABORATORIOS MEDICAMENTOS INTERNACIONALES SA',032896325,'DANIEL RAMIREZ NAVALES', 022563287,'CL SOLANA 0026 PG IND NUMERO 1','TORREJON DE ARDOZ','MADRID',28850, 916785000,'PILAR GONZ�LEZ COLLADO', 916785056,12);

INSERT INTO CONVENIOS (NCONVENIO, EMPRESA, CIF, REPRESENTANTE, NIF, DIRECCION, POBLACION, PROVINCIA, CP, TELEMP, CONTACTO, TELCON, DISTANCIA) 
VALUES (6,'GESTORES DE CONTENIDOS EN INTERNET',032512417,'FERNANDO R�BAGO BENITEZ', 923112907,'CTRA M-300 (DE N-III A ALCALA DE HENARES) 29,9','ALCALA DE HENARES','MADRID',28802, 918826503,'MANUEL IGLESIAS GALLEGO', 918826503,7);

INSERT INTO PROG_FORMATIVOS(NCONVENIO,NPROGRAMA)
VALUES (1,1);
INSERT INTO PROG_FORMATIVOS(NCONVENIO,NPROGRAMA)
VALUES (2,1);
INSERT INTO PROG_FORMATIVOS(NCONVENIO,NPROGRAMA)
VALUES (3,1);
INSERT INTO PROG_FORMATIVOS(NCONVENIO,NPROGRAMA)
VALUES (4,1);
INSERT INTO PROG_FORMATIVOS(NCONVENIO,NPROGRAMA)
VALUES (5,1);
INSERT INTO PROG_FORMATIVOS(NCONVENIO,NPROGRAMA)
VALUES (1,2);
INSERT INTO PROG_FORMATIVOS(NCONVENIO,NPROGRAMA)
VALUES (1,3);
INSERT INTO PROG_FORMATIVOS(NCONVENIO,NPROGRAMA)
VALUES (2,2);
INSERT INTO PROG_FORMATIVOS(NCONVENIO,NPROGRAMA)
VALUES (5,2);

INSERT INTO TUTORES (NOMBTUTOR, NCONVENIO, TEL)
VALUES ('RAUL ALCA�IZ MARTIN',1, 916568866);
INSERT INTO TUTORES (NOMBTUTOR, NCONVENIO, TEL)
VALUES ('AMPARO  ORTEGA ORTIZ', 2, 918885589);
INSERT INTO TUTORES (NOMBTUTOR, NCONVENIO, TEL)
VALUES ('JUAN PEDRO MONTES TOL�N',3, 914782021);
INSERT INTO TUTORES (NOMBTUTOR, NCONVENIO, TEL)
VALUES ('PILAR GONZ�LEZ COLLADO',4, 916785056);
INSERT INTO TUTORES (NOMBTUTOR, NCONVENIO, TEL)
VALUES ('MANUEL IGLESIAS GALLEGO',5, 918826503);
INSERT INTO TUTORES (NOMBTUTOR, NCONVENIO, TEL)
VALUES ('PILAR MANJAVACAS APARICIO',1,916568867);
INSERT INTO TUTORES (NOMBTUTOR, NCONVENIO, TEL)
VALUES ('TOMAS GALLEGO ANDUJAR',1, 916568868);
INSERT INTO PRACTICAS(NCONVENIO  ,NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (1,1, 982243456, '1/4/2002','15/6/2002','9 A 14 Y 5 A 19','2001-2002', 'RAUL ALCA�IZ MARTIN', 'APTO');
INSERT INTO PRACTICAS(NCONVENIO  ,NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (1,1, 243003456, '1/4/2002','15/6/2002','8 A 15:45','2001-2002', 'RAUL ALCA�IZ MARTIN', 'APTO');
INSERT INTO PRACTICAS(NCONVENIO  ,NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (2,1, 243456500, '1/4/2002','15/6/2002','9 A 14 Y 5 A 19','2001-2002', 'AMPARO  ORTEGA ORTIZ', 'APTO');
INSERT INTO PRACTICAS(NCONVENIO  ,NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (3,1, 243381156, '1/4/2002','15/6/2002','9 A 14 Y 5 A 19','2001-2002', 'JUAN PEDRO MONTES TOL�N','NO APTO');

INSERT INTO PRACTICAS(NCONVENIO  ,NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (1,1, 243381156, '1/4/2002','15/6/2002','9 A 14 Y 5 A 19','2002-2003', 'RAUL ALCA�IZ MARTIN','APTO');

INSERT INTO PRACTICAS(NCONVENIO  ,NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (1,2, 202369841, '1/4/2002','15/6/2002','9 A 14 Y 5 A 19','2002-2003','PILAR MANJAVACAS APARICIO', 'APTO');
INSERT INTO PRACTICAS(NCONVENIO  ,NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (1,2, 524517890, '1/4/2002','15/6/2002','9 A 14 Y 5 A 19','2002-2003','TOMAS GALLEGO ANDUJAR', 'APTO');
INSERT INTO PRACTICAS(NCONVENIO  ,NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (2,1, 125695123, '1/4/2002','15/6/2002','9 A 14 Y 5 A 19','2002-2003','AMPARO  ORTEGA ORTIZ', 'APTO');
INSERT INTO PRACTICAS(NCONVENIO  ,NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (2,1, 258185239, '1/4/2002','15/6/2002','9 A 14 Y 5 A 19','2002-2003', 'AMPARO  ORTEGA ORTIZ', 'APTO');
INSERT INTO PRACTICAS(NCONVENIO  ,NPROGRAMA, DNI, FECINI, FECFIN, HORARIO, CURSO, NTUTOR, VALORACION)
VALUES (3,1, 22028115, '1/4/2002','15/6/2002' ,'8 A 15:45', '2002-2003', 'JUAN PEDRO MONTES TOL�N', 'APTO');


commit;
