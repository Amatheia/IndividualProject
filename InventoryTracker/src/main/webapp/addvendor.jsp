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
                    <label for="vendorName" class="col-xs-4 control-label">Vendor Name:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="vendorName" name="vendorName">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="contactName" class="col-xs-4 control-label">Contact Name:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="contactName" name="contactName">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="address" class="col-xs-4 control-label">Address:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="address" name="address">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="city" class="col-xs-4 control-label">City:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="city" name="city">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="stateProvince" class="col-xs-4 control-label">State or Province:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="stateProvince" name="stateProvince">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="postalCode" class="col-xs-4 control-label">Postal Code:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="postalCode" name="postalCode">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="phone" class="col-xs-4 control-label">Phone:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="phone" name="phone">
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
            <td>Vendor Id</td>
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
            <td><%=v.getVendorId()%></td>
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
