CREATE TABLE veiculo (
    veiculo_id int NOT NULL AUTO_INCREMENT,
    marca varchar(100),
    modelo varchar(100),
    ano int,
    placa varchar(10) NOT NULL,
    chassi varchar(20) NOT NULL,
    estado_atual int, 
    
    PRIMARY KEY (veiculo_id),
    UNIQUE KEY (placa),
    UNIQUE KEY(chassi)
);