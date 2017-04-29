<%@include file="taglib.jsp"%>
<c:set var="title" value="Expiration Service" />
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>
<!-- Category script file -->
<script src="scripts/categoryService.js" type="text/javascript"></script>
<!-- Item script file -->
<script src="scripts/itemService.js" type="text/javascript"></script>
<div class="span6">
    <br>
    <c:import url="navmenu.jsp" />
    <br>
</div>
<div align="center">
    <img src="<c:url value="/images/foodexpirationlogo.png"/>" />
</div>
<div class="container">
    <form action="http://52.14.138.145:8080/foodexpirationservice/expiration/expirationDate" method="post">
        <div align="center">
            <label>Category:</label>
            <select id="categoryList" name="categoryList" onchange="populateItem(this)">
                <option value="" selected>select your category</option>
            </select>
        </div>
        <br/>
        <br/>
        <div align="center">
            <label>Food Item:</label>
            <select id="itemList" name="itemList">
            </select>
        </div>
        <br/>
        <br/>
        <div align="center">
            <input type="submit" value="Get Expiration" />
        </div>
    </form>
</div>
<br>
<br>
<c:import url="footer.jsp" />