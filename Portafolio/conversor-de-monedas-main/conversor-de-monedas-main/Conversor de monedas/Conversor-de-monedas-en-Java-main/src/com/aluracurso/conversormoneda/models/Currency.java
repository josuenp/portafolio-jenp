package com.aluracurso.conversormoneda.models;


import com.aluracurso.conversormoneda.exception.TargetCurrencyNotFoundException;

import java.util.Map;
import java.util.stream.Collectors;

public record Currency(String base_code,
                       String target_code,
                       Map<String, Double> conversion_rates,
                       double conversionRate
){
    public double currencyFilter(Map<String, Double> conversionRates, String targetCode) throws TargetCurrencyNotFoundException {

        Map<String, Double> filteredRates = conversionRates.entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(targetCode))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        //resultado entradas
        if (filteredRates.isEmpty()) {
            throw new TargetCurrencyNotFoundException(targetCode);
        }

        //itera el map devuelve el valor
        double conversionRate = filteredRates.values().iterator().next();
        return conversionRate;
    }

    public double convertAmount (double amount, double conversionRate, String target_code){

        double conversion_result =  amount * conversionRate;
        System.out.println("El valor: "+ amount  +"("+base_code()+")"+" es igual "+conversion_result +"("+target_code+")");
        return conversion_result;
    }


}
