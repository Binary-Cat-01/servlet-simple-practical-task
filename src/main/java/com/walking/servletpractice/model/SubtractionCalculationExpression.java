package com.walking.servletpractice.model;

import java.util.List;
import java.util.stream.Collectors;

public class SubtractionCalculationExpression extends AbstractCalculationExpression {
    private final Double minuend;
    private final List<Double> subtrahends;

    public SubtractionCalculationExpression(Double minuend, List<Double> subtrahends) {
        super(calculate(minuend, subtrahends));

        this.minuend = minuend;
        this.subtrahends = subtrahends;
    }

    @Override
    public String getExpression() {
        var subtrahendsPartExpression = subtrahends.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" - "));

        return "%s - %s = %s".formatted(minuend, subtrahendsPartExpression, result.toString());
    }

    private static Double calculate(Double minuend, List<Double> subtrahends) {
        var subtrahendsSum = subtrahends.stream()
                .mapToDouble(d -> d)
                .sum();

        return minuend - subtrahendsSum;
    }
}
