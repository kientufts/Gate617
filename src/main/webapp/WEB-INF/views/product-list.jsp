<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Users: kienle
  Date: 7/22/18
  Time: 2:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="common/header.jsp"%>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">

            <h1>All Products</h1>

            <p class="lead">Checkout all the awesome products available now!!!</p>

        </div>

        <table class="table table-striped table-hover">
            <thead>
                <tr class="bg-success">
                    <th>Photo Thumb</th>
                    <th>Product Name</th>
                    <th>Category</th>
                    <th>Condition</th>
                    <th>Price</th>
                    <th></th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td> <img src="<c:url value="/resources/images/${product.pId}.png"/> " alt="image"
                                  style="width: 100%"/></td>
                        <td> ${product.pName}</td>
                        <td> ${product.pCategory}</td>
                        <td> ${product.pCondition}</td>
                        <td> ${product.pPrice}</td>
                        <td><a href="<spring:url value="/product/viewProduct/${product.pId}"/>"><span
                                class="glyphicon glyphicon-info-sign"/> </a></td>
                    </tr>
                </c:forEach>

            </tbody>

        </table>

    </div>
</div>
<%@include file="common/footer.jsp"%>
</html>
