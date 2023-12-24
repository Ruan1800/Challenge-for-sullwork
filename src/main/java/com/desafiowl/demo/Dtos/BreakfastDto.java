package com.desafiowl.demo.Dtos;

import com.desafiowl.demo.Model.Breakfast;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;

import java.time.LocalDate;

public class BreakfastDto {

    private long id;
    private String nameColaborator;
    private String cpf;
    private String optionBreakfast;
    private LocalDate data;

    public BreakfastDto() {

    }

    public Breakfast toEntity() {
        Breakfast breakfast = new Breakfast();

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

    public void setNameColaborator(String nameColaborator) {
        this.nameColaborator = nameColaborator;
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
