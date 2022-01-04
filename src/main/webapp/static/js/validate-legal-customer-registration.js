function validateLegalCustomerRegistrationForm() {
    let companyName = document.getElementById('companyName').value;
    let registrationDate = document.getElementById('registrationDate').value;
    let economicCode = document.getElementById('economicCode').value;

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
    if (isEmpty(companyName)) {
        printError(legal_customer_company_name_error, 'companyNameError');
        return false;
    }
    else if (companyName.length < legal_customer_company_name_min_length) {
        printError(legal_customer_company_name_min_length_error, 'companyNameError');
        return false;
    }
    return true;
}
function validateRegistrationDate(registrationDate) {
    if (isEmpty(registrationDate)) {
        printError(legal_customer_registration_date_error, 'registrationDateError');
        return false;
    }
    else if (!date_pattern.test(toEnglishNumber(registrationDate))) {
        printError(legal_customer_registration_date_not_valid_error, 'registrationDateError');
        return false;
    }
    return true;
}

function validateEconomicCode(nationalCode) {
    if (isEmpty(nationalCode)) {
        printError(legal_customer_economic_code_error, 'economicCodeError');
        return false;
    }
    else if (nationalCode.length !== legal_customer_economic_code_length) {
        printError(legal_customer_economic_code_length_error, 'economicCodeError');
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