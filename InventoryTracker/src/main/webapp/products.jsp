<%@include file="taglib.jsp"%>
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>
<jsp:useBean id="categories" class="com.producttracker.persistence.CategoryDao"/>
<jsp:useBean id="vendors" class="com.producttracker.persistence.VendorDao"/>

<div class="span6">
    <br>
    <c:import url="navmenu.jsp" />
    <br>
</div>
<div align="center">
  <h2>Add or Update Product</h2>
  <br>
  <div class="container">
    <div style="width:600px;" align="left">
    <form role="form" class="form-horizontal" id="ProductController" action="ProductController" method="post">
        <div class="form-group row">
            <label for="id" class="col-xs-4 control-label">Product Id:</label>
            <div class="col-xs-8">
                <input type="text" id="id" readonly="readonly" name="productId" value="<c:out value="${product.productId}" />" />
            </div>
        </div>
        <div class="form-group row">
            <label for="category1" class="col-xs-4 control-label">Category:</label>
            <div class="col-xs-8">
                  <select class="form-control" id="category1" name="category1">
                      <c:forEach items="${categories.getAllCategories()}" var="category">
                          <option value='<c:out value="${category.categoryId}"/>'><c:out value="${category.categoryName}"/></option>
                      </c:forEach>
                  </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="vendor1" class="col-xs-4 control-label">Vendor:</label>
            <div class="col-xs-8">
                <select class="form-control" id="vendor1" name="vendor1">
                    <c:forEach items="${vendors.getAllVendors()}" var="vendor">
                        <option value='<c:out value="${vendor.vendorId}"/>'><c:out value="${vendor.vendorName}"/></option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="productName" class="col-xs-4 control-label">Product Name:</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" id="productName" name="productName" value="<c:out value="${product.productName}" />" />
            </div>
        </div>
        <div class="form-group row">
            <label for="quantityOrdered" class="col-xs-4 control-label">Quantity Ordered:</label>
            <div class="col-xs-8">
                <input type="number" class="form-control" id="quantityOrdered" name="quantityOrdered" value="<c:out value="${product.quantityOrdered}" />" />
            </div>
        </div>
        <div class="form-group row">
            <label for="weight" class="col-xs-4 control-label">Weight in lbs:</label>
            <div class="col-xs-8">
                <input type="number" step="0.0001" class="form-control" id="weight" name="weight" value="<c:out value="${product.weight}" />" />
            </div>
        </div>
        <div class="form-group row">
            <label for="perUnitCost" class="col-xs-4 control-label">Per Unit Cost:</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" id="perUnitCost" name="perUnitCost" placeholder="$0.00" value="<c:out value="${product.perUnitCost}" />" />
            </div>
        </div>
        <div class="form-group row">
            <label for="totalCost" class="col-xs-4 control-label">Total Cost:</label>
            <div class="col-xs-8">
                <input type="hidden" id="totalCost" class="form-control">
                <input class="totalCost" name="totalCost" type="text" id="totalCost" disabled="disabled" style="" />
            </div>
        </div>
        <div class="form-group row">
            <label for="orderDate" class="col-xs-4 control-label">Order Date:</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" id="orderDate" name="orderDate" placeholder="YYYY-MM-DD" value="<c:out value="${product.orderDate}" />" />
            </div>
        </div>
        <div class="form-group row">
            <label for="dateReceived" class="col-xs-4 control-label">Date Received:</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" id="dateReceived" name="dateReceived" placeholder="YYYY-MM-DD" value="<c:out value="${product.dateReceived}" />" />
            </div>
        </div>
        <div class="form-group row">
            <label for="quantityReceived" class="col-xs-4 control-label">Quantity Received:</label>
            <div class="col-xs-8">
                <input type="number" class="form-control" id="quantityReceived" name="quantityReceived" value="<c:out value="${product.quantityReceived}" />" />
            </div>
        </div>
        <div class="form-group row">
            <label for="paidNotReceived" class="col-xs-4 control-label">Paid For But Did Not Receive:</label>
            <div class="col-xs-8">
                <input type="number" class="form-control" id="paidNotReceived" name="paidNotReceived" value="<c:out value="${product.paidNotReceived}" />" />
            </div>
        </div>
        <div class="form-group row">
            <label for="currentQuantity" class="col-xs-4 control-label">Current Quantity:</label>
            <div class="col-xs-8">
                <input type="number" class="form-control" id="currentQuantity" name="currentQuantity" value="<c:out value="${product.currentQuantity}" />" />
            </div>
        </div>
        <div class="form-group row">
            <label for="currentValue" class="col-xs-4 control-label">Current Value:</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" id="currentValue" name="currentValue" placeholder="$0.00" value="<c:out value="${product.currentValue}" />" />
            </div>
        </div>
        <div class="form-group row">
            <label for="expiration" class="col-xs-4 control-label">Expiration:</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" id="expiration" name="expiration" value="<c:out value="${product.expiration}" />" />
                <p>Click button to get expiration duration</p><a class="btn btn-primary" href="http://52.14.138.145:8080/foodexpirationservice/" role="button" target="_blank">Get Expiration</a>
            </div>
        </div>
        <div class="form-group row">
            <label for="notes" class="col-xs-4 control-label">Notes:</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" id="notes" name="notes" value="<c:out value="${product.notes}" />" />
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-10">
                <div class="form-check" id="userOptions">
                     <label class="form-check-label">
                        <input class="form-check-input" type="checkbox" id="active" name="active"
                               value="Active"> Active <br/>
                     </label>
                </div>
            </div>
        </div>
        <br>
        <div align="center">
            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="reset" class="btn btn-default" value="reset">Reset</button>
        </div>
    </form>
    </div>
  </div>
  </div>
  <br>
  <br>
<c:import url="footer.jsp" />