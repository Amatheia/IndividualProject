<%@include file="taglib.jsp"%>
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>
<script src="scripts/register.js" type="text/javascript"></script>

<div align="center">
    <div style="width:600px; margin:40px" align="left">
        <form class="form-horizontal" id="userRegister" action="register" method="post">
            <div class="form-group">
                <label for="firstname">First Name:</label>
                <input type="text" name="firstname" class="form-control" id="firstname" placeholder="Enter first name">
            </div>
            <div class="form-group">
                <label for="lastname">Last Name:</label>
                <input type="text" name="lastname" class="form-control" id="lastname" placeholder="Enter last name">
            </div>
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" name="username" class="form-control" id="username" placeholder="Enter username">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" name="password" class="form-control" id="password" placeholder="Password">
            </div>
            <div class="form-group">
                <label for="password">Confirm Password:</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword"
                       placeholder="Confirm Password">
            </div>
            <div align="center">
                <button type="submit" class="btn btn-default" value="register new user">Submit</button>
                <button type="reset" class="btn btn-default" value="reset" id="reset">Reset</button>
            </div>
        </form>
    </div>
    <h4><a href="/inventorytracker/">Return to Login</a></h4>
</div>
<br/>
<div align="center">
    <p>Copyright Amatheia 2017. All rights reserved.</p><br/>
</div>

</body>
</html>
