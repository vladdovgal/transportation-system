<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All Parcels</title>
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet">
    <x></x>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap" rel="stylesheet">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

    <link rel="stylesheet" type="text/css"
          href="css/style.css">
</head>
<body>
<div class="col-12">
    <div class="row header">
        <div class="col-3">
            <h1>Parcels List Page</h1>
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

    <table class="table col-12">
        <thead class="thead-dark">
        <tr>
            <th>Parcel ID</th>
            <th>Sender's Name</th>
            <th>Recipient's Name</th>
            <th>From</th>
            <th>To</th>
            <th>Weight</th>
            <th>Status</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${parcels}" var="parcel">
            <tr>
                <td class="id"><c:out value="${parcel.id}"/></td>
                <td><c:out value="${parcel.senderName}"/></td>
                <td><c:out value="${parcel.recipientName}"/></td>
                <td><c:out value="${parcel.startCity}"/></td>
                <td><c:out value="${parcel.endCity}"/></td>
                <td><c:out value="${parcel.weight}"/></td>
                <td>
                    <p data-status="${parcel.status}" class="status">
                    </p>
                </td>
                <td>
                    <button type="button" class="btn btn-info btn-lg" onclick="openModalInfo('${parcel.id}')">
                        Info
                    </button>
                    <div id="myModal${parcel.id}" class="modal">
                        <!-- Modal content -->
                        <div class="modal-content">
                            <button type="button" class="btn btn-danger btn-sm close"
                                    onclick="closeModalInfo('${parcel.id}')">&times;
                            </button>
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>Attribute</th>
                                    <th>Value</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th>Parcel ID</th>
                                    <th>${parcel.id}</th>
                                </tr>
                                <tr>
                                    <th>Sender:</th>
                                    <th>${parcel.senderName} from
                                            ${parcel.startCity}</th>
                                </tr>
                                <tr>
                                    <th>Recipient:</th>
                                    <th>${parcel.recipientName} from
                                            ${parcel.endCity}</th>
                                </tr>
                                <tr>
                                    <th>Weight:</th>
                                    <th>${parcel.weight} kg</th>
                                </tr>
                                <tr>
                                    <th>Current Status:</th>
                                    <th>${parcel.status}</th>
                                </tr>
                                <tr>
                                    <th>Created:</th>
                                    <th>${parcel.timeCreated}</th>
                                </tr>
                                <tr>
                                    <th>Last Updated:</th>
                                    <th>${parcel.timeUpdated}</th>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <a href="ParcelServlet.do?action=edit&parcelId=<c:out value="${parcel.id }"/>">
                        <button type="button" class="btn btn-dark btn-lg">
                            Update
                        </button>
                    </a>
                    <a href="ParcelServlet.do?action=delete&parcelId=<c:out value="${parcel.id }"/>">
                        <button type="button" class="btn btn-danger btn-lg">
                            Delete
                        </button>
                    </a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="ParcelServlet.do?action=insert">
        <button type="button" class="btn btn-primary btn-lg">
            Create Parcel
        </button>
    </a>
</div>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>