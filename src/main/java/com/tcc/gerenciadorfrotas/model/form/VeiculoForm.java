package com.tcc.gerenciadorfrotas.model.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class VeiculoForm {
	@NotBlank(message = "Marca de saida não pode estar em branco")
	private String marca;
	@NotBlank(message = "Modelo de saida não pode estar em branco")
	private String modelo;
	@NotNull(message = "Ano de saida não pode ser nulo")
	private Long ano;
	@NotBlank(message = "Placa de saida não pode estar em branco")
	private String placa;
	@NotBlank(message = "Chassi de saida não pode estar em branco")
	private String chassi;
	private String estadoAtual;
	private Long quilometragem;

}
