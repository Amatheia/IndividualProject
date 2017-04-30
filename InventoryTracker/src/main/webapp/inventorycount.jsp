<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>
<jsp:useBean id="products" class="com.producttracker.persistence.ProductDao"/>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#inventoryTable').DataTable();
    } );
</script>

<c:import url="navmenu.jsp" />

<div align="center">
  <h2>Inventory Count</h2>
</div>
<br>
<div class="container-fluid">
    <table id="inventoryTable" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>Category</th>
            <th>Product</th>
            <th>Current Quantity</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products.getAllProducts()}" var="product">
        <tr>
        <td><c:out value="${product.category.categoryName}" /></td>
        <td><c:out value="${product.productName}" /></td>
        <td><c:out value="${product.currentValue}" /></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<br>
<br>
<c:import url="footer.jsp" />

