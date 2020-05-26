<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All Parcels</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

    <link rel="stylesheet" type="text/css"
          href="css/style.css">
</head>
<body>
<div class="col-12">
    <div class="">
        <div class="row header">
            <div class="col-3">
                <h1>Parcels List Page</h1>
            </div>
            <div class="col-1">
                <a href="ParcelServlet.do?action=listParcels" class="top-toolbar-item">PARCELS</a>
            </div>
            <div class="col-1">
                <a href="CityServlet.do?action=listCities" class="top-toolbar-item">CITIES</a>
            </div>
            <div class="col-7">

            </div>
        </div>
    </div>


    <table class="table table-striped col-12">
        <thead>
        <tr>
            <th>Parcel ID</th>
            <th>Sender's Name</th>
            <th>Recipient's Name</th>
            <th>From</th>
            <th>To</th>
            <th>Weight</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${parcels}" var="parcel">
            <tr>
                <td><c:out value="${parcel.id}"/></td>
                <td><c:out value="${parcel.senderName}"/></td>
                <td><c:out value="${parcel.recipientName}"/></td>
                <td><c:out value="${parcel.startCity}"/></td>
                <td><c:out value="${parcel.endCity}"/></td>
                <td><c:out value="${parcel.weight}"/></td>
                <td>
                    <button type="button" class="btn btn-dark btn-lg">
                        <a href="ParcelServlet.do?action=edit&parcelId=<c:out value="${parcel.id }"/>">Update</a>
                    </button>

                    <button type="button" class="btn btn-danger btn-lg">
                        <a href="ParcelServlet.do?action=delete&parcelId=<c:out value="${parcel.id }"/>">Delete</a>
                    </button>

                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type="button" class="btn btn-primary btn-lg">
        <a href="ParcelServlet.do?action=insert">Create Parcel</a>
    </button>
</div>
</body>