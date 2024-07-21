package com.walking.servletpractice.model;

import java.util.List;
import java.util.stream.Collectors;

public class AdditionCalculationExpression extends AbstractCalculationExpression {
    private final List<Double> terms;

    public AdditionCalculationExpression(List<Double> terms) {
        super(calculate(terms));

        this.terms = terms;
    }

    @Override
    public String getExpression() {
        var leftExpression = terms.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" + "));

        return "%s = %s".formatted(leftExpression, result.toString());
    }

    private static Double calculate(List<Double> terms) {
        return terms.stream()
                .mapToDouble(d -> d)
                .sum();
    }
}
