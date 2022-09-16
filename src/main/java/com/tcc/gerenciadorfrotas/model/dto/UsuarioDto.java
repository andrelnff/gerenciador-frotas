package com.tcc.gerenciadorfrotas.model.dto;

import com.tcc.gerenciadorfrotas.model.entity.Usuario;

import lombok.Data;

@Data
public class UsuarioDto {

	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String cnh;
	private String tipoCnh;
	
	public UsuarioDto(){
		
	}

	public UsuarioDto(Usuario usuario){
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.email = usuario.getEmail();
		this.cnh = usuario.getCnh();
		this.tipoCnh = usuario.getTipoCnh();
	}
}
