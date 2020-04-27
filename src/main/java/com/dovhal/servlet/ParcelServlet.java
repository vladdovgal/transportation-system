package com.dovhal.servlet;

import com.dovhal.dao.ParcelDao;
import com.dovhal.dao.ParcelDaoImpl;
import com.dovhal.model.City;
import com.dovhal.model.Parcel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@WebServlet("/ParcelServlet.do")
public class ParcelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final String lIST_PARCEL = "/listParcels.jsp";
    public static final String INSERT_OR_EDIT = "/parcel.jsp";
    private ParcelDao dao = new ParcelDaoImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward = "";
        String action = req.getParameter("action");
        List<City> cityList = Arrays.asList(City.values());

        if (action.equalsIgnoreCase("delete")) {
            forward = lIST_PARCEL;
            int parcelId = Integer.parseInt(req.getParameter("parcelId"));
            dao.deleteParcel(parcelId);
            req.setAttribute("parcels", dao.getAllParcels());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int parcelId = Integer.parseInt(req.getParameter("parcelId"));
            Parcel parcel = dao.getParcelById(parcelId);
            req.setAttribute("parcel", parcel);
            req.setAttribute("cities", cityList);
        } else if (action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
            req.setAttribute("cities", cityList);
        } else {
            forward = lIST_PARCEL;
            req.setAttribute("parcels", dao.getAllParcels());
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
       String parcelId = req.getParameter("parcelId");

       if (parcelId == null || parcelId.isEmpty()){
           dao.createParcel(parcel);
       } else {
           parcel.setId(Integer.parseInt(parcelId));
           dao.updateParcel(parcel);
       }
       RequestDispatcher requestDispatcher = req.getRequestDispatcher(lIST_PARCEL);
       req.setAttribute("parcels",dao.getAllParcels());
       requestDispatcher.forward(req,resp);
    }
}
