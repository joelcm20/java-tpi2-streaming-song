package com.informatorio.tpi2.exception;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserRequiredException extends RuntimeException {
    public UserRequiredException(UUID id) {
        super(String.format("Usuario requerido: id invalido '%s' proporciona un usuario valido.", id));
    }

    public UserRequiredException() {
        super("Usuario requerido: proporciona un usuario valido.");
    }
}
