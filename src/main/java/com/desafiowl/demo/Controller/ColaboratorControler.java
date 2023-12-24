package com.desafiowl.demo.Controller;


import com.desafiowl.demo.Dtos.ColaboratorDto;
import com.desafiowl.demo.Services.ColaboratorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Colaborator")
public class ColaboratorControler {


    private final ColaboratorService colaboratorService;

    public ColaboratorControler(ColaboratorService colaboratorService) {
        this.colaboratorService =colaboratorService;
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addColaborator(@RequestBody ColaboratorDto colaborator) {
            colaboratorService.addColaborator(colaborator);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ColaboratorDto GetColaboratorWithId(@PathVariable("id")long id) {
        return colaboratorService.GetColaboratorWithId(id);
    }


}
