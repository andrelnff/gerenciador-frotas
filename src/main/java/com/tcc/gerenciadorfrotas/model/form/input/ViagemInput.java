package com.tcc.gerenciadorfrotas.model.form.input;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ViagemInput {
	
	@NotNull
	private Long id;

}
