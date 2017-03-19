<%@include file="taglib.jsp"%>
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="com.producttracker.entity.Category"%>
<%@page import="com.producttracker.persistence.CategoryDao"%>
<%@page import="com.producttracker.entity.Vendor"%>
<%@page import="com.producttracker.persistence.VendorDao"%>

<div class="span6">
    <h2 style="padding-left:30px;">Add or Edit Product</h2>
    <br>
    <c:import url="navmenu.jsp" />
    <br>
  </div>
  <br>
  <div align="center">
  <div class="container">
    <div style="width:600px;" align="left">
    <form role="form" class="form-horizontal" id="ProductController" action="ProductController" method="post">
        <div class="form-group row">
            <label for="id" class="col-xs-4 control-label">Product Id:</label>
            <div class="col-xs-8">
                <input type="text" id="id" readonly="readonly" name="productId" value="<c:out value="${product.productId}" />" />
            </div>
        </div>
        <div class="form-group row">
            <label for="categoryName" class="col-xs-4 control-label">Category:</label>
            <div class="col-xs-8">
                <select class="form-control" id="categoryName" name="categoryName">
                    <%
                        CategoryDao categorylist = new CategoryDao();
                        List<Category> list = categorylist.getAllCategories();
                        for (Category cat : list) {
                    %>
                        <option><%=cat.getCategoryName()%></option>

                    <%}%>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="vendorName" class="col-xs-4 control-label">Vendor:</label>
            <div class="col-xs-8">
                <select class="form-control" id="vendorName" name="vendorName">
                    <%
                        VendorDao vendorlist = new VendorDao();
                        List<Vendor> index = vendorlist.getAllVendors();
                        for (Vendor vend : index) {
                    %>
                        <option><%=vend.getVendorName()%></option>

                    <%}%>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="productName" class="col-xs-4 control-label">Product Name:</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" id="productName" name="productName" value="<c:out value="${product.productName}" />" />
            </div>
        </div>
        <div class="form-group row">
            <label for="quantityOrdered" class="col-xs-4 control-label">Quantity Ordered:</label>
            <div class="col-xs-8">
                <input type="number" class="form-control" id="quantityOrdered" name="quantityOrdered" value="<c:out value="${product.quantityOrdered}" />" />
            </div>
        </div>
        <div class="form-group row">
            <label for="weight" class="col-xs-4 control-label">Weight:</label>
            <div class="col-xs-8">
                <input type="number" class="form-control" id="weight" name="weight" value="<c:out value="${product.weight}" />" />
            </div>
        </div>
        <div class="form-group row">
            <label for="perUnitCost" class="col-xs-4 control-label">Per Unit Cost:</label>
            <div class="col-xs-8">
                <input type="number" class="form-control" id="perUnitCost" name="perUnitCost" value="<c:out value="${product.perUnitCost}" />" />
            </div>
        </div>
        <div class="form-group row">
            <label for="totalCost" class="col-xs-4 control-label">Total Cost:</label>
            <div class="col-xs-8">
                <input type="hidden" id="totalCost" class="form-control">
                <input class="totalCost" name="totalCost" type="number" id="totalCost" disabled="disabled" style="" />
            </div>
        </div>
        <div class="form-group row">
            <label for="orderDate" class="col-xs-4 control-label">Order Date:</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" id="orderDate" name="orderDate" value="<c:out value="${product.orderDate}" />" />
            </div>
        </div>
        <div class="form-group row">
            <label for="dateReceived" class="col-xs-4 control-label">Date Received:</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" id="dateReceived" name="dateReceived" value="<c:out value="${product.dateReceived}" />" />
            </div>
        </div>
        <div class="form-group row">
            <label for="notes" class="col-xs-4 control-label">Notes:</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" id="notes" name="notes" value="<c:out value="${product.notes}" />" />
            </div>
        </div>
        <br>
        <div align="center">
            <button type="submit" class="btn btn-primary">Submit</button>
            <input type="Reset" name="cmdReset" value="RESET">
        </div>
    </form>
    </div>
  </div>
  </div>
  <br>
  <br>
<c:import url="footer.jsp" />