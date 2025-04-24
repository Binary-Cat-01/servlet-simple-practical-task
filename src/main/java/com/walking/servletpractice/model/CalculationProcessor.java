package com.walking.servletpractice.model;

import com.walking.servletpractice.converter.CalculationConverter;
import com.walking.servletpractice.service.CalculationHistoryService;
import com.walking.servletpractice.service.CalculationService;

public class CalculationProcessor {
    private final CalculationService calculationService;
    private final CalculationConverter calculationConverter;
    private final CalculationHistoryService calculationHistoryService;

    public CalculationProcessor(CalculationService calculationService,
            CalculationConverter calculationConverter,
            CalculationHistoryService calculationHistoryService) {
        this.calculationService = calculationService;
        this.calculationConverter = calculationConverter;
        this.calculationHistoryService = calculationHistoryService;
    }

    public String process(String inputData) {

    }
}
