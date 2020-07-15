<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add/Edit City</title>
    <link rel="icon" href="imgs/delivery-track.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="header container container-default">
    <h1>Add/Edit City Page</h1>
</div>

<div class="container container-default">
    <div class="well row entity-form" style="padding-bottom: 40px;
    margin-top: 20px;
    padding-top: 40px;
    box-shadow: 1px 0 19px 0px #2e6da4;
    font-size: 1.2em;
    box-sizing: content-box">
        <div class="col-1">

        </div>
        <div class="col-10">
            <form action="CityServlet.do" method="post" class="col-12">
                <div class="form-group row">
                    <label for="cityId" class="col-4 col-form-label">City ID</label>
                    <div class="col-8">
                        <input type="text"
                               class="form-control"
                               id="cityId"
                               name="cityId"
                               value="<c:out value="${city.id}" />"
                               readonly="readonly"
                               placeholder="Read only field"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="cityName" class="col-4 col-form-label">Name of the City</label>
                    <div class="col-8">
                        <input class="form-control"
                               required
                               type="text"
                               name="cityName"
                               value="<c:out value="${city.cityName}"/>"
                               id="cityName"
                               placeholder="Enter the name">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="cityAlias" class="col-4 col-form-label">Alias</label>
                    <div class="col-8">
                        <input class="form-control"
                               type="text"
                               name="cityAlias"
                               value="<c:out value="${city.cityAlias}"/>"
                               id="cityAlias"
                               placeholder="Leave empty for auto-generating alias">
                    </div>
                </div>

                <div class="row">
                    <div class="col-2">
                        <button type="submit" class="btn btn-success btn-lg">Submit</button>
                    </div>
                    <div class="col-2">
                        <button type="button" class="btn btn-secondary btn-lg"
                                onclick="window.location = 'CityServlet.do?action=list_cities'">Cancel
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
