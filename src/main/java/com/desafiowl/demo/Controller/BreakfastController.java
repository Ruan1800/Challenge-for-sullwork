package com.desafiowl.demo.Controller;

import com.desafiowl.demo.Dtos.CafeManhaDto;
import com.desafiowl.demo.Services.CafeManhaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cafe-da-manha")
public class CafeManhaController {


    private final CafeManhaService cafeManhaService;


    public CafeManhaController(CafeManhaService cafeManhaService) {
        this.cafeManhaService = cafeManhaService;
    }

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarCafeDaManha(@RequestBody CafeManhaDto cafeManha) {
        cafeManhaService.adicionarCafe(cafeManha);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CafeManhaDto buscarCafePorId(@PathVariable("id") long id) {
        return  cafeManhaService.buscarCafePorId(id);
    }

}
