package com.aluracurso.conversormoneda.exception;

public class TargetCurrencyNotFoundException extends Exception{
    public TargetCurrencyNotFoundException(String targetCode) {
        super("Target currency code not found: " + targetCode);
    }
}

