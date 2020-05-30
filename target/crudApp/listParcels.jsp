<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All Parcels</title>
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap" rel="stylesheet">
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

    <table class="table col-12">
        <thead class="thead-dark">
        <tr>
            <th>
                <i class="fas fa-barcode"></i>
                Parcel ID
                <%--                <a href="ParcelServlet.do?action=listParcelsIdAsc">--%>
                <%--                   <i class="fas fa-sort-alpha-down"></i>--%>
                <%--                </a>--%>
                <%--                <a href="ParcelServlet.do?action=listParcelsIdDesc">--%>
                <%--                    <i class="fas fa-sort-alpha-up-alt"></i>--%>
                <%--                </a>--%>
            </th>
            <th>Sender's Name</th>
            <th>Recipient's Name</th>
            <th>From
                <div class="float-right">
                    <a href="ParcelServlet.do?action=listParcelsCity1Asc">
                        <i class="fas fa-sort-alpha-down"></i>
                    </a>
                    <a href="ParcelServlet.do?action=listParcelsCity1Desc">
                        <i class="fas fa-sort-alpha-up-alt"></i>
                    </a>
                </div>
            </th>
            <th>To
                <div class="float-right">
                    <a href="ParcelServlet.do?action=listParcelsCity2Asc">
                        <i class="fas fa-sort-alpha-down"></i>
                    </a>
                    <a href="ParcelServlet.do?action=listParcelsCity2Desc">
                        <i class="fas fa-sort-alpha-up-alt"></i>
                    </a>
                </div>
            </th>
            <th><i class="fas fa-weight-hanging"></i> Weight
                <div class="float-right">
                    <a href="ParcelServlet.do?action=listParcelsWeightAsc">
                        <i class="fas fa-sort-numeric-down"></i>
                    </a>
                    <a href="ParcelServlet.do?action=listParcelsWeightDesc">
                        <i class="fas fa-sort-numeric-up-alt"></i>
                    </a>
                </div>
            </th>
            <th><i class="fas fa-spinner"></i> Status
                <div class="float-right">
                    <a href="ParcelServlet.do?action=listParcelsStatusAsc">
                        <i class="fas fa-sort-alpha-down"></i>
                    </a>
                    <a href="ParcelServlet.do?action=listParcelsStatusDesc">
                        <i class="fas fa-sort-alpha-up-alt"></i>
                    </a>
                </div>
            </th>

            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${parcels}" var="parcel">
            <tr>
                <td onclick="openModalInfo('${parcel.id}')" class="id"><c:out value="${parcel.id}"/></td>
                <td><c:out value="${parcel.senderName}"/></td>
                <td><c:out value="${parcel.recipientName}"/></td>
                <td><c:out value="${parcel.startCity}"/></td>
                <td><c:out value="${parcel.endCity}"/></td>
                <td><c:out value="${parcel.weight}"/>&nbsp;kg</td>
                <td>
                    <p data-status="${parcel.status}" class="status">
                    </p>
                </td>
                <td>
                    <button type="button" class="btn btn-info btn-lg" onclick="openModalInfo('${parcel.id}')">
                        &nbsp;<i class="fas fa-info-circle"></i>&nbsp;
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
                            Update <i class="fas fa-edit"></i>
                        </button>
                    </a>
                    <a href="ParcelServlet.do?action=delete&parcelId=<c:out value="${parcel.id }"/>">
                        <button type="button" class="btn btn-danger btn-lg">
                            Delete <i class="far fa-trash-alt"></i>
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

<script type="text/javascript" src="js/main.js"></script>
</body>
</html>