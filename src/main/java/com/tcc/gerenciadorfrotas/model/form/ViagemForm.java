package com.tcc.gerenciadorfrotas.model.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.tcc.gerenciadorfrotas.model.entity.Usuario;
import com.tcc.gerenciadorfrotas.model.entity.Veiculo;

import lombok.Data;

@Data
public class ViagemForm {
	@NotBlank(message = "Horario de saida não pode estar em branco")
	private String horarioSaida;
	@NotBlank(message = "Horario de chegada pode estar em branco")
	private String horarioChegada;
	@NotBlank(message = "Odometro de saida não pode estar em branco")
	private String odometroSaida;
	@NotBlank(message = "Odometro de chegada não pode estar em branco")
	private String odometroChegada;
	@NotBlank(message = "Destino não pode estar em branco")
	private String destino;
	private String multa;
	private String acidente;
	@NotNull(message = "Usuario não pode ser nulo")
	private Usuario usuario;
	@NotNull(message = "Veiculo não pode ser nulo")
	private Veiculo veiculo;

}

