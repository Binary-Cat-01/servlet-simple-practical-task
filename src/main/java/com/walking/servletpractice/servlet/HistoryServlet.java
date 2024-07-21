package com.walking.servletpractice.servlet;

import com.walking.servletpractice.model.AbstractCalculationExpression;
import com.walking.servletpractice.storage.CalculationHistoryStorage;
import com.walking.servletpractice.util.ServletUtils;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
    private final CalculationHistoryStorage calculationHistoryStorage = CalculationHistoryStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var history = calculationHistoryStorage.getAll();

        if (history.isEmpty()) {
            ServletUtils.writeResponseBody(response, "History is empty!");
            return;
        }

        var result = history.stream()
                .map(AbstractCalculationExpression::getExpression)
                .collect(Collectors.joining("\n"));

        ServletUtils.writeResponseBody(response, result);
    }
}
