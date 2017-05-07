/**
 * jQuery form validation for user registration.
 */
$(document).ready(function () {
    var validator = $('#userRegister').validate({
        rules: {
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
            },
            confirmPassword: {
                required: true,
                equalTo: "#password",
                minlength: 6,
                maxlength: 12
            }
        }
    });

    $("#reset").click(function() {
        validator.resetForm();
    });
});