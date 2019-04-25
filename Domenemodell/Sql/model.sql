-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!



/*
Unable to update umple code due to error at [4,2]
*/
CREATE TABLE IF NOT EXISTS `prosjekt`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*prosjekt Associations*/
  studie_navn VARCHAR(255),
  bruker_brukernavn VARCHAR(255),
  bedrift_navn VARCHAR(255),
  
  /*prosjekt Attributes*/
  navn VARCHAR(255),
  beskrivelse VARCHAR(255),
  PRIMARY KEY(navn)

);





CREATE TABLE IF NOT EXISTS `arrangementdeltagelse`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*arrangementdeltagelse Associations*/
  prosjekt_navn VARCHAR(255),
  arrengement_navn VARCHAR(255),
    PRIMARY KEY(prosjekt_navn)

);





CREATE TABLE IF NOT EXISTS `stemme`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*stemme Attributes*/
  epost VARCHAR(255),
  verdi INT,
  tidspunkt DATE,
  PRIMARY KEY(epost)

);





CREATE TABLE IF NOT EXISTS `bruker`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*bruker Associations*/
  brukegruppe_gruppenavn VARCHAR(255),
  
  /*bruker Attributes*/
  brukernavn VARCHAR(255),
  PRIMARY KEY(brukernavn)

);





CREATE TABLE IF NOT EXISTS `bedrift`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*bedrift Attributes*/
  navn VARCHAR(255),
  beskrivelse VARCHAR(255),
  PRIMARY KEY(navn)

);





CREATE TABLE IF NOT EXISTS `brukegruppe`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*brukegruppe Attributes*/
  gruppenavn VARCHAR(255),
  PRIMARY KEY(gruppenavn)

);





CREATE TABLE IF NOT EXISTS `arrengement`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*arrengement Associations*/
  
  /*arrengement Attributes*/
  navn VARCHAR(255),
  beskrivelse VARCHAR(255),
  utgaar DATE,
  PRIMARY KEY(navn)

);





CREATE TABLE IF NOT EXISTS `stemmemetode`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
    PRIMARY KEY(/*No Possible Primary Key*/)

);





CREATE TABLE IF NOT EXISTS `studie`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/

  /*studie Associations*/
  kategori_navn VARCHAR(255),
  
  /*studie Attributes*/
  navn VARCHAR(255),
  beskrivelse VARCHAR(255),
  PRIMARY KEY(navn)

);





CREATE TABLE IF NOT EXISTS `kategori`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*kategori Attributes*/
  navn VARCHAR(255),
  beskrivelse VARCHAR(255),
  PRIMARY KEY(navn)

);


ALTER TABLE `prosjekt` ADD CONSTRAINT `fk_prosjekt_studie_navn` FOREIGN KEY (`studie_navn`) REFERENCES `studie`(`navn`);
ALTER TABLE `prosjekt` ADD CONSTRAINT `fk_prosjekt_bruker_brukernavn` FOREIGN KEY (`bruker_brukernavn`) REFERENCES `bruker`(`brukernavn`);
ALTER TABLE `prosjekt` ADD CONSTRAINT `fk_prosjekt_bedrift_navn` FOREIGN KEY (`bedrift_navn`) REFERENCES `bedrift`(`navn`);

ALTER TABLE `arrangementdeltagelse` ADD CONSTRAINT `fk_arrangementdeltagelse_prosjekt_navn` FOREIGN KEY (`prosjekt_navn`) REFERENCES `prosjekt`(`navn`);
ALTER TABLE `arrangementdeltagelse` ADD CONSTRAINT `fk_arrangementdeltagelse_arrengement_navn` FOREIGN KEY (`arrengement_navn`) REFERENCES `arrengement`(`navn`);


ALTER TABLE `bruker` ADD CONSTRAINT `fk_bruker_brukegruppe_gruppenavn` FOREIGN KEY (`brukegruppe_gruppenavn`) REFERENCES `brukegruppe`(`gruppenavn`);





ALTER TABLE `studie` ADD CONSTRAINT `fk_studie_kategori_navn` FOREIGN KEY (`kategori_navn`) REFERENCES `kategori`(`navn`);

