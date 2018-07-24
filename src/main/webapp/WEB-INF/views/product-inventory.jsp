<%--
  Created by IntelliJ IDEA.
  User: kienle
  Date: 7/24/18
  Time: 3:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="common/header.jsp"%>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">

            <h1>Product Inventory Page</h1>

            <p class="lead">This is the product inventory page!!!</p>

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
                    <td> <img src="#" alt="image"/></td>
                    <td> ${product.pName}</td>
                    <td> ${product.pCategory}</td>
                    <td> ${product.pCondition}</td>
                    <td> ${product.pPrice}</td>
                    <td><a href="<spring:url value="/productList/viewProduct/${product.pId}"/>"><span
                            class="glyphicon glyphicon-info-sign"/> </a></td>
                </tr>
            </c:forEach>

            </tbody>

        </table>

        <a href="<spring:url value="/admin/productInventory/addProduct"/> " class="btn btn-primary">Add Product</a>

    </div>
</div>
<%@include file="common/footer.jsp"%>
</html>
