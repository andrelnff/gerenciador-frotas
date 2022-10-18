package com.tcc.gerenciadorfrotas.exception;

public class ViagemNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public ViagemNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public ViagemNaoEncontradaException(Long id) {
        this(String.format("Não foi possível encontrar a viagem", id));
    }
}
