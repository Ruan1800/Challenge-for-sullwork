package com.desafiowl.demo.Model;

import com.desafiowl.demo.Dtos.BreakfastDto;
import com.desafiowl.demo.Dtos.ColaboratorDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Colaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String cpf;


    public Colaborator(long id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    public Colaborator() {
    }
    public ColaboratorDto toDTO() {
        ColaboratorDto colaborator = new ColaboratorDto();

        colaborator.setId(this.id);
        colaborator.setCpf(this.cpf);
        colaborator.setName(this.name);

        return colaborator;
    }

        public Long getId () {
            return id;
        }

        public void setId (Long id){
            this.id = id;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }

        public String getCpf () {
            return cpf;
        }

        public void setCpf (String cpf){
            this.cpf = cpf;
        }
    }

