DROP TABLE MESSAGE;
DROP TABLE RESPONSABLE;
DROP TABLE PERSONNE;
DROP TABLE BUREAU;


CREATE TABLE BUREAU(
    BUREAU_ID integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    BATIMENT VARCHAR(1),
    NUMERO VARCHAR(3) NOT NULL,
    ETAGE VARCHAR(1) NOT NULL,
    NB_MAX_PERSONNE INTEGER NOT NULL
);
ALTER TABLE BUREAU ADD CONSTRAINT BUREAU_UNIQUE UNIQUE (BATIMENT, NUMERO, ETAGE);
ALTER TABLE BUREAU ADD CONSTRAINT BATIMENT_CK CHECK (BATIMENT IN ('A', 'B'));
ALTER TABLE BUREAU ADD CONSTRAINT ETAGE_CK CHECK (ETAGE IN ('1', '2', '3'));


CREATE TABLE PERSONNE(
    PERSONNE_ID integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    NOM VARCHAR(30) NOT NULL,
    PRENOM VARCHAR(30) NOT NULL,
    MAIL VARCHAR(60) NOT NULL,
    EQUIPE VARCHAR(10) NOT NULL,
    DATE_DEBUT DATE NOT NULL,
    DATE_FIN DATE,
    BUREAU_ID integer
);
ALTER TABLE PERSONNE ADD CONSTRAINT PERSONNE_FK FOREIGN KEY (BUREAU_ID) REFERENCES BUREAU(BUREAU_ID);


CREATE TABLE MESSAGE(
    MESSAGE_ID integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    TEXTE VARCHAR(300) NOT NULL,
    DATE_MESSAGE DATE,
    PERSONNE_ID INTEGER
);
ALTER TABLE MESSAGE ADD CONSTRAINT MESSAGE_FK FOREIGN KEY (PERSONNE_ID) REFERENCES PERSONNE(PERSONNE_ID);


CREATE TABLE RESPONSABLE(
    PERSONNE_ID integer NOT NULL,
    IDENTIFIANT VARCHAR(30),
    MOT_DE_PASSE VARCHAR(30)
);
ALTER TABLE RESPONSABLE ADD CONSTRAINT RESPONSABLE_PK PRIMARY KEY (PERSONNE_ID);
ALTER TABLE RESPONSABLE ADD CONSTRAINT RESPONSABLE_FK FOREIGN KEY (PERSONNE_ID) REFERENCES PERSONNE(PERSONNE_ID);
ALTER TABLE RESPONSABLE ADD CONSTRAINT RESPONSABLE_UNIQUE UNIQUE(IDENTIFIANT);

/* -------------- */

INSERT INTO BUREAU (BATIMENT, NUMERO, ETAGE, NB_MAX_PERSONNE)
VALUES ('A', '111', '1', 2);
INSERT INTO BUREAU (BATIMENT, NUMERO, ETAGE, NB_MAX_PERSONNE)
VALUES ('B', '222', '2', 1);
INSERT INTO BUREAU (BATIMENT, NUMERO, ETAGE, NB_MAX_PERSONNE)
VALUES ('A', '333', '3', 4);

INSERT INTO PERSONNE (NOM, PRENOM, MAIL, EQUIPE, DATE_DEBUT, DATE_FIN, BUREAU_ID)
VALUES ('CAILLOU', 'Pierre', 'caillou@mail.fr', 'LCR', '2014-11-20', null, 1);
INSERT INTO PERSONNE (NOM, PRENOM, MAIL, EQUIPE, DATE_DEBUT, DATE_FIN, BUREAU_ID)
VALUES ('SAINT-SAENS', 'Camille', 'camzor@mail.fr', 'CALIN', '2014-11-20', null, 2);
INSERT INTO PERSONNE (NOM, PRENOM, MAIL, EQUIPE, DATE_DEBUT, DATE_FIN, BUREAU_ID)
VALUES ('DE ST EXUPERY', 'Antoine', 'antoine@mail.fr', 'CALIN', '2014-11-20', null, 3);

INSERT INTO MESSAGE (TEXTE, DATE_MESSAGE, PERSONNE_ID)
VALUES ('Bonjour les admins !', '2014-12-01', 1);
INSERT INTO MESSAGE (TEXTE, DATE_MESSAGE, PERSONNE_ID)
VALUES ('Click here to [SPAM]', '2014-12-04', 2);

INSERT INTO RESPONSABLE (PERSONNE_ID, IDENTIFIANT, MOT_DE_PASSE)
VALUES (2, 'admin', 'admin');
