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
        var input2 = parseFloat($('#perUnitCost').val());

        parseFloat($('#totalCost').val(input1 * input2));
    }
});