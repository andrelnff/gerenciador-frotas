package com.tcc.gerenciadorfrotas.exception;

public class VeiculoNaoEncontradoException extends EntidadeNaoEncontradaException{
	
	private static final long serialVersionUID = 1L;
	
	public VeiculoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public VeiculoNaoEncontradoException(Long id) {
		this(String.format("Não foi possível encontrar o veículo", id));
	}
}
