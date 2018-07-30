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
                    <td> <img src="<c:url value="/resources/images/${product.pId}.png"/> " alt="image"
                              style="width: 100%"/></td>
                    <td> ${product.pName}</td>
                    <td> ${product.pCategory}</td>
                    <td> ${product.pCondition}</td>
                    <td> ${product.pPrice}</td>
                    <td><a href="<spring:url value="/product/viewProduct/${product.pId}"/>"><span
                            class="glyphicon glyphicon-info-sign"/> </a>
                        <a href="<spring:url value="/admin/product/deleteProduct/${product.pId}"/>"><span
                                class="glyphicon glyphicon-remove"/> </a>
                        <a href="<spring:url value="/admin/product/editProduct/${product.pId}"/>"><span
                                class="glyphicon glyphicon-pencil"/> </a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>

        </table>

        <a href="<spring:url value="/admin/product/addProduct"/> " class="btn btn-primary">Add Product</a>

    </div>
</div>
<%@include file="common/footer.jsp"%>
</html>

