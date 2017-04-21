<%@include file="taglib.jsp"%>
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>

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
            <form role="form" class="form-horizontal" id="VendorController" action="VendorController" method="post">
                <div class="form-group row">
                    <label for="id" class="col-xs-4 control-label">Vendor Id:</label>
                    <div class="col-xs-8">
                        <input type="text" id="id" readonly="readonly" name="vendorId" value="<c:out value="${vendor.vendorId}" />" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="vendorName" class="col-xs-4 control-label">Vendor Name:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="vendorName" name="vendorName" value="<c:out value="${vendor.vendorName}" />" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="contactName" class="col-xs-4 control-label">Contact Name:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="contactName" name="contactName" value="<c:out value="${vendor.contactName}" />" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="address" class="col-xs-4 control-label">Address:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="address" name="address" value="<c:out value="${vendor.address}" />" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="city" class="col-xs-4 control-label">City:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="city" name="city" value="<c:out value="${vendor.city}" />" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="stateProvince" class="col-xs-4 control-label">State or Province:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="stateProvince" name="stateProvince" value="<c:out value="${vendor.stateProvince}" />" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="postalCode" class="col-xs-4 control-label">Postal Code:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="postalCode" name="postalCode" value="<c:out value="${vendor.postalCode}" />" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="phone" class="col-xs-4 control-label">Phone:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="phone" name="phone" value="<c:out value="${vendor.phone}" />" />
                    </div>
                </div>
                <div align="center">
                    <button type="submit" class="btn btn-primary" value="submit">Submit</button>
                    <button type="reset" class="btn btn-default" value="reset">Reset</button>
                </div>
            </form>
        </div>
    </div>
</div>
<br>
<br>
<c:import url="footer.jsp" />
