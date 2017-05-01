/**
 * Created by amalbaugh on 4/30/17.
 */
$(document).ready(function() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/inventorytracker/json/categories",
        data: "data",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            $(data).each(function () {
                var option = $('<option />').val(this.categoryId).text(this.categoryName);
                $('#categoryList').append(option);
            });
        }

    })
    return false;

})