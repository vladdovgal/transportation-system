package com.dovhal.servlet;


import com.dovhal.dao.LogDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <h1> LogsServlet </h1>
 * LogsServlet is servlet designed for interacting with LogDao layer
 * and transferring information to View layer (JSP page)
 *
 * @author vladd
 * @version 1.0
 */

@WebServlet("/LogsServlet.do")
public class LogsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // required constants for RequestDispatcher
    public static final String LIST_LOGS = "jsp/listLogs.jsp";
    private LogDaoImpl dao = new LogDaoImpl();

    // processing of GET request
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward = "";
        String action = req.getParameter("action");

        if (action.equalsIgnoreCase("listLogs")) {
            forward = LIST_LOGS;
            req.setAttribute("logs", dao.getAllEntities());
        } else if (action.equalsIgnoreCase("clearLogs")){
            forward = LIST_LOGS;
            dao.clearLogs();
            req.setAttribute("logs", dao.getAllEntities());
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(forward);
        requestDispatcher.forward(req, resp);
    }

    // POST request is not provided on UI
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
