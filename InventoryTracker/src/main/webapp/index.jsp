<%@include file="taglib.jsp"%>
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>
<jsp:useBean id="tasks" class="com.producttracker.persistence.TaskDao"/>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#tasksTable').DataTable();
    } );
</script>

<c:import url="navmenu.jsp" />

<div align="center">
    <h2>Manage Tasks and Messages</h2>
</div>
<div class="container">
    <br>
    <form role="form" class="form-horizontal" id="TaskController" action="TaskController" method="post">
        <div class="form-group">
            <label for="taskDescription" class="col-lg-2 control-label">Enter Task or Message</label>
            <div class="col-lg-8">
                <input type="text" class="form-control" id="taskDescription" name="taskDescription" />
                <span class="help-block">Enter inventory related tasks and messages.</span>
            </div>
        </div>
        <button type="submit" class="btn btn-primary" id="addTask" name="addTask">Submit</button>
        <button type="reset" class="btn btn-default">Cancel</button>
    </form>
    <br>
    <br>
    <h3>List of Tasks and Messages:</h3>
</div>
<br>
<div class="container-fluid">
    <table id="tasksTable" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Task or Message</th>
            <th>Date Added</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tasks.getAllTasks()}" var="task">
            <tr>
                <td><c:out value="${task.taskId}" /></td>
                <td><c:out value="${task.taskDescription}" /></td>
                <td><c:out value="${task.taskDateAdded}" /></td>
                <td><a href="TaskController?action=delete&taskId=<c:out value="${task.taskId}"/>"><span class='glyphicon glyphicon-trash'></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<c:import url="footer.jsp" />