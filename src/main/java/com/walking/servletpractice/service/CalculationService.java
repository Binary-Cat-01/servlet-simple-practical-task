package com.walking.servletpractice.service;

import com.walking.servletpractice.model.AdditionCalculationExpression;
import com.walking.servletpractice.model.DivisionCalculationExpression;
import com.walking.servletpractice.model.MultiplicationCalculationExpression;
import com.walking.servletpractice.model.SubtractionCalculationExpression;
import com.walking.servletpractice.storage.CalculationHistoryStorage;

import java.util.List;

public class CalculationService {
//    Крайне наивная реализация паттерна singleton. В следующих версиях задачи постепенно будем уходить от нее,
//    как только изученная функциональность Servlet API позволит использовать более безопасные и удобные
//    конструкции
    private static final CalculationService INSTANCE = new CalculationService(
            CalculationHistoryStorage.getInstance());

    private final CalculationHistoryStorage calculationHistoryStorage;

    private CalculationService(CalculationHistoryStorage calculationHistoryStorage) {
        this.calculationHistoryStorage = calculationHistoryStorage;
    }

    public static CalculationService getInstance() {
        return INSTANCE;
    }

    public AdditionCalculationExpression sum(List<Double> terms) {
        var expression = new AdditionCalculationExpression(terms);
        calculationHistoryStorage.add(expression);

        return expression;
    }

    public MultiplicationCalculationExpression multiply(List<Double> multipliers) {
        var expression = new MultiplicationCalculationExpression(multipliers);
        calculationHistoryStorage.add(expression);

        return expression;
    }

    public SubtractionCalculationExpression subtract(Double minuend, List<Double> subtrahends) {
        var expression = new SubtractionCalculationExpression(minuend, subtrahends);
        calculationHistoryStorage.add(expression);

        return expression;
    }

    public DivisionCalculationExpression divide(Double dividend, List<Double> divisors) {
        var expression = new DivisionCalculationExpression(dividend, divisors);
        calculationHistoryStorage.add(expression);

        return expression;
    }
}
