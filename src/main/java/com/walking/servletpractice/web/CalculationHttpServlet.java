package com.walking.servletpractice.web;

import com.walking.servletpractice.model.CalculationProcessor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/calculator")
public class CalculationHttpServlet extends HttpServlet {
    private final CalculationProcessor calculationProcessor;

    public CalculationHttpServlet(CalculationProcessor calculationProcessor) {
        this.calculationProcessor = calculationProcessor;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        super.doGet(req, resp);
    }
}
