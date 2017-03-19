<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="com.producttracker.entity.Vendor"%>
<%@page import="com.producttracker.persistence.VendorDao"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#vendorTable').DataTable();
    } );
</script>

<div class="span6">
    <h2 style="padding-left:30px;">Vendors</h2>
    <br>
    <c:import url="navmenu.jsp" />
    <br>
</div>
<div class="container-fluid">
    <h2>Vendors: </h2>
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
        <%
            VendorDao vendorlist = new VendorDao();
            List<Vendor> list = vendorlist.getAllVendors();
            for (Vendor v : list) {
        %>
        <tr>
            <td><%=v.getVendorId()%></td>
            <td><%=v.getVendorName()%></td>
            <td><%=v.getContactName()%></td>
            <td><%=v.getAddress()%></td>
            <td><%=v.getCity()%></td>
            <td><%=v.getStateProvince()%></td>
            <td><%=v.getPostalCode()%></td>
            <td><%=v.getPhone()%></td>
            <td><a href="VendorController?action=edit&vendorId=<%= v.getVendorId() %>">Update</a></td>
            <td><a href="VendorController?action=delete&vendorId=<%= v.getVendorId() %>">Delete</a></td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
<br>
<br>
<c:import url="footer.jsp" />