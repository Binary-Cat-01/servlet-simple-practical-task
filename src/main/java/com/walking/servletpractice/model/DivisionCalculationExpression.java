package com.walking.servletpractice.model;

import java.util.List;
import java.util.stream.Collectors;

public class DivisionCalculationExpression extends AbstractCalculationExpression {
    private final Double dividend;
    private final List<Double> divisors;

    public DivisionCalculationExpression(Double dividend, List<Double> divisors) {
        super(calculate(dividend, divisors));

        this.dividend = dividend;
        this.divisors = divisors;
    }

    @Override
    public String getExpression() {
        var divisorsPartExpression = divisors.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" / "));

        return "%s / %s = %s".formatted(dividend, divisorsPartExpression, result.toString());
    }

    private static Double calculate(Double dividend, List<Double> divisors) {
        var divisorsProduct = divisors.stream()
                .reduce(1d, (el1, el2) -> el1 * el2);

        return dividend / divisorsProduct;
    }
}
