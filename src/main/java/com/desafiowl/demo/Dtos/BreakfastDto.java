package com.desafiowl.demo.Dtos;

import com.desafiowl.demo.Model.Breakfast;

import java.time.LocalDate;

public class CafeManhaDto {

    private long id;
    private String nomeColaborador;
    private String cpf;
    private String opcaoCafe;
    private LocalDate data;

    public CafeManhaDto() {

    }

    public Breakfast toEntity() {
        Breakfast breakfast = new Breakfast();

        breakfast.setCpf(this.cpf);
        breakfast.setData(this.data);
        breakfast.setOpcaoCafe(this.opcaoCafe);
        breakfast.setNomeColaborador(this.nomeColaborador);

        return breakfast;
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
