<%@include file="taglib.jsp"%>
<c:set var="title" value="Product Search Results" />
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>
<jsp:useBean id="products" class="com.producttracker.persistence.ProductDao"/>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#productTable').DataTable();
    } );
</script>

<c:import url="navmenu.jsp" />

<div align="center">
  <h2>Inventory</h2>
</div>
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
        <th>Weight in lbs</th>
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
        <th>Active</th>
        <th>Update</th>
        <th>Delete</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${products.getAllProducts()}" var="product">
      <tr>
        <td><c:out value="${product.productId}" /></td>
        <td><c:out value="${product.addDate}" /></td>
        <td><c:out value="${product.category.categoryName}" /></td>
        <td><c:out value="${product.vendor.vendorName}" /></td>
        <td><c:out value="${product.productName}" /></td>
        <td><c:out value="${product.quantityOrdered}" /></td>
        <td><c:out value="${product.weight}" /></td>
        <td><c:out value="${product.perUnitCost}" /></td>
        <td><c:out value="${product.totalCost}" /></td>
        <td><c:out value="${product.orderDate}" /></td>
        <td><c:out value="${product.dateReceived}" /></td>
        <td><c:out value="${product.quantityReceived}" /></td>
        <td><c:out value="${product.paidNotReceived}" /></td>
        <td><c:out value="${product.currentQuantity}" /></td>
        <td><c:out value="${product.currentValue}" /></td>
        <td><c:out value="${product.expiration}" /></td>
        <td><c:out value="${product.notes}" /></td>
        <td><c:out value="${product.active}" /></td>
        <td><a href="ProductController?action=edit&productId=<c:out value="${product.productId}"/>"><span class='glyphicon glyphicon-pencil'></span></a></td>
        <td><a href="ProductController?action=delete&productId=<c:out value="${product.productId}"/>"><span class='glyphicon glyphicon-trash'></span></a></td>
      </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
<br>
<br>
<c:import url="footer.jsp" />
