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


        <form:form action="${pageContext.request.contextPath}/admin/product/addProduct" method="post"
                   commandName="product" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">Name</label>  <form:errors path="pName" cssStyle="color: red"/>
                <form:input path="pName" id="name" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="category">Category</label>
                <label class="checkbox-inline"><form:radiobutton path="pCategory" id="category" value="Jean"/>
                    Jean</label>
                <label class="checkbox-inline"><form:radiobutton path="pCategory" id="category" value="Pant"/>
                    Pant</label>
                <label class="checkbox-inline"><form:radiobutton path="pCategory" id="category" value="Jogger"/>
                    Jogger</label>
                <label class="checkbox-inline"><form:radiobutton path="pCategory" id="category" value="Denim"/>
                    Denim</label>
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <form:textarea path="pDescription" id="description" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="price">Price</label> <form:errors path="pPrice" cssStyle="color: red"/>
                <form:input path="pPrice" id="price" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="condition">Condition</label>
                <label class="checkbox-inline"><form:radiobutton path="pCondition" id="condition" value="New"/>
                    New</label>
                <label class="checkbox-inline"><form:radiobutton path="pCondition" id="condition" value="Used"/>
                    Used</label>
            </div>

            <div class="form-group">
                <label for="status">Status</label>
                <label class="checkbox-inline"><form:radiobutton path="pStatus" id="status" value="Active"/>
                    Active</label>
                <label class="checkbox-inline"><form:radiobutton path="pStatus" id="status" value="InActive"/>
                    InActive</label>
            </div>

            <div class="form-group">
                <label for="unitInStock">Unit In Stock</label> <form:errors path="pUnitInStock" cssStyle="color: red"/>
                <form:input path="pUnitInStock" id="unitInStock" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="manufacturer">Manufacturer</label>
                <form:input path="pManufacturer" id="manufacturer" class="form-Control"/>
            </div>

            <div class="form-group">
                <label class="control-label" for="pImage">Upload Image</label>
                <form:input path="pImage" id="pImage" type="file" class="form:input-large"/>
            </div>

            <br> <br>

            <input type="submit" value="submit" class="btn btn-default">
            <a href="<c:url value="/admin/productInventory"/> " class="btn btn-default">Cancel</a>
        </form:form>

    </div>
</div>
<%@include file="common/footer.jsp" %>
</html>

