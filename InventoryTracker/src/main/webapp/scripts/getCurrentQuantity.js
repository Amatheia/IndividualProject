$(document).ready(function () {
    populateQuantity();
});

function populateQuantity() {

    var selectedText = $("#productList").val();
    console.log(selectedText);
    $.ajax({
        type: "GET",
        url: "/inventorytracker/json/products",
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
