DROP TRIGGER IF EXISTS TypeAvionTR^;



CREATE TRIGGER TypeAvionTR BEFORE INSERT ON typea
FOR EACH ROW 
BEGIN 
IF (New.type_avion REGEXP '^[A-Z][A-Z0-9]+' ) = 0 THEN 
  SIGNAL SQLSTATE '12345'
     SET MESSAGE_TEXT = 'Wrong Format:TypeAvion commence obligatoirement par une lettre';
END IF ; 
END^; 

