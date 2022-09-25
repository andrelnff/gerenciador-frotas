CREATE TABLE usuario (
    usuario_id int NOT NULL AUTO_INCREMENT,
    nome varchar(250),
    cpf varchar(11),
    email varchar(100),
    cnh varchar(20) NOT NULL,
    tipoCnh varchar(4) NOT NULL,
    
    PRIMARY KEY (usuario_id),
    UNIQUE KEY (cpf),
    UNIQUE KEY(email),
    UNIQUE KEY (cnh)
);