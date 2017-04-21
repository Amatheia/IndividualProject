<%@include file="taglib.jsp"%>
<c:set var="title" value="Product Search Results" />
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="com.producttracker.entity.Product"%>
<%@page import="com.producttracker.persistence.ProductDao"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#productTable').DataTable();
    } );
</script>

<div class="span6">
  <h2 style="padding-left:30px;">Inventory</h2>
  <br>
  <c:import url="navmenu.jsp" />
  <br>
  <br>
  <div class="container-fluid">
    <table id="productTable" class="display" cellspacing="0" width="100%">
      <thead>
      <tr>
        <th>Product Id</th>
        <th>Add Date</th>
        <th>Category</th>
        <th>Vendor</th>
        <th>Product Name</th>
        <th>Quantity Ordered</th>
        <th>Weight</th>
        <th>Per Unit Cost</th>
        <th>Total Cost</th>
        <th>Order Date</th>
        <th>Date Received</th>
        <th>Quantity Received</th>
        <th>Paid Not Received</th>
        <th>Current Quantity</th>
        <th>Current Value</th>
        <th>Expiration Date</th>
        <th>Notes</th>
        <th>Action</th>
      </tr>
      </thead>
      <tbody>
      <%
        ProductDao productlist = new ProductDao();
        List<Product> list = productlist.getAllProducts();
        for (Product p : list) {
      %>
      <tr>
        <td><%=p.getProductId()%></td>
        <td><%=p.getAddDate()%></td>
        <td><%=p.getCategoryId()%></td>
        <td><%=p.getVendorId()%></td>
        <td><%=p.getProductName()%></td>
        <td><%=p.getQuantityOrdered()%></td>
        <td><%=p.getWeight()%></td>
        <td><%=p.getPerUnitCost()%></td>
        <td><%=p.getTotalCost()%></td>
        <td><%=p.getOrderDate()%></td>
        <td><%=p.getDateReceived()%></td>
        <td><%=p.getQuantityReceived()%></td>
        <td><%=p.getPaidNotReceived()%></td>
        <td><%=p.getCurrentQuantity()%></td>
        <td><%=p.getCurrentValue()%></td>
        <td><%=p.getExpiration()%></td>
        <td><%=p.getNotes()%></td>
        <td><a href="ProductController?action=edit&productId=<%= p.getProductId() %>">Update</a></td>
        <td><a href="ProductController?action=delete&productId=<%= p.getProductId() %>">Delete</a></td>
      </tr>
      <%}%>
      </tbody>
    </table>
  </div>
  <br>
  <c:import url="footer.jsp" />
