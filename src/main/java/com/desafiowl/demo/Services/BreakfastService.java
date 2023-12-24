package com.desafiowl.demo.Services;

import com.desafiowl.demo.Dtos.BreakfastDto;
import com.desafiowl.demo.Model.Breakfast;
import com.desafiowl.demo.Repository.BreakfastRepository;
import com.fasterxml.jackson.core.PrettyPrinter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BreakfastService {

    private final BreakfastRepository breakfastRepository;

    public BreakfastService(BreakfastRepository breakfastRepository) {
        this.breakfastRepository = breakfastRepository;
    }

    public void addBreakfast(BreakfastDto breakfastDto) {
        Breakfast breakfast = breakfastDto.toEntity();

        this.breakfastRepository.save(breakfast);
    }

    public BreakfastDto GetBreakFastWithId(long id) {
        Optional<Breakfast> breakfast = this.breakfastRepository.findById(id);

        return breakfast.orElseThrow(() -> new RuntimeException("id not found")).toDTO();
    }

    public BreakfastDto deleteBreakfastById(long id) {
        Optional<Breakfast> optionalBreakfast = this.breakfastRepository.findById(id);
        if (optionalBreakfast.isPresent()) {
            Breakfast deletedBreakfast = optionalBreakfast.get();
            this.breakfastRepository.delete(deletedBreakfast);
            return deletedBreakfast.toDTO();
        } else {
            throw new RuntimeException("Breakfast not found");
        }
    }
}
















