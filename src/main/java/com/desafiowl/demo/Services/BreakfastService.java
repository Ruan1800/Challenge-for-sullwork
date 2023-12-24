package com.desafiowl.demo.Services;

import com.desafiowl.demo.Dtos.BreakfastDto;
import com.desafiowl.demo.Model.Breakfast;
import com.desafiowl.demo.Repository.BreakfastRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public ResponseEntity<String> updateBreakfast(long id, BreakfastDto updatedBreakfast) {
        validateBreakfast(updatedBreakfast);

        Optional<Breakfast> optionalBreakfast = this.breakfastRepository.findById(id);

        if (optionalBreakfast.isPresent()) {
            Breakfast existingBreakfast = optionalBreakfast.get();

            existingBreakfast.setNameColaborator(updatedBreakfast.getNameColaborator());
            existingBreakfast.setCpf(updatedBreakfast.getCpf());
            existingBreakfast.setOptionBreakfast(updatedBreakfast.getOptionBreakfast());
            existingBreakfast.setData(updatedBreakfast.getData());

            this.breakfastRepository.save(existingBreakfast);

            return ResponseEntity.status(HttpStatus.OK).body("Breakfast updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Breakfast not found");
        }
    }

    private void validateBreakfast(BreakfastDto breakfastDto) {





}
}
























