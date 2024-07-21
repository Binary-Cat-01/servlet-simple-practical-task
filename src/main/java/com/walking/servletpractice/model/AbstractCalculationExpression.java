package com.walking.servletpractice.model;

public abstract class AbstractCalculationExpression {
    protected final Double result;

    public AbstractCalculationExpression(Double result) {
        this.result = result;
    }

    public abstract String getExpression();

    public Double getResult() {
        return result;
    }
}
