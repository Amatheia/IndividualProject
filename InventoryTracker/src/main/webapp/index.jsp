<%@include file="taglib.jsp"%>
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>


<c:import url="navmenu.jsp" />

<div align="center">
      <h2>User Home Page ***UNDER CONSTRUCTION***</h2>
</div>

    <div ng-app = "" ng-init = """>
      <p>Enter your Name: <input type = "text" ng-model = "name"></p>
      <p>Hello <span ng-bind = "name"></span>!</p>

    </div>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.js"></script>
<script type="text/javascript" src="webjars/angularjs/1.3.8/angular.min.js"></script>
<script type="text/javascript" src="webjars/angularjs/1.3.8/angular-resource.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap-material-design/0.2.1/js/material.js"></script>

  </div>

<c:import url="footer.jsp" />