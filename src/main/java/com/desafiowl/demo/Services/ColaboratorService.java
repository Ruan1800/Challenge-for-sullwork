package com.desafiowl.demo.Services;

import com.desafiowl.demo.Dtos.ColaboratorDto;
import com.desafiowl.demo.Model.Colaborator;
import com.desafiowl.demo.Repository.ColaboratorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColaboratorService {

    private final ColaboratorRepository colaboratorRepository;


    public ColaboratorService(ColaboratorRepository colaboratorRepository) {
        this.colaboratorRepository = colaboratorRepository;
    }

    public void addColaborator(ColaboratorDto colaboratorDto) {
        Colaborator colaborator = colaboratorDto.toEntity();

            this.colaboratorRepository.save(colaborator);
    }

    public ColaboratorDto GetColaboratorWithId(long id) {
        Optional<Colaborator> colaborator = this.colaboratorRepository.findById(id);

        return colaborator.orElseThrow(() -> new RuntimeException("id not found")).toDTO();
    }

}
