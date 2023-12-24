package com.desafiowl.demo.Model;

import com.desafiowl.demo.Dtos.BreakfastDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;


@Entity
public class Breakfast {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nameColaborator;
    private String cpf;
    private String optionBreakfast;
    private LocalDate data;

    public Breakfast(long id, String nameColaborator, String cpf, String optionBreakfast, LocalDate date) {
        this.id = id;
        this.nameColaborator = nameColaborator;
        this.cpf = cpf;
        this.optionBreakfast = optionBreakfast;
        this.data = date;
    }

    public Breakfast() {
    }

    public BreakfastDto toDTO() {
        BreakfastDto breakfast = new BreakfastDto();

        breakfast.setId(this.id);
        breakfast.setCpf(this.cpf);
        breakfast.setData(this.data);
        breakfast.setOptionBreakfast(this.optionBreakfast);
        breakfast.setNameColaborator(this.nameColaborator);

        return breakfast;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameColaborator() {
        return nameColaborator;
    }

    public void setNameColaborator(String nomeColaborador) {
        this.nameColaborator = nomeColaborador;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getOptionBreakfast() {
        return optionBreakfast;
    }

    public void setOptionBreakfast(String optionBreakfast) {
        this.optionBreakfast = optionBreakfast;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
