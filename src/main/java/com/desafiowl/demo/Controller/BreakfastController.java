package com.desafiowl.demo.Controller;

import com.desafiowl.demo.Dtos.BreakfastDto;
import com.desafiowl.demo.Services.BreakfastService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cafe-da-manha")
public class BreakfastController {


    private final BreakfastService breakfastService;


    public BreakfastController(BreakfastService breakfastService) {
        this.breakfastService = breakfastService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBreakfast(@RequestBody BreakfastDto breakfast) {
        breakfastService.addBreakfast(breakfast);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BreakfastDto GetBreakFastWithId(@PathVariable("id") long id) {
        return  breakfastService.GetBreakFastWithId(id);
    }

    @PutMapping("/update/{id}")
    public BreakfastDto updateBreakfast(@PathVariable("id") long id, @RequestBody BreakfastDto updatedBreakfast) {
        ResponseEntity<String> updateBreakfast = breakfastService.updateBreakfast(id, updatedBreakfast);
        return updatedBreakfast;
    }

    public ResponseEntity<String> deleteBreakfast(@PathVariable("id") long id) {
        ResponseEntity<String> response = breakfastService.deleteBreakfast(id);
        return response;
    }
}











