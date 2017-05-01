<%@include file="taglib.jsp"%>
<%@include file="headTag.jsp"%>
<%@include file="header.jsp"%>
<script src="scripts/getCategories.js" type="text/javascript"></script>
<script src="scripts/getProducts.js" type="text/javascript"></script>
<script>
    $(document).ready(function () {
        populateQuantity();
    });

    function populateQuantity() {

        var selectedText = $("#productList").val();
        console.log(selectedText);
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/inventorytracker/json/products",
            data: '{ productId :" ' + selectedText + '"}',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            success: function (data) {
                $("#currentQuantity").empty();
                $(data).each(function () {
                    if (selectedText == this.productId) {
                        $('#currentQuantity').val(this.currentQuantity);
                    }
                });
            }
        })
        return false

    }
</script>

<div class="span6">
    <br>
    <c:import url="navmenu.jsp" />
    <br>
</div>
<div align="center">
    <h2>Update Inventory Current Quantity</h2>
</div>
<br>
<div align="center">
    <div class="container">
        <div style="width:600px;" align="left">
            <form role="form" class="form-horizontal" id="InventoryController" action="InventoryController" method="post">
                <div class="form-group row">
                    <label for="categoryList" class="col-xs-4 control-label">Category:</label>
                    <div class="col-xs-8">
                        <select id="categoryList" name="categoryList" onchange="populateProduct(this)">
                            <option value="" selected>select your category</option>
                        </select>
                    </div>
                </div>
                <br>
                <div class="form-group row">
                    <label for="productList" class="col-xs-4 control-label">Product:</label>
                    <div class="col-xs-8">
                        <select id="productList" name="productList" onchange="populateQuantity(this)">
                        </select>
                    </div>
                </div>
                <br>
                <div class="form-group row">
                    <label for="currentQuantity" class="col-xs-4 control-label">Current Quantity:</label>
                    <div class="col-xs-2">
                        <input type="text" class="form-control" id="currentQuantity" name="currentQuantity" />
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

