<%@include file="taglib.jsp"%>
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>

<div align="center">
    <div style="width:600px; margin:40px" align="left">
        <form class="form-horizontal" id="userRegister" action="UserRegister" method="post">
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
            <div align="center">
                <button type="submit" class="btn btn-default" value="register new user">Submit</button>
                <button type="reset" class="btn btn-default" value="reset">Reset</button>
            </div>
        </form>
    </div>
    <h4><a href="login.jsp">Return to Login</a></h4>
</div>
<br/>
<div align="center">
    <p>Copyright Amatheia 2017. All rights reserved.</p><br/>
</div>

<!-- javascript at the bottom for fast page loading -->
<script type="text/javascript" src="js/jquery.min.js"></script>

</body>
</html>
