package com.tcc.gerenciadorfrotas.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "viagem")
public class Viagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="viagem_id")
	private Long id;
	@Column(name="horario_saida")
	private String horarioSaida;
	@Column(name="horario_chegada")
	private String horarioChegada;
	@Column(name="odometro_saida")
	private Long odometroSaida;
	@Column(name="odometro_chegada")
	private Long odometroChegada;
	private String destino;
	private String multa;
	private String acidente;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="veiculo_id")
	private Veiculo veiculo;
	
}
