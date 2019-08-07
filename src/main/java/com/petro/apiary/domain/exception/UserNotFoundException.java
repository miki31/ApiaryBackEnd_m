package com.petro.apiary.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    private Long id;
    private String errorDescription;

    public UserNotFoundException(Long id , String errorDescription){
        this.id = id;
        this.errorDescription = errorDescription;
    }
}
