/**
 * jQuery current value function for products.jsp.
 */
$(document).ready(function() {
    $('#currentQuantity').keyup(function() {
        updateTotal();
    });

    $('#perUnitCost').keyup(function() {
        updateTotal();
    });

    var updateTotal = function () {
        var input1 = parseFloat($('#currentQuantity').val());
        var input2 = parseFloat($('#perUnitCost').val());

        parseFloat($('#currentValue').val(input1 * input2));
    }
});
