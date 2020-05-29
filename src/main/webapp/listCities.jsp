<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All Cities</title>
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet">
    <x></x>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

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
                        <button type="button" class="btn btn-dark btn-lg">
                            Update
                        </button>
                    </a>
                    <a href="CityServlet.do?action=delete&cityId=<c:out value="${city.id }"/>">
                        <button type="button" class="btn btn-danger btn-lg">
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
</body>