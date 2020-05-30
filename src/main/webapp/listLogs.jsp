<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Event Logs</title>
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet">
    <x></x>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

    <link rel="stylesheet" type="text/css"
          href="css/style.css">
    <script src="https://kit.fontawesome.com/943b69ee10.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="col-12 main-container">
    <div class="row header">
        <div class="col-4 row">
            <i class="fas fa-shipping-fast fa-3x"></i>
            <h1><b>Transportation System</b></h1>
        </div>
        <div>
            <a href="ParcelServlet.do?action=listParcels" class="top-toolbar-item">
                <i class="fas fa-box-open"></i>&nbsp;PARCELS</a>
        </div>
        <div>
            <a href="CityServlet.do?action=listCities" class="top-toolbar-item">
                <i class="fas fa-city"></i>&nbsp;CITIES</a>
        </div>
        <div>
            <a href="LogsServlet.do?action=listLogs" class="top-toolbar-item">
                <i class="far fa-calendar-alt"></i>&nbsp;EVENT LOGS</a>
        </div>
        <div>

        </div>
    </div>

    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>DATE & TIME</th>
            <th>LOGGER</th>
            <th>LEVEL</th>
            <th>MESSAGE
                <a href="LogsServlet.do?action=clearLogs">
                    <div class="float-right btn-clear">
                        Clear logs <i class="fas fa-broom"></i>
                    </div>
                </a>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${logs}" var="log">
            <tr>
                <td><c:out value="${log.dated}"/></td>
                <td><c:out value="${log.logger}"/></td>
                <td><p data-status="${log.level}" class="level"></p>
                <td><c:out value="${log.message}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
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