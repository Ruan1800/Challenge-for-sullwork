package com.desafiowl.demo.exception;

import java.util.List;

public class BadRequestException extends AbstractException {

    public BadRequestException(List<String> msgs) {
        super("BadRequest", msgs);
    }
}