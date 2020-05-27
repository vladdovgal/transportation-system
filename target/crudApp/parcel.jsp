<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add/Edit New Parcel</title>


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="header container container-default">
    <h1>Add/Edit Parcel Page</h1>
</div>

<div class="container container-default">
    <div class="well row entity-form">
        <div class="col-1">

        </div>
        <div class="col-10">
            <form action="ParcelServlet.do" method="post" class="col-12">
                <div class="form-group row">
                    <label for="parcelId" class="col-4 col-form-label">Parcel ID</label>
                    <div class="col-8">
                        <input type="text"
                               class="form-control"
                               id="parcelId"
                               name="parcelId"
                               value="<c:out value="${parcel.id}" />"
                               readonly="readonly"
                               placeholder="Read only field"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="senderName" class="col-4 col-form-label">Sender Name</label>
                    <div class="col-8">
                        <input class="form-control"
                               type="text"
                               name="senderName"
                               value="<c:out value="${parcel.senderName}"/>"
                               id="senderName"
                               placeholder="Input">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="recipientName" class="col-4 col-form-label">Recipient Name</label>
                    <div class="col-8">
                        <input class="form-control"
                               type="text"
                               name="recipientName"
                               value="<c:out value="${parcel.recipientName}"/>"
                               id="recipientName"
                               placeholder="recipientName">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="startCity" class="col-4 col-form-label">City-Sender</label>
                    <div class="col-8">
                        <select name="startCity" id="startCity">
                            <option value="${parcel.startCity.toString()}" selected hidden>
                                ${parcel.startCity}
                            </option>
                            <c:forEach items="${cities}" var="city">
                                <option value="${city.toString()}">${city}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="endCity" class="col-4 col-form-label">City-Recipient</label>
                    <div class="col-8">
                        <select name="endCity" id="endCity">
                            <option value="${parcel.endCity.toString()}" selected hidden>
                                ${parcel.endCity}
                            </option>
                            <c:forEach items="${cities}" var="city">
                                <option value="${city.toString()}">${city}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="weight" class="col-4 col-form-label">Weight</label>
                    <div class="col-8">
                        <input class="form-control"
                               type="number"
                               step="0.01"
                               name="weight"
                               value="<c:out value="${parcel.weight}"/>"
                               id="weight"
                               placeholder="Weight">
                    </div>
                </div>
                <div class="row">
                    <div class="col-2">
                        <button type="submit" class="btn btn-success btn-lg">Submit</button>
                    </div>
                    <div class="col-2">
                        <button type="button" class="btn btn-secondary btn-lg"
                                onclick="window.location = 'ParcelServlet.do?action=list_parcels'">Cancel
                        </button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-1">

        </div>
    </div>
</div>
</body>
</html>
