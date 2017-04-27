<%@include file="taglib.jsp"%>
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>

<div class="span6">
    <br>
    <c:import url="navmenu.jsp" />
    <br>
</div>
<div align="center">
    <h2>Add or Update Category</h2>
    <br>
    <div class="container">
        <div style="width:600px;" align="left">
            <form role="form" class="form-horizontal" id="CategoryController" action="CategoryController" method="post">
                <div class="form-group row">
                    <label for="id" class="col-xs-4 control-label">Category Id:</label>
                    <div class="col-xs-8">
                        <input type="text" id="id" readonly="readonly" name="categoryId" value="<c:out value="${category.categoryId}" />" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="categoryName" class="col-xs-4 control-label">Category Name:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="categoryName" name="categoryName" value="<c:out value="${category.categoryName}" />" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="description" class="col-xs-4 control-label">Description:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="description" name="description" value="<c:out value="${category.description}" />" />
                    </div>
                </div>
                <div align="center">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <button type="reset" class="btn btn-default" value="reset">Reset</button>
                </div>
            </form>
        </div>
    </div>
</div>
<br>
<br>
<c:import url="footer.jsp" />
