package com.desafiowl.demo.Model;

import com.desafiowl.demo.Dtos.CafeManhaDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;


@Entity
public class CafeManha {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nomeColaborador;
    private String cpf;
    private String opcaoCafe;
    private LocalDate data;

    public CafeManha(long id, String nomeColaborador, String cpf, String opcaoCafe, LocalDate date) {
        this.id = id;
        this.nomeColaborador = nomeColaborador;
        this.cpf = cpf;
        this.opcaoCafe = opcaoCafe;
        this.data = date;
    }

    public CafeManha() {
    }

    public CafeManhaDto toDTO() {
        CafeManhaDto cafeManha = new CafeManhaDto();

        cafeManha.setId(this.id);
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
