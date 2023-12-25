package com.desafiowl.demo.Controller;

import com.desafiowl.demo.Dtos.MensagemErroDto;
import com.desafiowl.demo.exception.BadRequestException;
import com.desafiowl.demo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<MensagemErroDto> badRequest(BadRequestException ex) {
        return new ResponseEntity<>(new MensagemErroDto(HttpStatus.BAD_REQUEST.value(), ex.getMsg()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<MensagemErroDto> notFound(NotFoundException ex) {
        return new ResponseEntity<>(new MensagemErroDto(HttpStatus.BAD_REQUEST.value(), ex.getMsg()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<MensagemErroDto> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();

        ex.getBindingResult()
                .getAllErrors()
                .forEach(error -> errors.add(error.getDefaultMessage()));

        return new ResponseEntity<>(new MensagemErroDto(HttpStatus.BAD_REQUEST.value(), errors), HttpStatus.BAD_REQUEST);
    }
}
