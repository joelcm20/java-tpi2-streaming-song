package com.informatorio.tpi2.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends DataIntegrityViolationException {
    public UserAlreadyExistsException(String user) {
        super(String.format("Usuario invalido: el usuario '%s' ya existe.", user));
    }
}
