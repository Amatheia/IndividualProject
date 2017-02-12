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
                <div class="form-group row">
                    <label for="confirmPassword" class="col-xs-4 control-label">Confirm Password:</label>
                    <div class="col-xs-8">
                        <input type="text" class="form-control" id="confirmPassword" name="confirmPassword">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-10">
                        <div class="form-check" id="userOptions">
                            <label class="form-check-label">
                                <input class="form-check-input" type="checkbox" id="viewInventory" name="users"
                                       value="View Inventory"> View Inventory <br/>
                                <input class="form-check-input" type="checkbox" id="addProduct" name="users"
                                       value="Add Product"> Add Product <br/>
                                <input class="form-check-input" type="checkbox" id="updateProduct" name="users"
                                       value="Update Product"> Update Product <br/>
                                <input class="form-check-input" type="checkbox" id="deleteProduct" name="users"
                                       value="Delete Product"> Delete Product <br/>
                                <input class="form-check-input" type="checkbox" id="addNewUser" name="users"
                                       value="Add New User"> Add New User
                            </label>
                        </div>
                    </div>
                </div>
                <div align="center">
                    <button type="submit" class="btn btn-primary">Add User</button>
                </div>
            </form>
        </div>
    </div>
</div>
<br>
<br>
<c:import url="footer.jsp" />

