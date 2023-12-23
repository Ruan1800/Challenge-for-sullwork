package com.desafiowl.demo.Dtos;

import com.desafiowl.demo.Model.CafeManha;

import java.time.LocalDate;

public class CafeManhaDto {

    private long id;
    private String nomeColaborador;
    private String cpf;
    private String opcaoCafe;
    private LocalDate data;

    public CafeManhaDto() {

    }

    public CafeManha toEntity() {
        CafeManha cafeManha = new CafeManha();

        cafeManha.setCpf(this.cpf);
        cafeManha.setData(this.data);
        cafeManha.setOpcaoCafe(this.opcaoCafe);
        cafeManha.setNomeColaborador(this.nomeColaborador);

        return cafeManha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getOpcaoCafe() {
        return opcaoCafe;
    }

    public void setOpcaoCafe(String opcaoCafe) {
        this.opcaoCafe = opcaoCafe;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
