<%@include file="taglib.jsp"%>
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>

<div class="span6">
    <h2 style="padding-left:30px;">Add User</h2>
    <br>
    <c:import url="navmenu.jsp" />
    <br>
</div>
<div align="center">
    <div class="container">
        <div style="width:600px;" align="left">
            <form role="form" class="form-horizontal" id="addUser" action="addUser" method="post">
                <div class="form-group row">
                    <label for="role" class="col-xs-4 control-label">Role or Title:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="role" name="role">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="firstName" class="col-xs-4 control-label">First Name:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="firstName" name="firstName">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="lastName" class="col-xs-4 control-label">Last Name:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="lastName" name="lastName">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="username" class="col-xs-4 control-label">Username:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="username" name="username">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="password" class="col-xs-4 control-label">Password:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="password" name="password">
                    </div>
                </div>
                <br/>
                <div align="center">
                    <form action="${pageContext.request.contextPath}/success" method="post">
                        <input type="submit" class="btn btn-primary" value="Add User" />
                    </form>
                </div>
            </form>
        </div>
    </div>
</div>
<br>
<br>
<c:import url="footer.jsp" />

