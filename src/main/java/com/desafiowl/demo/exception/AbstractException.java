package com.desafiowl.demo.exception;

public abstract class AbstractException extends RuntimeException {

    private String erro;
    private String descricao;

    protected AbstractException(String erro, String descricao) {
        this.erro = erro;
        this.descricao = descricao;
    }
}