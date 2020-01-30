DROP TRIGGER IF EXISTS TypeAvionTR^;



CREATE TRIGGER TypeAvionTR BEFORE INSERT ON typea
FOR EACH ROW 
BEGIN 
	IF (New.type_avion REGEXP '^[A-Z][A-Z0-9]+' ) = 0 THEN 
	  SIGNAL SQLSTATE '12345'
	     SET MESSAGE_TEXT = 'Wrong Format:TypeAvion doit commencer obligatoirement par une lettre';
	END IF ; 
END^; 

DROP TRIGGER IF EXISTS NumVolTR^;

CREATE TRIGGER NumVolTR BEFORE INSERT ON vol
FOR EACH ROW 
BEGIN 
	DECLARE messa varchar(100);
 	SET @message := CONCAT(New.num_vol," => Wrong Format for NumVol: NumVol doit commencer obligatoirement par IT suivi de 3 chiffres");
	IF (New.num_vol REGEXP '^IT[0-9]{3}' ) = 0 THEN 
	  SIGNAL SQLSTATE '12345'
	     SET MESSAGE_TEXT = @message;
	END IF ; 
END^; 

