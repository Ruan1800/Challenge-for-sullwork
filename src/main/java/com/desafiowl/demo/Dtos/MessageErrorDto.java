package com.desafiowl.demo.Dtos;

import java.util.List;

public class MensageErrorDto {

    private int status;
    private String error;
    private List<String> errors;

    public MensageErrorDto(int status, String msg) {
        this.status = status;
        this.error = msg;
    }

    public MensageErrorDto(int status, String msg, List<String> erros) {
        this.error = msg;
        this.status = status;
        this.errors = erros;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return error;
    }

    public List<String> getErros() {
        return errors;
    }
}
