<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>
<jsp:useBean id="users" class="com.producttracker.persistence.UserDao"/>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>

<div class="span6">
    <h2 style="padding-left:30px;">Users</h2>
    <br>
    <c:import url="navmenu.jsp" />
    <br>
</div>
<div class="container-fluid">
    <h2>Search Results: </h2>
    <table id="userTable" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Role</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
            <th>Date Added</th>
            <th>Action</th>
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
                    <td><a href="UserController?action=edit&userid=<c:out value="${user.userid}"/>">Update</a></td>
                    <td><a href="UserController?action=delete&userid=<c:out value="${user.userid}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<br>
<br>
<c:import url="footer.jsp" />