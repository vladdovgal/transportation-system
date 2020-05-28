package com.dovhal.servlet;

import com.dovhal.dao.CityDaoImpl;
import com.dovhal.dao.LogDaoImpl;
import com.dovhal.model.City;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LogsServlet.do")
public class LogsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final String LIST_LOGS = "/listLogs.jsp";
    private LogDaoImpl dao = new LogDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward = "";
        String action = req.getParameter("action");

        if (action.equalsIgnoreCase("logs_list")) {
            forward = LIST_LOGS;
            req.setAttribute("logs", dao.getAllEntities());
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(forward);
        requestDispatcher.forward(req, resp);
    }

}
