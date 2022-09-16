package com.tcc.gerenciadorfrotas.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "viagem")
public class Viagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String horarioSaida;
	private String horarioChegada;
	private String odometroSaida;
	private String odometroChegado;
	private String destino;
	private String multa;
	private String acidente;
	

}
