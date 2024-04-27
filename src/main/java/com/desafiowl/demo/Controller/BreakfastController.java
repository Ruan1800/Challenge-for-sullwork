package com.desafiowl.demo.Controller;

import com.desafiowl.demo.Dtos.BreakfastDto;
import com.desafiowl.demo.Services.BreakfastService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(description = " adiciona cafe da manha ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " cafe da manha adicionado "),
            @ApiResponse(responseCode = "201", description = " criado com sucesso ")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BreakfastDto addBreakfast(@RequestBody BreakfastDto breakfast) {
        return this.breakfastService.addBreakfast(breakfast);
    }

    @Operation(description = " Busca todos os cafe da manha pela data ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " Retorna todos os cafe da manha pela data ")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BreakfastDto> getAllBreakFastByDate(@RequestParam(value = "date", required = false) LocalDate data) {
        return this.breakfastService.getAllBreakFastByDate(data);
    }

    @Operation(description = " Busca  cafe da manha pelo id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " Retorna  cafe da manha pelo id ")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BreakfastDto getBreakFastWithId(@PathVariable("id") Long id) {
        return this.breakfastService.getBreakFastWithId(id);
    }

    @Operation(description = " Atualiza cafe da manha pelo id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " Retorna o cafe da manha atualizado pelo id ")
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BreakfastDto updateBreakFast(@PathVariable("id") Long id, @RequestBody BreakfastDto breakfastDto) {
        return this.breakfastService.updateBreakfast(breakfastDto, id);
    }

    @Operation(description = " deleta o cafe da manha pelo id ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " Deletado o cafe da manha pelo id "),
            @ApiResponse(responseCode = "204", description = " Sem conteúdo ")

    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBreakFast(@PathVariable("id") Long id) {
        this.breakfastService.deleteBreakFast(id);
    }
}





















