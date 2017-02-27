<%@include file="taglib.jsp"%>
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@ page import="com.producttracker.persistence.VendorDao" %>
<%@ page import="com.producttracker.entity.Vendor" %>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#vendorTable').DataTable();
    } );
</script>

<div class="span6">
    <h2 style="padding-left:30px;">Add Vendor</h2>
    <br>
    <c:import url="navmenu.jsp" />
    <br>
</div>
<br>
<div align="center">
    <div class="container">
        <div style="width:600px;" align="left">
            <form role="form" class="form-horizontal" id="addVendor" action="addVendor" method="post">
                <div class="form-group row">
                    <label for="addVendor" class="col-xs-4 control-label">Add Vendor:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="addVendor" name="addVendor">
                    </div>
                </div>
                <div align="center">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>
<br>
<br>
<div class="container-fluid">
    <h2>Vendors: </h2>
    <table id="vendorTable" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <td>Vendor Name</td>
            <td>Contact Name</td>
            <td>Address</td>
            <td>City</td>
            <td>State or Province</td>
            <td>Postal Code</td>
            <td>Phone</td>
        </tr>
        </thead>
        <tbody>
        <%
            VendorDao vendorlist = new VendorDao();
            List<Vendor> list = vendorlist.getAllVendors();
            for (Vendor v : list) {
        %>
        <tr>
            <td><%=v.getVendorName()%></td>
            <td><%=v.getContactName()%></td>
            <td><%=v.getAddress()%></td>
            <td><%=v.getCity()%></td>
            <td><%=v.getStateProvince()%></td>
            <td><%=v.getPostalCode()%></td>
            <td><%=v.getPhone()%></td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
<br>
<br>
<c:import url="footer.jsp" />
