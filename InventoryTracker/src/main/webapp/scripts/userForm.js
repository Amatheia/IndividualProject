/**
 * jQuery form validation for user form.
 */
$(document).ready(function () {

    $('#UserController').validate({
        rules: {
            role: {
                required: true
            },
            firstname: {
                required: true,
                lettersonly: true,
                minlength: 2
            },
            lastname: {
                required: true,
                lettersonly: true,
                minlength: 2
            },
            username: {
                required: true,
                minlength: 4
            },
            password: {
                required: true,
                minlength: 6,
                maxlength: 12
            }
        }
    });

});
