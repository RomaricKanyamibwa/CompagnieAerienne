DROP TRIGGER IF EXISTS TypeAvionTR^;



CREATE TRIGGER TypeAvionTR BEFORE INSERT ON typea
FOR EACH ROW 
BEGIN 
IF (New.type_avion REGEXP '^[A-Z][A-Z0-9]+' ) = 0 THEN 
  SIGNAL SQLSTATE '12345'
     SET MESSAGE_TEXT = 'Wrong Format:TypeAvion commence obligatoirement par une lettre';
END IF ; 
END^; 

-- DROP TRIGGER IF EXISTS NumVolTR;

-- CREATE TRIGGER NumVolTR BEFORE INSERT ON vol
-- FOR EACH ROW 
-- BEGIN 
-- IF (New.num_vol REGEXP '^IT[A-Z0-9]{4}' ) = 0 THEN 
--   SIGNAL SQLSTATE '12345'
--      SET MESSAGE_TEXT = 'Wrong Format for NumVol: NumVol doit commencer obligatoirement par IT[num4chiffres]';
-- END IF ; 
-- END^; 

