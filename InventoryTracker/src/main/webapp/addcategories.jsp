<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="com.producttracker.entity.Category"%>
<%@page import="com.producttracker.persistence.CategoryDao"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#categoryTable').DataTable();
    } );
</script>

<div class="span6">
    <h2 style="padding-left:30px;">Add Category</h2>
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
                    <label for="categoryName" class="col-xs-4 control-label">Category Name:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="categoryName" name="categoryName">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="description" class="col-xs-4 control-label">Description:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="description" name="description">
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
    <h2>Categories: </h2>
    <table id="categoryTable" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <td>Category Id</td>
            <td>Category Name</td>
            <td>Description</td>
        </tr>
        </thead>
        <tbody>
        <%
            CategoryDao categorylist = new CategoryDao();
            List<Category> list = categorylist.getAllCategories();
            for (Category c : list) {
        %>
        <tr>
            <td><%=c.getCategoryId()%></td>
            <td><%=c.getCategoryName()%></td>
            <td><%=c.getDescription()%></td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
<br>
<br>
<c:import url="footer.jsp" />
