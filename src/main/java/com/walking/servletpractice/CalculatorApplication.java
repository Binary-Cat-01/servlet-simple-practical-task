package com.walking.servletpractice;

import com.walking.servletpractice.converter.CalculationConverter;
import com.walking.servletpractice.model.CalculationProcessor;
import com.walking.servletpractice.service.CalculationHistoryService;
import com.walking.servletpractice.service.CalculationParsingService;
import com.walking.servletpractice.service.CalculationService;
import com.walking.servletpractice.web.CalculationHttpServlet;

public class CalculatorApplication {
    public static void main(String[] args) {
        CalculationParsingService calculationParsingService = new CalculationParsingService();
        CalculationService calculationService = new CalculationService(calculationParsingService);

        CalculationHistoryService calculationHistoryService = new CalculationHistoryService();
        CalculationConverter calculationConverter = new CalculationConverter();

        CalculationProcessor calculationProcessor = new CalculationProcessor(
                calculationService, calculationConverter, calculationHistoryService);

        CalculationHttpServlet calculationHttpServlet =
                new CalculationHttpServlet(calculationProcessor);
    }
}
