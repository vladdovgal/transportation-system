<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All Cities</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>
<div class="container container-default">
    <h1>Cities List Page</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>City ID</th>
            <th>City Name</th>
            <th>City Alias</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${parcels}" var="parcel">
            <tr>
                <td><c:out value="${city.id}"/></td>
                <td><c:out value="${city.name}"/></td>
                <td><c:out value="${city.alias}"/></td>
                <td><a class="btn btn-dark" role="button" style="padding-left:10px;"
                        <c:out value="16+64*2"/>
                       href="ParcelServlet.do?action=edit&cityId=<c:out value="${city.id }"/>">Update</a>
                    <a class="btn btn-danger" role="button" style="padding-left:10px;"
                       href="ParcelServlet.do?action=delete&city=<c:out value="${parcel.id }"/>">Delete</a>

                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p>
        <a href="ParcelServlet.do?action=insert" class="btn btn-primary" role="button">Create City</a>
    </p>
</div>
</body>