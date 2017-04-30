/**
 * jQuery form validation for products.jsp.
 */
$(document).ready(function() {

    $('#ProductController').validate({
        rules: {
            productName: {
                required: true,
                lettersonly: true,
                minlength: 2,
                maxlength: 30,
            },
            quantityOrdered: {
                required: true,
            },
            weight: {
                required: true,
            },
            perUnitCost: {
                required: true,
            }
        }
    });
});