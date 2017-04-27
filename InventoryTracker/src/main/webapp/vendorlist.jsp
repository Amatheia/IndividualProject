<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>
<jsp:useBean id="vendors" class="com.producttracker.persistence.VendorDao"/>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#vendorTable').DataTable();
    } );
</script>

<div class="span6">
    <br>
    <c:import url="navmenu.jsp" />
    <br>
</div>
<div align="center">
    <h2>Vendors</h2>
</div>
<br>
<div class="container-fluid">
    <table id="vendorTable" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>Vendor Id</th>
            <th>Vendor Name</th>
            <th>Contact Name</th>
            <th>Address</th>
            <th>City</th>
            <th>State or Province</th>
            <th>Postal Code</th>
            <th>Phone</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${vendors.getAllVendors()}" var="vendor">
            <tr>
                <td><c:out value="${vendor.vendorId}" /></td>
                <td><c:out value="${vendor.vendorName}" /></td>
                <td><c:out value="${vendor.contactName}" /></td>
                <td><c:out value="${vendor.address}" /></td>
                <td><c:out value="${vendor.city}" /></td>
                <td><c:out value="${vendor.stateProvince}" /></td>
                <td><c:out value="${vendor.postalCode}" /></td>
                <td><c:out value="${vendor.phone}" /></td>
                <td><a href="VendorController?action=edit&vendorId=<c:out value="${vendor.vendorId}"/>">Update</a></td>
                <td><a href="VendorController?action=delete&vendorId=<c:out value="${vendor.vendorId}"/>">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<br>
<br>
<c:import url="footer.jsp" />