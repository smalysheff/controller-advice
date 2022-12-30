package ru.smal.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementFoundExeption.class)
    public ResponseEntity<ErrorDetail> handleNoSuchException(RuntimeException ex, WebRequest request) {
        ErrorDetail detail = new ErrorDetail();
        detail.setTimestamp(LocalDateTime.now());
        detail.setStatus(HttpStatus.NOT_FOUND);
        detail.setErrorDesc(ex.getMessage());
        detail.setPath(request.getContextPath());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(detail);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorDetail> handleValidateException(RuntimeException ex, WebRequest request) {
        ErrorDetail detail = new ErrorDetail();
        detail.setTimestamp(LocalDateTime.now());
        detail.setStatus(HttpStatus.BAD_REQUEST);
        detail.setErrorDesc(ex.getMessage());
        detail.setPath(request.getContextPath());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(detail);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ErrorDetail detail = new ErrorDetail();
        detail.setTimestamp(LocalDateTime.now());
        detail.setStatus(HttpStatus.NOT_FOUND);
        detail.setErrorDesc(ex.getMessage());
        detail.setPath(request.getContextPath());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(detail);
    }
}
