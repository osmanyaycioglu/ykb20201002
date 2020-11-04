package com.training.ykb.error;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handle(final IllegalArgumentException iae) {
        StackTraceElement[] stackTraceLoc = iae.getStackTrace();
        return new ErrorObject().setDomain("IT")
                                .setSubdomain("CRM")
                                .setBoundedContext("contract")
                                .setMicroservice("person")
                                .setMessage(iae.getMessage())
                                .setErrorCause(100);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handle(final MethodArgumentNotValidException manve) {
        List<ObjectError> allErrorsLoc = manve.getBindingResult()
                                              .getAllErrors();
        ErrorObject rootError = new ErrorObject().setDomain("IT")
                                                 .setSubdomain("CRM")
                                                 .setBoundedContext("contract")
                                                 .setMicroservice("person")
                                                 .setMessage("Validation Error")
                                                 .setErrorCause(100);
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            rootError.addSubError(new ErrorObject().setDomain("IT")
                                                   .setSubdomain("CRM")
                                                   .setBoundedContext("contract")
                                                   .setMicroservice("person")
                                                   .setMessage(objectErrorLoc.toString())
                                                   .setErrorCause(101));
        }
        return rootError;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> handle(final Exception iae) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(new ErrorObject().setDomain("IT")
                                                    .setSubdomain("CRM")
                                                    .setBoundedContext("contract")
                                                    .setMicroservice("person")
                                                    .setMessage(iae.getMessage())
                                                    .setErrorCause(400));
    }


}
