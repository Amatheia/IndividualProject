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
        var total = input1 * input2;
        if (!isNaN(total)) {
            parseFloat($('#currentValue').val(total.toFixed(2)));
        }

    }
});
