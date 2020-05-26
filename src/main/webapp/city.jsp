<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add/Edit New City</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
</head>
<body>
<h1>Add/Edit City Page</h1>
<div class="container container-default">
    <div class="well">
        <form action="CityServlet.do" method="post">
            <div class="form-group row">
                <label for="cityId" class="col-2 col-form-label">City ID</label>
                <div class="col-10">
                    <input type="text"
                           class="form-control"
                           id="cityId"
                           name="cityId"
                           value="<c:out value="${city.id}" />"
                           readonly="readonly" placeholder="Read only field"/>
                </div>
            </div>
            <div class="form-group row">
                <label for="cityName" class="col-2 col-form-label">City Name</label>
                <div class="col-5">
                    <input class="form-control"
                           type="text"
                           name="cityName"
                           value="<c:out value="${city.cityName}"/>"
                           id="cityName"
                           placeholder="Fill name of city. For ex: Lviv">
                </div>
            </div>
            <div class="form-group row">
                <label for="cityAlias" class="col-2 col-form-label">City Alias</label>
                <div class="col-5">
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
                    <button type="button" class="btn btn-secondary"
                            onclick="window.location = 'CityServlet.do?action=listCities'">Cancel
                    </button>
                </div>
                <div class="col-2">
                    <button type="submit" class="btn btn-success">Submit</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
