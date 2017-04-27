<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>
<jsp:useBean id="categories" class="com.producttracker.persistence.CategoryDao"/>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#categoryTable').DataTable();
    } );
</script>

<div class="span6">
    <br>
    <c:import url="navmenu.jsp" />
    <br>
</div>
<div align="center">
    <h2>Categories</h2>
</div>
<br>
<div class="container-fluid">
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
        <c:forEach items="${categories.getAllCategories()}" var="category">
            <tr>
                <td><c:out value="${category.categoryId}" /></td>
                <td><c:out value="${category.categoryName}" /></td>
                <td><c:out value="${category.description}" /></td>
                <td><a href="CategoryController?action=edit&categoryId=<c:out value="${category.categoryId}"/>">Update</a></td>
                <td><a href="CategoryController?action=delete&categoryId=<c:out value="${category.categoryId}"/>">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<br>
<br>
<c:import url="footer.jsp" />