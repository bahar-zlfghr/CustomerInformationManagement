function validateLegalCustomerRegistrationForm() {
    let companyName = document.forms['registration-form']['companyName'].value;
    let registrationDate = document.forms['registration-form']['registrationDate'].value;
    let economicCode = document.forms['registration-form']['economicCode'].value;

    let vCompanyName = validateCompanyName(companyName);
    let vRegistrationDate = validateRegistrationDate(registrationDate);
    let vEconomicCode = validateEconomicCode(economicCode);

    if (vCompanyName) {
        document.getElementById('companyNameError').style.display = 'none';
    }
    if (vRegistrationDate) {
        document.getElementById('registrationDateError').style.display = 'none';
    }
    if (vEconomicCode) {
        document.getElementById('economicCodeError').style.display = 'none';
    }

    return vCompanyName && vRegistrationDate && vEconomicCode;
}

function validateCompanyName(companyName) {
    let errorMessage;
    if (isEmpty(companyName)) {
        errorMessage = 'نام شرکت را وارد کنید';
        printError(errorMessage, 'companyNameError');
        return false;
    }
    else if (companyName.length < 3) {
        errorMessage = 'حداقل طول نام شرکت ۳ است';
        printError(errorMessage, 'companyNameError');
        return false;
    }
    return true;
}
function validateRegistrationDate(registrationDate) {
    let errorMessage;
    if (isEmpty(registrationDate)) {
        errorMessage = 'تاریخ ثبت شرکت را وارد کنید';
        printError(errorMessage, 'registrationDateError');
        return false;
    }
    return true;
}

function validateEconomicCode(nationalCode) {
    let errorMessage;
    if (isEmpty(nationalCode)) {
        errorMessage = 'کد اقتصادی مشتری حقوقی را وارد کنید';
        printError(errorMessage, 'economicCodeError');
        return false;
    }
    else if (nationalCode.length !== 12) {
        errorMessage = 'کد اقتصادی مشتری حقوقی باید ۱۲ رقمی باشد';
        printError(errorMessage, 'economicCodeError');
        return false;
    }
    return true;
}

function isEmpty(data) {
    return data === '';
}

function printError(errorMessage, errorElement) {
    let element = document.getElementById(errorElement);
    element.style.display = 'block';
    element.innerHTML = errorMessage;
}