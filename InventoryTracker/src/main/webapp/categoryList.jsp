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
    <h2 style="padding-left:30px;">Users</h2>
    <br>
    <c:import url="navmenu.jsp" />
    <br>
</div>
<div class="container-fluid">
    <h2>Categories: </h2>
    <table id="categoryTable" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>Category Id</th>
            <th>Category Name</th>
            <th>Description</th>
            <th>Action</th>
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
            <td><a href="CategoryController?action=edit&categoryId=<%= c.getCategoryId() %>">Update</a></td>
            <td><a href="CategoryController?action=delete&categoryId=<%= c.getCategoryId() %>">Delete</a></td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
<br>
<br>
<c:import url="footer.jsp" />