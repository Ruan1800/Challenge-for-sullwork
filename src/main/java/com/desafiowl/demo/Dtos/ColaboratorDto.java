package com.desafiowl.demo.Dtos;

import com.desafiowl.demo.Model.Colaborator;

public class ColaboratorDto {

    private Long id;
    private String name;
    private String cpf;

    public ColaboratorDto() {

    }

    public Colaborator toEntity() {
        Colaborator colaborator = new Colaborator();
        colaborator.setName(this.name);
        colaborator.setCpf(this.cpf);

        return colaborator;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getCpf() {
            return cpf;
        }
    public void setCpf(String cpf) {
        this.cpf = cpf;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


}
