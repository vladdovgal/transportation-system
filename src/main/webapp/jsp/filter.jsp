<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add/Edit New Parcel</title>
    <link rel="icon" href="imgs/delivery-track.png">
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
            <form action="ParcelServlet.do?filtered_parcels" method="get" class="col-12">
                <div class="form-group row">
<%--                    <label for="status" class="col-4 col-form-label">Status</label>--%>
                    <div class="col-8">
                        <select required name="status" id="status">
                            <option value="${status}" selected hidden>
                                ${status}
                            </option>
                            <c:forEach items="${statuss}" var="status">
                                <option value="${status}">${status}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="row">
                    <div class="col-2">
                        <button type="submit" onclick="window.location='action=filtered_parcels'"
                                class="btn btn-success btn-lg">
<%--                            <a href="ParcelServlet.do?action=filtered_parcels">--%>
                                Submit
<%--                            </a>--%>
                        </button>
                    </div>
                </div>
                <div class="col-2">
                    <button type="submit" class="btn btn-secondary btn-lg"
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
<script>
    function GetSelectedValue(){
        var e = document.getElementById("status1");
        var result = e.options[e.selectedIndex].value;

        document.getElementById("result").innerHTML = result;
        return result;
    }
</script>
</html>
