create table categorias(
idcategoria int not null auto_increment,
nombre varchar(45) not null,
primary key (idcategoria)
)



CREATE TABLE docente
(
 iddocente 		 INT NOT NULL AUTO_INCREMENT,
 nombre		      VARCHAR(45) NOT NULL,
 dni	          CHAR(8) not null,
 fechaNacimiento  DATE not null,
 sueldo     	  DOUBLE not null,
 email 			  VARCHAR(45),
 sexo             VARCHAR(45),
 idcategoria      int,
 PRIMARY KEY (iddocente),
 KEY `FK_docente_categorias` (`idcategoria`),
 CONSTRAINT `FK_docente_categorias` FOREIGN KEY (`idcategoria`) REFERENCES `categorias` (`idcategoria`)
);

INSERT INTO categorias (nombre) VALUES ('Profesor');
INSERT INTO categorias (nombre) VALUES ('Asistente');
INSERT INTO categorias (nombre) VALUES ('Instructor');



INSERT INTO docente (nombre, dni, fechaNacimiento, sueldo, email, sexo, idcategoria)
VALUES ('Juan Pérez', '12345678', '1990-01-15', 50000.00, 'juan.perez@example.com', 'Masculino', 1);

INSERT INTO docente (nombre, dni, fechaNacimiento, sueldo, email, sexo, idcategoria)
VALUES ('María García', '98765321', '1985-05-20', 55000.00, 'maria.garcia@example.com', 'Femenino', 2);

INSERT INTO docente (nombre, dni, fechaNacimiento, sueldo, email, sexo, idcategoria)
VALUES ('Carlos Rodríguez', '56789012', '1982-08-10', 48000.00, 'carlos.rodriguez@example.com', 'Masculino', 3);


