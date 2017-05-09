/**
 * jQuery total cost function for products.jsp.
 */
$(document).ready(function() {

    $('#quantityOrdered').keyup(function() {
        updateTotal();
    });

    $('#perUnitCost').keyup(function() {
        updateTotal();
    });

    var updateTotal = function () {

        var input1 = parseFloat($('#quantityOrdered').val());
        if (isNaN(input1)) {
            input1 = 0;
        }

        var input2 = parseFloat($('#perUnitCost').val());
        if (isNaN(input2)) {
            input2 = 0;
        }

        var totalCost = input1 * input2;

        parseFloat($('#totalCost').val(totalCost.toFixed(2)));

    }
});