<%@include file="taglib.jsp"%>
<c:set var="title" value="User Search Results" />
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>
<jsp:useBean id="users" class="com.producttracker.persistence.UserDao"/>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>

<c:import url="navmenu.jsp" />

<div align="center">
    <h2>Users</h2>
</div>
<br>
<div class="container-fluid">
    <table id="userTable" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Role</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
            <th>Date Added</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${users.getAllUsers()}" var="user">
                <tr>
                    <td><c:out value="${user.userid}" /></td>
                    <td><c:out value="${user.role}" /></td>
                    <td><c:out value="${user.firstName}" /></td>
                    <td><c:out value="${user.lastName}" /></td>
                    <td><c:out value="${user.username}" /></td>
                    <td><c:out value="${user.dateAdded}" /></td>
                    <td><a href="UserController?action=edit&userid=<c:out value="${user.userid}"/>"><span class='glyphicon glyphicon-pencil'></span></a></td>
                    <td><a href="UserController?action=delete&userid=<c:out value="${user.userid}"/>"><span class='glyphicon glyphicon-trash'></span></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<br>
<br>
<c:import url="footer.jsp" />