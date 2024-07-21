package com.walking.servletpractice.model;

import java.util.List;
import java.util.stream.Collectors;

public class MultiplicationCalculationExpression extends AbstractCalculationExpression {
    private final List<Double> multipliers;

    public MultiplicationCalculationExpression(List<Double> multipliers) {
        super(calculate(multipliers));

        this.multipliers = multipliers;
    }

    @Override
    public String getExpression() {
        var leftExpression = multipliers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" * "));

        return "%s = %s".formatted(leftExpression, result.toString());
    }

    private static Double calculate(List<Double> multipliers) {
        return multipliers.stream()
                .reduce(1D, (el1, el2) -> el1 * el2);
    }
}
