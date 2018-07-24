<%--
  Created by IntelliJ IDEA.
  User: kienle
  Date: 7/24/18
  Time: 3:19 AM
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

            <h1>Add Product</h1>

            <p class="lead">Fill in information below to add product</p>

        </div>


        <form:form action="#" method="post" commandName="product">
            <div class="form-group">
                <label for="name">Name</label>
                <form:input path="pName" id="name" class="form-Control"/>
            </div>
        </form:form>

    </div>
</div>
<%@include file="common/footer.jsp" %>
</html>

