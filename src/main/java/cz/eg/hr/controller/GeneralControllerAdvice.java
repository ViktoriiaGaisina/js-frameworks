package cz.eg.hr.controller;

import cz.eg.hr.rest.Errors;
import cz.eg.hr.rest.ValidationError;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GeneralControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Errors> handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<ValidationError> errorList = result.getFieldErrors().stream()
            .map(e -> new ValidationError(e.getField(), e.getCode()))
            .toList();

        return ResponseEntity.badRequest().body(new Errors(errorList));
    }

}
