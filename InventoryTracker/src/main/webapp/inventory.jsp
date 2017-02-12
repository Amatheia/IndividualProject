<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>

<div class="span6">
  <h2 style="padding-left:30px;">Inventory</h2>
  <br>
  <c:import url="navmenu.jsp" />
  <br>
  <p>Search Products</p>
  <p>Sort Products</p>
  <br>
  <div class="container-fluid">
    <table id="productTable" class="display" cellspacing="0" width="100%">
      <thead>
      <tr>
        <td>ID</td>
        <td>Category</td>
        <td>Product Name</td>
        <td>Vendor</td>
        <td>Quantity Ordered</td>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>${product[0].id}</td>
        <td>${product[0].category}</td>
        <td>${product[0].productName}</td>
        <td>${product[0].vendor}</td>
        <td>${product[0].quantityOrdered}</td>
      </tr>
      <c:forEach items="${products}" var="product">
        <tr>
          <td>${product.id}</td>
          <td>${product.category}</td>
          <td>${product.productName}</td>
          <td>${product.vendor}</td>
          <td>${product.quantityOrdered}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
  <br>
  <c:import url="footer.jsp" />
