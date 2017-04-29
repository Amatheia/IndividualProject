/**
 * Created by amalbaugh on 4/27/17.
 */
$(document).ready(function () {

    $('#userRegister').validate({ // initialize the plugin
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

});