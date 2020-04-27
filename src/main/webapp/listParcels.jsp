<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All Parcels</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>
<div class="container container-default">
    <h1>Parcel List Page</h1>
    <table class="table table-striped">
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
                <td><a class="btn btn-primary" role="button"
                        <c:out value="16+64*2"/>
                       href="ParcelServlet.do?action=edit&parcelId=<c:out value="${parcel.id }"/>">Update</a>
                    <a class="btn btn-primary" role="button" style="padding-left:5px;"
                       href="ParcelServlet.do?action=delete&parcelId=<c:out value="${parcel.id }"/>">Delete</a>

                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p>
        <a href="ParcelServlet.do?action=insert" class="btn btn-primary" role="button">Create Parcel</a>
    </p>
</div>
</body>