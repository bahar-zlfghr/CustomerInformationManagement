function validateRegistrationForm() {
    let firstName = document.forms['registration-form']['firstName'].value;
    let lastName = document.forms['registration-form']['lastName'].value;
    let fatherName = document.forms['registration-form']['fatherName'].value;
    let birthDate = document.forms['registration-form']['birthDate'].value;

    if (isEmpty(firstName)) {
        printError('نام مشتری را وارد کنید', 'firstNameError');
    }
    if (isEmpty(lastName)) {
        printError('نام خانوادگی مشتری را وارد کنید', 'lastNameError');
    }
    if (isEmpty(fatherName)) {
        printError('نام پدر مشتری را وارد کنید', 'fatherNameError');
    }
    if (isEmpty(birthDate)) {
        printError('تاریخ تولد مشتری را وارد کنید', 'birthDateError');
    }
}

function isEmpty(data) {
    return data === '';
}

function printError(errorMessage, errorElement) {
    document.getElementById(errorElement).innerHTML = errorMessage;
}