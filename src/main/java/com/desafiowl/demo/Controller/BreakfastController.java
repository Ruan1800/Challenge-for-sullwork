package com.desafiowl.demo.Controller;

import com.desafiowl.demo.Dtos.BreakfastDto;
import com.desafiowl.demo.Services.BreakfastService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/break-fast")
public class BreakfastController {

    private final BreakfastService breakfastService;

    public BreakfastController(BreakfastService breakfastService) {
        this.breakfastService = breakfastService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BreakfastDto addBreakfast(@RequestBody BreakfastDto breakfast) {
        return this.breakfastService.addBreakfast(breakfast);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BreakfastDto> getAllBreakFastByDate(@RequestParam(value = "date", required = false) LocalDate data) {
        return this.breakfastService.getAllBreakFastByDate(data);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BreakfastDto getBreakFastWithId(@PathVariable("id") Long id) {
        return this.breakfastService.getBreakFastWithId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BreakfastDto updateBreakFast(@PathVariable("id") Long id, @RequestBody BreakfastDto breakfastDto) {
        return this.breakfastService.updateBreakfast(breakfastDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBreakFast(@PathVariable("id") Long id) {
        this.breakfastService.deleteBreakFast(id);
    }
}





















