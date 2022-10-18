package com.tcc.gerenciadorfrotas.model.form.input;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class VeiculoInput {
	
	
	@NotNull
	private Long id;

}
