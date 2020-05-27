package com.dovhal.servlet;

//import com.dovhal.dao.EntityDAO;
import com.dovhal.dao.ParcelDaoImpl;
import com.dovhal.model.City;
import com.dovhal.model.Parcel;
import com.dovhal.model.Status;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet("/ParcelServlet.do")
public class ParcelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final String lIST_PARCEL = "/listParcels.jsp";
    public static final String INSERT_OR_EDIT = "/parcel.jsp";
    public static final List<String> statusList = Arrays.stream(Status.values())
            .map(Enum::toString)
            .collect(Collectors.toList());
    private ParcelDaoImpl dao = new ParcelDaoImpl();


    @Override       
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward = "";
        String action = req.getParameter("action");
        List<City> cities = dao.getAllCities();
        List<String> citiesNames = cities.stream()
                .map(e -> e.getCityName())
                .collect(Collectors.toList());
        if (action.equalsIgnoreCase("delete")) {
            forward = lIST_PARCEL;
            String parcelId = req.getParameter("parcelId");
            dao.deleteEntity(parcelId);
            req.setAttribute("parcels", dao.getAllEntities());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            String parcelId = req.getParameter("parcelId");
            Parcel parcel = dao.getEntityById(parcelId);
            req.setAttribute("parcel", parcel);
            req.setAttribute("cities", citiesNames);
            req.setAttribute("statuss", statusList);
        } else if (action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
            req.setAttribute("cities", citiesNames);
            req.setAttribute("statuss", statusList);
        } else {
            forward = lIST_PARCEL;
            req.setAttribute("parcels", dao.getAllEntities());
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(forward);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Parcel parcel = new Parcel();
       parcel.setSenderName(req.getParameter("senderName"));
       parcel.setRecipientName(req.getParameter("recipientName"));
       parcel.setStartCity(req.getParameter("startCity"));
       parcel.setEndCity(req.getParameter("endCity"));
       parcel.setWeight(Double.parseDouble(req.getParameter("weight")));
       parcel.setStatus(req.getParameter("status"));
       String parcelId = req.getParameter("parcelId");

       if (parcelId == null || parcelId.isEmpty()){
           dao.createEntity(parcel);
       } else {
           parcel.setId(parcelId);
           dao.updateEntity(parcel);
       }
       RequestDispatcher requestDispatcher = req.getRequestDispatcher(lIST_PARCEL);
       req.setAttribute("parcels",dao.getAllEntities());
       requestDispatcher.forward(req,resp);
    }
}
