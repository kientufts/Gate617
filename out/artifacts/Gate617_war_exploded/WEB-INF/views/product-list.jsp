<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kienle
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
                    </tr>
                </c:forEach>

            </tbody>

        </table>

    </div>
</div>
<%@include file="common/footer.jsp"%>
</html>
