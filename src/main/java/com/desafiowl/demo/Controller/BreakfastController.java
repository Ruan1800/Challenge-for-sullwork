package com.desafiowl.demo.Controller;

import com.desafiowl.demo.Dtos.BreakfastDto;
import com.desafiowl.demo.Services.BreakfastService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Break-fast")
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
        return breakfastService.GetBreakFastWithId(id);
    }

    @DeleteMapping("/delete/{id}")
    public BreakfastDto deleteBreakfastById(@PathVariable("id") long id) {
        return breakfastService.deleteBreakfastById(id);
    }

    }




















