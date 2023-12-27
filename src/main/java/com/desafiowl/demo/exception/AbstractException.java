package com.desafiowl.demo.exception;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractException extends RuntimeException {

    private String msg;
    private List<String> messages;

    protected AbstractException(String msg, List<String> msgs) {
        this.msg = msg;
        this.messages = msgs;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getMensagens() {
        return messages;
    }

    public void setMensagens(List<String> mensagens) {
        this.messages = mensagens;
    }
}