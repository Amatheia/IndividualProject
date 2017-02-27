<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="com.producttracker.entity.User"%>
<%@page import="com.producttracker.persistence.UserDao"%>

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
            <td>Date Added</td>
        </tr>
        </thead>
        <tbody>
        <%
            UserDao userlist = new UserDao();
            List<User> list = userlist.getAllUsers();
            for (User u : list) {
        %>
        <tr>
            <td><%=u.getUserid()%></td>
            <td><%=u.getRole()%></td>
            <td><%=u.getFirstName()%></td>
            <td><%=u.getLastName()%></td>
            <td><%=u.getUsername()%></td>
            <td><%=u.getDateAdded()%></td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
<br>
<c:import url="footer.jsp" />