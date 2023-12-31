package com.informatorio.tpi2.exception;

import com.informatorio.tpi2.constants.ConstantUtils;
import com.informatorio.tpi2.dto.error.ErrorResponseDto;
import org.apache.coyote.BadRequestException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFoundException(NotFoundException exception, WebRequest webRequest) {
        ErrorResponseDto errorResponse = new ErrorResponseDto();
        errorResponse.setApiPath(webRequest.getDescription(false));
        errorResponse.setErrorMessage(exception.getMessage());
        errorResponse.setHttpStatus(HttpStatus.NOT_FOUND);
        errorResponse.setErrorTime(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleUserAlreadyExsistsException(UserAlreadyExistsException exception, WebRequest webRequest) {
        ErrorResponseDto errorResponse = new ErrorResponseDto();
        errorResponse.setApiPath(webRequest.getDescription(false));
        errorResponse.setErrorMessage(exception.getMessage());
        errorResponse.setHttpStatus(HttpStatus.CONFLICT);
        errorResponse.setErrorTime(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserRequiredException.class)
    public ResponseEntity<ErrorResponseDto> handleUserRequiredException(UserRequiredException exception, WebRequest webRequest) {
        ErrorResponseDto errorResponse = new ErrorResponseDto();
        errorResponse.setApiPath(webRequest.getDescription(false));
        errorResponse.setErrorMessage(exception.getMessage());
        errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorResponse.setErrorTime(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDto> handleUserRequiredException(BadRequestException exception, WebRequest webRequest) {
        ErrorResponseDto errorResponse = new ErrorResponseDto();
        errorResponse.setApiPath(webRequest.getDescription(false));
        errorResponse.setErrorMessage(exception.getMessage());
        errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        errorResponse.setErrorTime(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponseDto> handleUserRequiredException(UnauthorizedException exception, WebRequest webRequest) {
        ErrorResponseDto errorResponse = new ErrorResponseDto();
        errorResponse.setApiPath(webRequest.getDescription(false));
        errorResponse.setErrorMessage(exception.getMessage());
        errorResponse.setHttpStatus(HttpStatus.UNAUTHORIZED);
        errorResponse.setErrorTime(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
}
