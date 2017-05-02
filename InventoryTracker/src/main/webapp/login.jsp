<%@include file="taglib.jsp"%>
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>

  <div align="center">
    <div style="width:600px; margin:40px" align="left">
        <form class="form-horizontal" id="userLogin" action="j_security_check" method="post">
            <div class="form-group">
                <label for="username">User:</label>
                <input type="text" name="j_username" class="form-control" id="username" placeholder="Enter username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" name="j_password" class="form-control" id="password" placeholder="Password" required>
            </div>
            <div align="center">
                <button type="submit" class="btn btn-default" value="login">Login</button>
            </div>
        </form>
    </div>
      <h4><a href="register.jsp">Create an account</a></h4>
  </div>
  <br/>
  <div align="center">
   <p>Copyright Amatheia 2017. All rights reserved.</p><br/>
  </div>


</body>
</html>


