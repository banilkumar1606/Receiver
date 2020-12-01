package com.benz.event.receiver.exceptions;


import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class ReceiverExceptionHandler.
 */
@RestControllerAdvice

/** The Constant log. */
@Slf4j
public class ReceiverExceptionHandler{

    /**
     * Handle access denied exception.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException exception) {
        String exceptionMessage = exception.getMessage();
        log.error("Access Denied", exception);
        LogRefClass logref = LogRefClass.builder().status(401)
                .message(exceptionMessage).build();
        return new ResponseEntity<>(logref, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ReceiverServiceException.class)
    protected ResponseEntity<Object> handleReceiverServiceException(ReceiverServiceException exception) {
        log.error("Internal server", exception);
        LogRefClass logref = LogRefClass.builder().status(500).message(exception.getMessage())
                .build();
        return new ResponseEntity<>(logref, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
