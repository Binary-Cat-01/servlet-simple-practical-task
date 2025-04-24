package com.walking.servletpractice.service;

import java.util.ArrayList;
import java.util.List;

public class CalculationHistoryService {
    private final List<String> history = new ArrayList<>();

    public List<String> getHistory() {
        return new ArrayList<>(history);
    }

    public void append(String calculation) {

    }
}
