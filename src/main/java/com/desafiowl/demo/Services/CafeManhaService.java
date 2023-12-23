package com.desafiowl.demo.Services;

import com.desafiowl.demo.Dtos.CafeManhaDto;
import com.desafiowl.demo.Model.CafeManha;
import com.desafiowl.demo.Repository.CafeManhaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CafeManhaService {

    private final CafeManhaRepository cafeManhaRepository;

    public CafeManhaService(CafeManhaRepository cafeManhaRepository) {
        this.cafeManhaRepository = cafeManhaRepository;
    }

    public void adicionarCafe(CafeManhaDto cafeManhaDto) {
        CafeManha cafeManha = cafeManhaDto.toEntity();

        this.cafeManhaRepository.save(cafeManha);
    }

    public CafeManhaDto buscarCafePorId(long id) {
        Optional<CafeManha> cafeManha = this.cafeManhaRepository.findById(id);

        return cafeManha.orElseThrow(() -> new RuntimeException("id não encontrado")).toDTO();
    }
}
