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
<p>Output List of Vendors</p>
<br>
<c:import url="footer.jsp" />
