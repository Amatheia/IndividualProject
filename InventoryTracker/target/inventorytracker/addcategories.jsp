<%@include file="taglib.jsp"%>
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>

<div class="span6">
    <h2 style="padding-left:30px;">Add Categories</h2>
    <br>
    <c:import url="navmenu.jsp" />
    <br>
</div>
<br>
<div align="center">
    <div class="container">
        <div style="width:600px;" align="left">
            <form role="form" class="form-horizontal" id="addCategories" action="addCategories" method="post">
                <div class="form-group row">
                    <label for="addCategory" class="col-xs-4 control-label">Add Category:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="addCategory" name="addCategory">
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
<p>Output List of Categories</p>
<br>
<c:import url="footer.jsp" />
