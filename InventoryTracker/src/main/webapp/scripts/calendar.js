/**
 * jQuery calendar function for products.jsp.
 */
$(document).ready(function() {

    $("#orderDate, #dateReceived").datepicker({
        changeMonth:true,
        changeYear:true,
        dateFormat: "yy-mm-dd"
    });

});