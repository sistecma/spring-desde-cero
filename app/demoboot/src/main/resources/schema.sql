CREATE TABLE IF NOT EXISTS clientes (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  nombres varchar(100) NOT NULL,
  apellidos varchar(100) NOT NULL,
  cedula varchar(20) NOT NULL,
  celular varchar(15) NOT NULL,
  correo varchar(50) NOT NULL,

  PRIMARY KEY (id)
);

