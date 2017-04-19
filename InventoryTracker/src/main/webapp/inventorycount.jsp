<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="com.producttracker.entity.Category"%>
<%@page import="com.producttracker.persistence.CategoryDao"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#categoryTable').DataTable();
    } );
</script>

<div class="span6">
    <h2 style="padding-left:30px;">Inventory Count</h2>
    <br>
    <c:import url="navmenu.jsp" />
    <br>
</div>
<br>
<div align="center">
    <div class="container">
        <div style="width:600px;" align="left">
            <form role="form" class="form-horizontal" id="InventoryCount" action="InventoryCount" method="post">
                <div class="form-group row">
                    <label for="category" class="col-xs-4 control-label">Display Products by Category:</label>
                    <div class="col-xs-8">
                        <select class="form-control" id="category" name="category">
                            <%
                                CategoryDao categorylist = new CategoryDao();
                                List<Category> list = categorylist.getAllCategories();
                                for (Category cat : list) {
                            %>
                            <option><%=cat.getCategoryName()%></option>

                            <%}%>
                        </select>
                    </div>
                </div>
                <br>
                <div align="center">
                  <div class="container">
                      <div class="row">
                          <div class="col-xs-2">
                              Product
                          </div>
                          <div class="col-xs-2">
                              Quantity
                          </div>
                      </div>
                  </div>
                </div>
                <br>
                <div align="center">
                    <button type="submit" class="btn btn-primary">Update Products</button>
                </div>
            </form>
        </div>
    </div>
</div>
<br>
<br>
<c:import url="footer.jsp" />

