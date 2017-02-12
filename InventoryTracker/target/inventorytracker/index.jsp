<%@include file="taglib.jsp"%>
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>

  <div align="center">
    <div style="width:600px; margin:40px" align="left">
        <form class="form-horizontal" id="userLogin" action="login" method="post">
            <div class="form-group">
                <label for="username">User:</label>
                <input type="username" class="form-control" id="username" name="username" placeholder="Enter username">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            </div>
            <div align="center">
                <button type="submit" class="btn btn-default">Login</button>
            </div>
        </form>
    </div>
  </div>
  <div align="center">
   <p>Copyright Amatheia 2017. All rights reserved.</p><br/>
  </div>

<!-- javascript at the bottom for fast page loading -->
<script type="text/javascript" src="js/jquery.min.js"></script>

</body>
</html>


