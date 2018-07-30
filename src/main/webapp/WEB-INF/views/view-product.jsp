<%--
  Created by IntelliJ IDEA.
  User: kienle
  Date: 7/22/18
  Time: 11:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="common/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">

            <h1>Product Details</h1>

            <p class="lead">More information of the products</p>

        </div>

        <div class="container" ng-app="cartApp">

            <div class="row">

                <div class="col-md-5">

                    <img src="<c:url value="/resources/images/${product.pId}.png"/> " alt="image"
                              style="width: 100%"/>
                </div>
                <div class="col-md-5">

                    <h3>${product.pName}</h3>
                    <p>${product.pDescription}</p>
                    <p>
                        <strong>Manufacturer</strong> : ${product.pManufacturer}
                    </p>
                    <p>
                        <strong>Category</strong> : ${product.pCategory}
                    </p>
                    <p>
                        <strong>Condition</strong> : ${product.pCondition}
                    </p>
                    <h4>${product.pPrice} USD</h4>

                    <br>

                    <c:set var="role" scope="page" value="${param.role}"/>
                    <c:set var="url" scope="page" value="/productList"/>
                    <c:if test="${role='admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory"/>
                    </c:if>

                    <p ng-controller="cartCtrl">
                        <a href="<c:url value="${url}"/> " class="btn btn-default">Back</a>
                        <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.pId}')"><span
                            class="glyphicon glyphicon-shopping-cart"/>Order Now</a>
                        <a href="<spring:url value="/cart"/>" class="btn btn-default"><span
                                class="glyphicon glyphicon-hand-right"/>View Cart </a>
                    </p>
                </div>
            </div>

        </div>

    </div>
</div>
<script src="<c:url value="/resources/js/controller.js"/>"></script>
<%@include file="common/footer.jsp" %>
</html>
