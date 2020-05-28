<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Event Logs</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

    <link rel="stylesheet" type="text/css"
          href="css/style.css">
</head>
<body>
<div class="col-12">
    <div class="row header">
        <div class="col-3">
            <h1>Cities List Page</h1>
        </div>
        <div>
            <a href="ParcelServlet.do?action=listParcels" class="top-toolbar-item">PARCELS</a>
        </div>
        <div>
            <a href="CityServlet.do?action=listCities" class="top-toolbar-item">CITIES</a>
        </div>
        <div>
            <a href="LogsServlet.do?action=listLogs" class="top-toolbar-item">EVENT LOGS</a>
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
            <th>MESSAGE</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${logs}" var="log">
            <tr>
                <td><c:out value="${log.dated}"/></td>
                <td><c:out value="${log.logger}"/></td>
                <td><c:out value="${log.level}"/></td>
                <td><c:out value="${log.message}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>