<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>

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
            <td>ID</td>
            <td>Role</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Username</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user[0].id}</td>
            <td>${user[0].role}</td>
            <td>${user[0].firstName}</td>
            <td>${user[0].lastName}</td>
            <td>${user[0].username}</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.role}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.username}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<br>
<c:import url="footer.jsp" />
