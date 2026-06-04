package com.ankit.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestControllerAdvice //Apply exception handling globally to all controllers.
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,List<String>> handleValidationErrors (MethodArgumentNotValidException ex){

        List<String> err=new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error->
                err.add(error.getDefaultMessage())
        );
        Map<String,List<String>> response=new HashMap<>();
        response.put("Errors",err);
        return response;
    }
}
