package com.tcc.gerenciadorfrotas.model.dto;

import com.tcc.gerenciadorfrotas.model.entity.Veiculo;

import lombok.Data;

@Data
public class VeiculoDto {
	
	private Long id;
	private String marca;
	private String modelo;
	private Long ano;
	private String placa;
	private String chassi;
	private String estadoAtual;
	private Long quilometragem;
	
	public VeiculoDto() {
		
	}
	
	public VeiculoDto(Veiculo veiculo) {
		this.id = veiculo.getId();
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.ano = veiculo.getAno();
		this.placa = veiculo.getPlaca();
		this.chassi = veiculo.getChassi();
		this.estadoAtual = veiculo.getEstadoAtual();
		this.quilometragem = veiculo.getQuilometragem();
	}

}
