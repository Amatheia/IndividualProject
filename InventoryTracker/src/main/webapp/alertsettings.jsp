<%@include file="taglib.jsp"%>
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>

<div class="span6">
    <h2 style="padding-left:30px;">Alert Settings</h2>
    <br>
    <c:import url="navmenu.jsp" />
    <br>
</div>
<div align="center">
    <div class="container">
        <div style="width:600px;" align="left">
            <form role="form" class="form-horizontal" id="alertSettings" action="alertSettings" method="post">
                <div class="form-group row">
                    <label for="category" class="col-xs-4 control-label">Product Category:</label>
                    <div class="col-xs-8">
                        <select class="form-control" id="category" name="category">
                            <%-- need to pull options from database --%>
                            <option>Coffee</option>
                            <option>Tea</option>
                            <option>Fruit</option>
                            <option>Vegetables</option>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="setLowStockAlert" class="col-xs-4 control-label">Set Low Stock Alert:</label>
                    <div class="col-xs-8">
                        <input type="number" class="form-control" id="setLowStockAlert" name="setLowStockAlert">
                    </div>
                </div>
                <br>
                <div align="center">
                    <button type="submit" class="btn btn-primary">Update Alerts</button>
                </div>
            </form>
        </div>
    </div>
</div>
<br>
<br>
<c:import url="footer.jsp" />
