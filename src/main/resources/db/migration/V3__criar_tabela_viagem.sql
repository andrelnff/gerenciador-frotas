CREATE TABLE viagem (
    viagem_id int NOT NULL AUTO_INCREMENT,
    horario_saida DATETIME NOT NULL,
    horario_chegada DATETIME NOT NULL,
    odometroSaida bigint NOT NULL,
    odometroChegada bigint NOT NULL,
    destino varchar(200) NOT NULL,
    multa int,
    acidente int,
    usuario_id int NOT NULL,
    veiculo_id int NOT NULL,
    
    PRIMARY KEY (viagem_id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id),
    FOREIGN KEY (veiculo_id) REFERENCES veiculo(veiculo_id)
);