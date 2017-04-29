$(document).ready(function () {
    populateItem();
});

function populateItem() {
    var selectedText1 = $("#categoryList").val();

    $.ajax({
        type: "GET",
        url: "http://52.14.138.145:8080/foodexpirationservice/expiration/items",
        data: '{ categoryId :" ' + selectedText1 + '"}',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            $("#itemList").empty();
            $(data).each(function () {
                if (selectedText1 == this.categoryId) {
                    var option = $('<option />').val(this.itemName).text(this.itemName);
                    $('#itemList').append(option);
                }
            });
        }
    })
    return false
}
