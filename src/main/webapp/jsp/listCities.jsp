<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Cities</title>
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet">
    <link rel="icon" href="imgs/delivery-track.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

    <link rel="stylesheet" type="text/css"
          href="css/style.css">
    <script src="https://kit.fontawesome.com/943b69ee10.js" crossorigin="anonymous"></script>

</head>
<body>
<div class="col-12 main-container ">
    <div class="row header">
        <div class="col-4 col-md-6 row">
            <i class="fas fa-shipping-fast fa-3x"></i>
            <h1><b>Transportation System</b></h1>
        </div>
        <div class="col-md-2">
            <a href="ParcelServlet.do?action=listParcels" class="top-toolbar-item">
                <i class="fas fa-box-open"></i>&nbsp;PARCELS</a>
        </div>
        <div class="col-md-2">
            <a href="CityServlet.do?action=listCities" class="top-toolbar-item">
                <i class="fas fa-city"></i>&nbsp;CITIES</a>
        </div>
        <div class="col-md-2">
            <a href="LogsServlet.do?action=listLogs" class="top-toolbar-item">
                <i class="far fa-calendar-alt"></i>&nbsp;EVENT LOGS</a>
        </div>
        <div>

        </div>
    </div>

    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th>City ID</th>
            <th>City Name</th>
            <th>City Alias</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cities}" var="city">
            <tr>
                <td><c:out value="${city.id}"/></td>
                <td><c:out value="${city.cityName}"/></td>
                <td><c:out value="${city.cityAlias}"/></td>
                <td>
                    <a href="CityServlet.do?action=edit&cityId=<c:out value="${city.id }"/>">
                        <button type="button" class="btn btn-dark btn-md">
                            Update
                        </button>
                    </a>
                    <a href="CityServlet.do?action=delete&cityId=<c:out value="${city.id }"/>">
                        <button type="button" class="btn btn-danger btn-md">
                            Delete
                        </button>
                    </a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="CityServlet.do?action=insert">
        <button type="button" class="btn btn-primary btn-lg">
            Add city
        </button>
    </a>
</div>
<footer class="footer py-2 bg-dark text-white-50">
    <div class="container">
        <!-- Grid row-->
        <div class="text-center py-2 container">
            <a href="https://github.com/vladdovgal/transportation-system"
               style="margin-right:20px">
                <i class="fab fa-github fa-3x"></i>
            </a>
            <a href="http://t.me/theonewhovlad">
                <i class="fab fa-telegram fa-3x"></i>
            </a>
        </div>
    </div>
    <div class="footer-copyright text-center py-3">© 2020 Copyright: &nbsp; <b>@theonewhovlad</b></div>
</footer>
</body>