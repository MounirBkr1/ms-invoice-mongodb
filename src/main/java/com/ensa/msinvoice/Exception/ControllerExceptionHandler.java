package com.ensa.msinvoice.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ControllerExceptionHandler {

//    @ExceptionHandler(ResourceNotFoundException.class)
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
//        ErrorMessage message = new ErrorMessage(
//                HttpStatus.NOT_FOUND.value(),
//                new Date(),
//                ex.getMessage(),
//                request.getDescription(false));
//
//        return message;
//    }


    @ExceptionHandler(InvoiceException.class)
    public ResponseStatusException dbException(InvoiceException exception){

        if(exception instanceof ResourceNotFoundInvoiceException){
            return new ResponseStatusException(HttpStatus.NOT_FOUND,exception.getMessage(),exception);
        }else {
            return new ResponseStatusException(HttpStatus.CONFLICT,exception.getMessage(),exception);
        }

    }
}