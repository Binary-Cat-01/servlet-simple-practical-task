package com.walking.servletpractice.servlet.calculation;

import com.walking.servletpractice.service.CalculationService;
import com.walking.servletpractice.util.ServletUtils;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/division")
public class DivisionServlet extends HttpServlet {
    private final CalculationService calculationService = CalculationService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            var dividend = Double.parseDouble(request.getParameter("dividend"));
            var divisors = ServletUtils.getParameterAsDoubleList(request, "divisor");

            if (divisors.isEmpty()) {
                ServletUtils.writeResponseBody(response, "Empty expression");
            }

            var responseMessage = calculationService.divide(dividend, divisors)
                    .getExpression();

            ServletUtils.writeResponseBody(response, responseMessage);
//            Несложно заметить, что большая часть кода в сервлетах дублируется. Как этого избежать,
//            не создавая побочные иерархии классов разберемся в следующих версиях этой задачи.
//            На данном этапе решением может быть вынесение шаблонного кода в отдельный класс-обертку,
//            утилитный класс со статическим методом или свой абстрактный класс
//            сервлета (этот вариант имеет свои неприятные особенности)
        } catch (IllegalStateException | NumberFormatException e) {
            response.setStatus(400);
            ServletUtils.writeResponseBody(response, "Incorrect parameters");
        } catch (Exception e) {
            response.setStatus(500);
            ServletUtils.writeResponseBody(response, "Unknown error");
        }
    }
}
