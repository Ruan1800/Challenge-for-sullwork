package com.desafiowl.demo.exception;

public class BadRequestException extends AbstractException {

    public BadRequestException(String descricao) {
        super(descricao);
    }
}