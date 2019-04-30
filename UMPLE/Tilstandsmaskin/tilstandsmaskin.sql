//%% NEW FILE EXPO BEGINS HERE %%

-- PLEASE DO NOT EDIT THIS CODE
-- This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!



/*
@@@skipcppcompile - Contains Java Code
@@@skipphpcompile - Contains Java Code
@@@skiprubycompile - Contains Java Code
*/
CREATE TABLE IF NOT EXISTS `expo`
(
  /*------------------------*/
  /* MEMBER VARIABLES       */
  /*------------------------*/
  
  /*EXPO State Machines*/
  expo ENUM('lag_bruker', 'adminbruker', 'statestikk', 'gruppekonto', 'stand', 'brukerkonto', 'stemme', 'lage_eller_oppdatere_expo', 'done'),
  PRIMARY KEY(expo)

);