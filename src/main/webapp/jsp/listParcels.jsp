<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Parcels</title>
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap" rel="stylesheet">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <link rel="icon" href="imgs/delivery-track.png">
    <link rel="icon" href="imgs/delivery-track.png">

    <script src="https://kit.fontawesome.com/943b69ee10.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css"
          href="css/style.css">
</head>
<body>
<div class="col-12 main-container">
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
            <th>Sender</th>
            <th>Recipient</th>
            <th style="min-width: 150px" >From
                <div class="float-right">
                    <a href="ParcelServlet.do?action=listParcelsCity1Asc">
                        <i class="fas fa-sort-alpha-down"></i>
                    </a>
                    <a href="ParcelServlet.do?action=listParcelsCity1Desc">
                        <i class="fas fa-sort-alpha-up-alt"></i>
                    </a>
                </div>
            </th>
            <th style="min-width: 150px">To
                <div class="float-right">
                    <a href="ParcelServlet.do?action=listParcelsCity2Asc">
                        <i class="fas fa-sort-alpha-down"></i>
                    </a>
                    <a href="ParcelServlet.do?action=listParcelsCity2Desc">
                        <i class="fas fa-sort-alpha-up-alt"></i>
                    </a>
                </div>
            </th>
            <th style="min-width: 150px">Weight
<%--                <i class="fas fa-weight-hanging"></i> --%>
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

            <th colspan="2" style="min-width: 360px">Action</th>
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
                <td style="padding-right: 0">
                    <button type="button" class="btn btn-info btn-md" onclick="openModalInfo('${parcel.id}')">
                        &nbsp<i class="fas fa-info-circle"></i>&nbsp;
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
                        <button type="button" class="btn btn-dark btn-md">
                            Update <i class="fas fa-edit"></i>
                        </button>
                    </a>
                    <a href="ParcelServlet.do?action=delete&parcelId=<c:out value="${parcel.id }"/>">
                        <button type="button" class="btn btn-danger btn-md">
                            Delete <i class="far fa-trash-alt"></i>
                        </button></a>
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
<%--&lt;%&ndash; Unfinished feature    &ndash;%&gt;--%>
<%--    <a href="ParcelServlet.do?action=filter">--%>
<%--        <button class="btn btn-danger btn-lg">--%>
<%--            Filter--%>
<%--        </button>--%>
<%--    </a>--%>
</div>
<footer class="footer py-2 bg-dark text-white-50">
    <div class="container">
        <!-- Grid row-->
        <div class="text-center py-2 container">
                <a  target="_blank"
                    rel="noopener noreferrer"
                    href="https://github.com/vladdovgal/transportation-system"
                style="margin-right:20px">
                    <i class="fab fa-github fa-3x"></i>
                </a>
            <a  target="_blank"
                rel="noopener noreferrer"
                href="https://www.linkedin.com/in/vladyslav-dovhal-517734164"
                style="margin-right:20px">
                <i class="fab fa-linkedin fa-3x"></i>
            </a>
                <a target="_blank"
                   rel="noopener noreferrer"
                   href="http://t.me/theonewhovlad">
                    <i class="fab fa-telegram fa-3x"></i>
                </a>
        </div>
    </div>
    <div class="footer-copyright text-center py-3">© 2020 Copyright: &nbsp; <b>@theonewhovlad</b></div>
</footer>

<script type="text/javascript" src="js/main.js"></script>
<%--<script>--%>
<%--    if (window.screen.width < 1520){--%>
<%--        let buttons = document.getElementsByClassName('dtn-md');--%>
<%--        for (let i = 0; i < buttons.length; i++){--%>
<%--            console.log(buttons[i].innerHTML);--%>

<%--            buttons[i].innerHTML = "";--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>