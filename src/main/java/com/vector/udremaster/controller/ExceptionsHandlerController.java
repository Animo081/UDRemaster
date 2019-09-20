package com.vector.udremaster.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionsHandlerController {

    @ResponseStatus(value = HttpStatus.CONFLICT , reason = "Attempt to insert or update" +
            " data results in violation of an integrity constraint")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void uniqueConflict() {}

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The element being requested" +
            " * does not exist")
    @ExceptionHandler(NoSuchElementException.class)
    public void notFound() {}
}
