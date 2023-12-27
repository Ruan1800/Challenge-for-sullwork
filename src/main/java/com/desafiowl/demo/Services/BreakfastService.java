package com.desafiowl.demo.Services;

import com.desafiowl.demo.Dtos.BreakfastDto;
import com.desafiowl.demo.Model.Breakfast;
import com.desafiowl.demo.Repository.BreakfastRepository;
import com.desafiowl.demo.exception.BadRequestException;
import com.desafiowl.demo.exception.NotFoundException;
import com.desafiowl.demo.utils.CpfValidador;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BreakfastService {

    private final BreakfastRepository breakfastRepository;

    public BreakfastService(BreakfastRepository breakfastRepository) {
        this.breakfastRepository = breakfastRepository;
    }

    public BreakfastDto addBreakfast(BreakfastDto breakfastDto) {
        this.validateBreakFast(breakfastDto);

        Breakfast breakfast = breakfastDto.toEntity();
        Breakfast breakfastSave = this.breakfastRepository.save(breakfast);

        return breakfastSave.toDTO();
    }

    public BreakfastDto updateBreakfast(BreakfastDto breakfastDto, Long id) {
        this.getBreakFastWithId(id);
        this.validateBreakFast(breakfastDto);

        Breakfast breakfast = breakfastDto.toEntity();
        breakfast.setId(id);

        Breakfast breakfastSave = this.breakfastRepository.save(breakfast);

        return breakfastSave.toDTO();
    }

    public List<BreakfastDto> getAllBreakFastByDate(LocalDate date) {
        List<Breakfast> list = this.breakfastRepository.findAllBreakFastByData(date);

        return list.stream().map(x -> x.toDTO()).toList();
    }

    public BreakfastDto getBreakFastWithId(Long id) {
        Optional<Breakfast> breakfast = this.breakfastRepository.findBreakfastById(id);

        return breakfast.orElseThrow(() -> new NotFoundException(Arrays.asList("Breakfast not found"))).toDTO();
    }


    public void deleteBreakFast(Long id) {
        this.getBreakFastWithId(id);
        this.breakfastRepository.deleteBreakFastById(id);
    }





    private void validateBreakFast(BreakfastDto breakfastDto) {
        List<String> validationErros = new ArrayList<>();
        Long existCpf = this.breakfastRepository.existsByCpfAndData(breakfastDto.getCpf().trim(), breakfastDto.getData());

        if (StringUtils.isBlank(breakfastDto.getOptionBreakfast().trim()))
            validationErros.add("Breakfast option is mandatory!");
        if (StringUtils.isBlank(breakfastDto.getNameColaborator().trim()))
            validationErros.add("Colaborator name is mandatory!");
            if (breakfastDto.getData() == null) validationErros.add("Breakfast date is mandatory!");
        if (breakfastDto.getData().isBefore(LocalDate.now()))
            validationErros.add("Breakfast date cannot be earlier than the current date!");
        if (StringUtils.isBlank(breakfastDto.getCpf().trim())) validationErros.add("CPF is mandatory");
        if (breakfastDto.getCpf().trim().length() > 11) validationErros.add("CPF must have 11 characters!");
        if (!CpfValidador.isValidCpf(breakfastDto.getCpf().trim())) validationErros.add("CPF invalid!");
        if (existCpf > 0)
            validationErros.add("Colaborator  Name:" + breakfastDto.getNameColaborator().toUpperCase() + " and CPF: " + breakfastDto.getCpf() + " already partake of breakfast of the day " + breakfastDto.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Long existsByDataAndOptionBreakfast = this.breakfastRepository.existsByDataAndOptionBreakfast(breakfastDto.getData(), breakfastDto.getOptionBreakfast().toUpperCase().trim());

        if (existsByDataAndOptionBreakfast > 0)
            validationErros.add("of the day " + breakfastDto.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " For breakfast you already have: " + breakfastDto.getOptionBreakfast().toUpperCase().trim());

        if (validationErros.size() > 0) throw new BadRequestException(validationErros);
    }
}















