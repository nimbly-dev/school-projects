/*
    CLIENT SIDE CREDIT CARD VALIDATION
*/
$("#processPaymentForm").validate({
    //RULESET OF INPUTS
    rules: {
        fullName: {
            required: true,
            minlength: 2,
            checkdigit: false
        },
        creditCardNumber: {
            required: true,
            creditcard: true
        },
        expirationDate: {
            required: true,
            date: true
        },
        securityNumber: {
            minlength: 4,
            maxlength: 4,
            required: true
        }
    },
    //VALIDATION ERROR MESSAGES
    messages: {
        fullName: {
            required: "Please Enter your Name",
            minlength: "Name must not be less than 1",
            checkdigit: "Name must not contain numbers"
        },
        creditCardNumber: {
            required: "Please enter Credit Card Number",
            creditCard: "Credit Card Number is Invalid"
        },
        expirationDate: {
            required: "Please enter Expiry Date",
            date: "Date inputted is invalid"
        },
        securityNumber: {
            minlength: "Length must be equal to 4",
            maxlength: "Length must be equal to 4"
        }
    },
    errorElement: 'div',
    errorPlacement: function (error, element) {
        let placement = $(element).data('error');
        if (placement) {
            $(placement).append(error)
        } else {
            error.insertAfter(element);
        }
    }
});


