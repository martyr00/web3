package com.example.lr2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CalcFunctionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        double start = Double.parseDouble(request.getParameter("start"));
        double end = Double.parseDouble(request.getParameter("end"));
        double step = Double.parseDouble(request.getParameter("step"));


        CalcFunction calcFunction = new CalcFunction(start, end, step);

        request.setAttribute("xValues", calcFunction.xValues);
        request.setAttribute("yValues", calcFunction.yValues);
        request.setAttribute("maxIndex", calcFunction.getMaxI());
        request.setAttribute("minIndex", calcFunction.getMinI());
        request.setAttribute("sum", calcFunction.getSum());
        request.setAttribute("average", calcFunction.getAverage());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
    }

}

