<%--
  Created by IntelliJ IDEA.
  User: kienle
  Date: 7/22/18
  Time: 11:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="common/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">

            <h1>Product Details</h1>

            <p class="lead">More information of the products</p>

        </div>

        <div class="container">

            <div class="row">

                <div class="col-md-5">

                    <img src="#" alt="image" style="width: 100%; height: 300px"/>
                </div>
                <div class="col-md-5">

                    <h3>Product Name</h3>
                    <p>Product Description</p>
                    <p>Manufacturer</p>
                    <p>Category</p>
                    <p>Price</p>
                </div>
            </div>

        </div>

    </div>
</div>
<%@include file="common/footer.jsp" %>
</html>