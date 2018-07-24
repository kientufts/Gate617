<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kienle
  Date: 7/24/18
  Time: 3:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="common/header.jsp"%>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">

            <h1>Administrator Page</h1>

            <p class="lead">This is administration page!!!</p>

        </div>

        <h3>
            <a href="<c:url value="/admin/productInventory/"/> ">Product Inventory</a>
        </h3>

        <p>Here you can view, check and modify the product inventory!</p>

    </div>
</div>
<%@include file="common/footer.jsp"%>
</html>

