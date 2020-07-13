package com.dovhal.servlet;

import com.dovhal.dao.CityDaoImpl;
import com.dovhal.model.City;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CityServlet.do")
public class CityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final String LIST_CITY = "jsp/listCities.jsp";
    public static final String INSERT_OR_EDIT = "jsp/city.jsp";
    private CityDaoImpl dao = new CityDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward = "";
        String action = req.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            forward = LIST_CITY;
            String cityId = req.getParameter("cityId");
            dao.deleteEntity(cityId);
            req.setAttribute("cities", dao.getAllEntities());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            String cityId = req.getParameter("cityId");
            City city = dao.getEntityById(cityId);
            req.setAttribute("city", city);
        } else if (action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
        } else {
            forward = LIST_CITY;
            req.setAttribute("cities", dao.getAllEntities());
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(forward);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        City city = new City();
        city.setCityName(req.getParameter("cityName"));
        city.setCityAlias(req.getParameter("cityAlias"));

        String cityId = req.getParameter("cityId");
        if (cityId == null || cityId.isEmpty()){
            dao.createEntity(city);
        } else {
            city.setId(cityId);
            dao.updateEntity(city);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(LIST_CITY);
        req.setAttribute("cities", dao.getAllEntities());
        requestDispatcher.forward(req, resp);
    }
}
