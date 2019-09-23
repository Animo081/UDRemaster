package com.vector.udremaster.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionsHandlerController {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST , reason = "Attempt to insert or update" +
            " data results in violation of an integrity constraint")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void uniqueConflict() {}

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "The element being requested" +
            " * does not exist")
    @ExceptionHandler(NoSuchElementException.class)
    public void noSuchElement() {}

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Could not store file")
    @ExceptionHandler(IOException.class)
    public void uploadError() {}

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Not Found")
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public void notFound() {}
}
