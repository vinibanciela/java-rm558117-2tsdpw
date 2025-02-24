package br.com.fiap.api_rest.exception

import org.springframework.web.bind.annotation.XX;
import org.springframework.web.bind.annotation.MethodArgumentNotValid;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ValidationExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RespondeEntity<Map<String,String>>
            handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        for (FieldError fe : ex.getBindingResult().getFieldErrors())
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}


