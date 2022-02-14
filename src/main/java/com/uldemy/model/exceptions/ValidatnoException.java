package com.uldemy.model.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ValidatnoException extends RuntimeException {

    private Map<String, String> erros = new HashMap<>();

    public ValidatnoException(String message) {
        super(message);
    }

    public Map<String, String> getErros(){
        return erros;
    }

    public void addError(String fieldName, String errorMessage){
        erros.put(fieldName, errorMessage);
    }
}
