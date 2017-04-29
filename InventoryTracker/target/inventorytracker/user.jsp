<%@include file="taglib.jsp"%>
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>

<div class="span6">
    <br>
    <c:import url="navmenu.jsp" />
    <br>
</div>
<div align="center">
    <h2>Add or Update User</h2>
    <br>
    <div class="container">
        <div style="width:600px;" align="left">
            <form role="form" class="form-horizontal" id="UserController" action="UserController" method="post">
                <div class="form-group row">
                    <label for="id" class="col-xs-4 control-label">User Id:</label>
                    <div class="col-xs-8">
                        <input type="text" id="id" readonly="readonly" name="userid"
                               value="<c:out value="${user.userid}" />" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="role" class="col-xs-4 control-label">Role or Title:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="role" name="role" value="<c:out value="${user.role}" />" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="firstName" class="col-xs-4 control-label">First Name:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="firstName" name="firstName" value="<c:out value="${user.firstName}" />" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="lastName" class="col-xs-4 control-label">Last Name:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="lastName" name="lastName" value="<c:out value="${user.lastName}" />" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="username" class="col-xs-4 control-label">Username:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="username" name="username" value="<c:out value="${user.username}" />" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="password" class="col-xs-4 control-label">Password:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="password" name="password" value="<c:out value="${user.password}" />" />
                    </div>
                </div>
                <br/>
                <div align="center">
                    <button type="submit" class="btn btn-primary" value="Submit">Submit</button>
                    <button type="reset" class="btn btn-default" value="reset">Reset</button>
                </div>
            </form>
        </div>
    </div>
</div>
<br>
<br>
<c:import url="footer.jsp" />

