package com.tcc.gerenciadorfrotas.model.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class VeiculoForm {
	@NotBlank(message = "Marca de saida não pode estar em branco")
	private String marca;
	@NotBlank(message = "Modelo de saida não pode estar em branco")
	private String modelo;
	@NotBlank(message = "Ano de saida não pode estar em branco")
	private Long ano;
	@NotBlank(message = "Placa de saida não pode estar em branco")
	private String placa;
	@NotBlank(message = "Chassi de saida não pode estar em branco")
	private String chassi;
	@NotBlank(message = "Estado de saida não pode estar em branco")
	private String estadoAtual;

}
