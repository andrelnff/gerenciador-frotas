package com.tcc.gerenciadorfrotas.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "veiculo")
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="veiculo_id")
	private Long id;
	private String marca;
	private String modelo;
	private Long ano;
	private String placa;
	private String chassi;
	private String estadoAtual;
	private Long quilometragem;
}