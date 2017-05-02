$(document).ready(function () {
    populateProduct();
});

function populateProduct() {
    var selectedText1 = $("#categoryList").val();
    $.ajax({
        type: "GET",
        url: "/inventorytracker/json/products",
        data: '{ categoryId :" ' + selectedText1 + '"}',
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (data) {
            $("#productList").empty();
            $(data).each(function () {
                if (selectedText1 == this.category.categoryId) {
                    var option = $('<option />').val(this.productId).text(this.productName);
                    $('#productList').append(option);
                }
            });
        }
    })
    return false
}
