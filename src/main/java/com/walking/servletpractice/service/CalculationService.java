package com.walking.servletpractice.service;

import com.walking.servletpractice.model.Calculation;

public class CalculationService {
    private final CalculationParsingService calculationParsingService;

    public CalculationService(CalculationParsingService calculationParsingService) {
        this.calculationParsingService = calculationParsingService;
    }

    public Calculation calculate(String calculationData) {

    }
}
