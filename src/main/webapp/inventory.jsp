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
        <td>Product Id</td>
        <td>Add Date</td>
        <td>Category</td>
        <td>Vendor</td>
        <td>Product Name</td>
        <td>Quantity Ordered</td>
        <td>Weight</td>
        <td>Per Unit Cost</td>
        <td>Total Cost</td>
        <td>Order Date</td>
        <td>Date Received</td>
        <td>Quantity Received</td>
        <td>Paid Not Received</td>
        <td>Current Quantity</td>
        <td>Current Value</td>
        <td>Expiration Date</td>
        <td>Notes</td>
        <td>Active</td>
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
        <td><%=p.getCategoryName()%></td>
        <td><%=p.getVendorName()%></td>
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
        <td><%=p.getExpirationDate()%></td>
        <td><%=p.getNotes()%></td>
        <td><%=p.getActive()%></td>
      </tr>
      <%}%>
      </tbody>
    </table>
  </div>
  <br>
  <c:import url="footer.jsp" />
