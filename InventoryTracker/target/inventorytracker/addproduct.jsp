<%@include file="taglib.jsp"%>
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>

  <div class="span6">
    <h2 style="padding-left:30px;">Add Product</h2>
    <br>
    <c:import url="navmenu.jsp" />
    <br>
  </div>
  <br>
  <div align="center">
  <div class="container">
    <div style="width:600px;" align="left">
    <form role="form" class="form-horizontal" id="addProduct" action="addProduct" method="post">
        <div class="form-group row">
            <label for="productId" class="col-xs-4 control-label">Product Id:</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" id="productId" name="productId">
            </div>
        </div>
        <div class="form-group row">
            <label for="category" class="col-xs-4 control-label">Product Category:</label>
            <div class="col-xs-8">
                <select class="form-control" id="category" name="category">
                    <%-- need to pull options from database --%>
                    <option>Coffee</option>
                    <option>Tea</option>
                    <option>Fruit</option>
                    <option>Vegetables</option>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="productName" class="col-xs-4 control-label">Product Name:</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" id="productName" name="productName">
            </div>
        </div>
        <div class="form-group row">
            <label for="vendor" class="col-xs-4 control-label">Vendor:</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" id="vendor" name="vendor">
            </div>
        </div>
        <div class="form-group row">
            <label for="quantityOrdered" class="col-xs-4 control-label">Quantity Ordered:</label>
            <div class="col-xs-8">
                <input type="number" class="form-control" id="quantityOrdered" name="quantityOrdered">
            </div>
        </div>
        <div class="form-group row">
            <label for="weight" class="col-xs-4 control-label">Weight:</label>
            <div class="col-xs-8">
                <input type="number" class="form-control" id="weight" name="weight">
            </div>
        </div>
        <div class="form-group row">
            <label for="perUnitCost" class="col-xs-4 control-label">Per Unit Cost:</label>
            <div class="col-xs-8">
                <input type="number" class="form-control" id="perUnitCost" name="perUnitCost">
            </div>
        </div>
        <div class="form-group row">
            <label for="totalCost" class="col-xs-4 control-label">Total Cost:</label>
            <div class="col-xs-8">
                <input type="hidden" id="totalCost" class="form-control">
                <input class="totalCost" name="totalCost" type="number" id="totalCost" disabled="disabled" style="" />
            </div>
        </div>
        <div class="form-group row">
            <label for="orderDate" class="col-xs-4 control-label">Order Date:</label>
            <div class="col-xs-8">
                <input type="date" class="form-control" id="orderDate" name="orderDate">
            </div>
        </div>
        <div class="form-group row">
            <label for="dateReceived" class="col-xs-4 control-label">Date Received:</label>
            <div class="col-xs-8">
                <input type="date" class="form-control" id="dateReceived" name="dateReceived">
            </div>
        </div>
        <div class="form-group row">
            <label for="notes" class="col-xs-4 control-label">Notes:</label>
            <div class="col-xs-8">
                <input type="text" class="form-control" id="notes" name="notes">
            </div>
        </div>
        <br>
        <div class="form-group row">
            <div class="col-sm-10">
                <div class="form-check" id="productOptions">
                    <label class="form-check-label">
                        <input class="form-check-input" type="checkbox" id="expirationDate" name="options"
                               value="Calculate Expiration Date"> Calculate Expiration Date <br/>
                        <input class="form-check-input" type="checkbox" id="lowStockAlert" name="options"
                               value="Low Stock Alert"> Low Stock Alert <br/>
                        <input class="form-check-input" type="checkbox" id="outStockAlert" name="options"
                               value="Out of Stock Alert"> Out of Stock Alert
                    </label>
                </div>
            </div>
        </div>
        <div align="center">
            <button type="submit" class="btn btn-primary">Add Product</button>
        </div>
    </form>
    </div>
  </div>
  </div>
  <br>
  <br>
<c:import url="footer.jsp" />