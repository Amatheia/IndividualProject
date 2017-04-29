/**
 * Created by amalbaugh on 4/8/17.
 */
$(document).ready(function() {
    $.ajax({
        type: "GET",
        url: "http://52.14.138.145:8080/foodexpirationservice/expiration/categories/",
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