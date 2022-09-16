package com.tcc.gerenciadorfrotas.model.dto;

import com.tcc.gerenciadorfrotas.model.entity.Usuario;
import com.tcc.gerenciadorfrotas.model.entity.Veiculo;
import com.tcc.gerenciadorfrotas.model.entity.Viagem;

import lombok.Data;

@Data
public class ViagemDto {
	
	private Long id;
	private String horarioSaida;
	private String horarioChegada;
	private String odometroSaida;
	private String odometroChegada;
	private String destino;
	private String multa;
	private String acidente;
	private Usuario usuario;
	private Veiculo veiculo;
	
	public ViagemDto() {
		
	}
	
	public ViagemDto(Viagem viagem) {
		
		this.id = viagem.getId();
		this.horarioSaida = viagem.getHorarioSaida();
		this.horarioChegada = viagem.getHorarioChegada();
		this.odometroSaida = viagem.getOdometroSaida();
		this.odometroChegada = viagem.getOdometroChegada();
		this.destino = viagem.getDestino();
		this.multa = viagem.getMulta();
		this.acidente = viagem.getAcidente();
		
		
	}

}
