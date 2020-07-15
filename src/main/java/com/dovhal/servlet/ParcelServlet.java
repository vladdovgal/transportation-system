package com.dovhal.servlet;

import com.dovhal.dao.ParcelDaoImpl;
import com.dovhal.model.City;
import com.dovhal.model.Parcel;
import com.dovhal.model.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * <h1> ParcelServlet </h1>
 * ParcelServlet is servlet designed for interacting with ParcelDao layer
 * and transferring information to View layer (JSP page)
 *
 * @author vladd
 * @version 1.0
 */
@WebServlet("/ParcelServlet.do")
public class ParcelServlet extends HttpServlet implements Filter {
    private static Logger logger = LogManager.getLogger(ParcelServlet.class);
    private static final long serialVersionUID = 1L;

    // some required constants for RequestDispatcher path
    public static final String lIST_PARCEL = "jsp/listParcels.jsp";
    public static final String INSERT_OR_EDIT = "jsp/parcel.jsp";
    public static final String FILTER = "jsp/filter.jsp";

    // getting information about existing statuses of parcel (from Enum class)
    public static final List<String> statusList = Arrays.stream(Status.values())
            .map(Enum::toString)
            .collect(Collectors.toList());

    // DarcelDAO implementation entity to interract with
    private ParcelDaoImpl dao = new ParcelDaoImpl();


    // Processing of GET request
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward = "";
        String action = req.getParameter("action");
        // get cities from DB
        List<City> cities = dao.getAllCities();

        // get city names and convert to List<String>
        List<String> citiesNames = cities.stream()
                .map(City::getCityName)
                .collect(Collectors.toList());

        // processing action
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
        }
        // processing of ORDER_BY buttons
        else if (action.equalsIgnoreCase("listParcelsIdAsc")) {
            forward = lIST_PARCEL;
            req.setAttribute("parcels", dao.getAllEntities("parcelId", "ASC"));
        } else if (action.equalsIgnoreCase("listParcelsIdDesc")) {
            forward = lIST_PARCEL;
            req.setAttribute("parcels", dao.getAllEntities("parcelId", "DESC"));
        } else if (action.equalsIgnoreCase("listParcelsCity1Asc")) {
            forward = lIST_PARCEL;
            req.setAttribute("parcels", dao.getAllEntities("startCity", "ASC"));
        } else if (action.equalsIgnoreCase("listParcelsCity1Desc")) {
            forward = lIST_PARCEL;
            req.setAttribute("parcels", dao.getAllEntities("startCity", "DESC"));
        } else if (action.equalsIgnoreCase("listParcelsCity2Asc")) {
            forward = lIST_PARCEL;
            req.setAttribute("parcels", dao.getAllEntities("endCity", "ASC"));
        } else if (action.equalsIgnoreCase("listParcelsCity2Desc")) {
            forward = lIST_PARCEL;
            req.setAttribute("parcels", dao.getAllEntities("endCity", "DESC"));
        } else if (action.equalsIgnoreCase("listParcelsWeightAsc")) {
            forward = lIST_PARCEL;
            req.setAttribute("parcels", dao.getAllEntities("weight", "ASC"));
        } else if (action.equalsIgnoreCase("listParcelsWeightDesc")) {
            forward = lIST_PARCEL;
            req.setAttribute("parcels", dao.getAllEntities("weight", "DESC"));
        } else if (action.equalsIgnoreCase("listParcelsStatusAsc")) {
            forward = lIST_PARCEL;
            req.setAttribute("parcels", dao.getAllEntities("status", "ASC"));
        } else if (action.equalsIgnoreCase("listParcelsStatusDesc")) {
            forward = lIST_PARCEL;
            req.setAttribute("parcels", dao.getAllEntities("status", "DESC"));
        } else if (action.equalsIgnoreCase("filter")) {
            forward = FILTER;
//            req.setAttribute("cities", citiesNames);
            req.setAttribute("statuss", statusList);
        } else if(action.equalsIgnoreCase("filtered_parcels")){
            forward = lIST_PARCEL;
            String status = req.getParameter("status");
            req.setAttribute("parcels", dao.getFilteredParcels(status));
        }
        else {
            forward = lIST_PARCEL;
            req.setAttribute("parcels", dao.getAllEntities());
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(forward);
        requestDispatcher.forward(req, resp);
    }

    // Processing of POST request
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Parcel parcel = new Parcel();
        parcel.setSenderName(new String(req.getParameter("senderName")
                .getBytes("ISO-8859-1"),"UTF-8"));
        parcel.setRecipientName(new String(req.getParameter("recipientName").
                getBytes("ISO-8859-1"), "UTF-8"));
        parcel.setStartCity(new String(req.getParameter("startCity")
                .getBytes("ISO-8859-1"), "UTF-8"));
        parcel.setEndCity(new String(req.getParameter("endCity")
                .getBytes("ISO-8859-1"), "UTF-8"));
        parcel.setWeight(Double.parseDouble(req.getParameter("weight")));
        parcel.setStatus(new String(req.getParameter("status")
                .getBytes("ISO-8859-1"), "UTF-8"));
        String parcelId = req.getParameter("parcelId");

        // parcel id is null by default
        if (parcelId == null || parcelId.isEmpty()) {
            dao.createEntity(parcel);
        } else {
            parcel.setId(parcelId);
            dao.updateEntity(parcel);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(lIST_PARCEL);
        req.setAttribute("parcels", dao.getAllEntities());
        requestDispatcher.forward(req, resp);
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }
}
