package com.walking.servletpractice.servlet.calculation;

import com.walking.servletpractice.service.CalculationService;
import com.walking.servletpractice.util.ServletUtils;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addition")
public class AdditionServlet extends HttpServlet {
    private final CalculationService calculationService = CalculationService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            var terms = ServletUtils.getParameterAsDoubleList(request, "term");

            if (terms.isEmpty()) {
                ServletUtils.writeResponseBody(response, "Empty expression");
            }

            var responseMessage = calculationService.sum(terms)
                    .getExpression();

            ServletUtils.writeResponseBody(response, responseMessage);
        } catch (IllegalStateException | NumberFormatException e) {
            response.setStatus(400);
            ServletUtils.writeResponseBody(response, "Incorrect parameters");
        } catch (Exception e) {
            response.setStatus(500);
            ServletUtils.writeResponseBody(response, "Unknown error");
        }
    }
}
