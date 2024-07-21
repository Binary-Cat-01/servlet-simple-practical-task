package com.walking.servletpractice.storage;

import com.walking.servletpractice.model.AbstractCalculationExpression;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CalculationHistoryStorage {
    private static final CalculationHistoryStorage INSTANCE = new CalculationHistoryStorage();

    private final List<AbstractCalculationExpression> history = new CopyOnWriteArrayList<>();

    private CalculationHistoryStorage() {
    }

    public static CalculationHistoryStorage getInstance() {
        return INSTANCE;
    }

    public void add(AbstractCalculationExpression expression) {
        history.add(expression);
    }

    public List<AbstractCalculationExpression> getAll() {
        return List.copyOf(history);
    }
}
