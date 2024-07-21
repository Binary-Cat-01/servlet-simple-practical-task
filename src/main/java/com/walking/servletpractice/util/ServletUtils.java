package com.walking.servletpractice.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ServletUtils {
    public static void writeResponseBody(HttpServletResponse response, String bodyMessage) throws IOException {
        response.getWriter()
                .println(bodyMessage);
    }

    public static List<Double> getParameterAsDoubleList(HttpServletRequest request, String paramName) {
        return Arrays.stream(request.getParameterValues(paramName))
                .map(Double::parseDouble)
                .toList();
    }
}
