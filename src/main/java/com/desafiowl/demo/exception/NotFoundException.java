package com.desafiowl.demo.exception;

import java.util.List;

    public class NotFoundException extends AbstractException {

        public NotFoundException(List<String> msgs) {
            super("NotFound", msgs);
        }
    }
