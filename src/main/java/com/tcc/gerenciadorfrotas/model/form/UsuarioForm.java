package com.tcc.gerenciadorfrotas.model.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
public class UsuarioForm {
	@NotBlank(message = "Nome não pode estar em branco")
	private String nome;
	@CPF(message = "Número de CPF inválido")
	private String cpf;
	@NotBlank @Email(message = "Endereço de e-mail inválido")
	private String email;
	@NotBlank(message = "CNH não pode estar em branco")
	private String cnh;
	@NotBlank(message = "Tipo de CNH não pode estar em branco")
	private String tipoCnh;

}
