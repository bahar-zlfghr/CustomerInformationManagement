function validateLoanTypeCreationForm() {
    let name = document.getElementById('name').value;
    let interestRate = document.getElementById('interestRate').value;

    let vName = validateName(name);
    let vInterestRate = validateInterestRate(interestRate);

    if (vName) {
        document.getElementById('nameError').style.display = 'none';
    }
    if (vInterestRate) {
        document.getElementById('interestRateError').style.display = 'none';
    }
    return vName && vInterestRate;
}

function validateName(name) {
    let errorMessage;
    if (isEmpty(name)) {
        errorMessage = 'نام نوع تسهیلات را وارد کنید';
        printError(errorMessage, 'nameError');
        return false;
    }
    else if (name.length < 5) {
        errorMessage = 'حداقل طول نام نوع تسهیلات ۵ است';
        printError(errorMessage, 'nameError');
        return false;
    }
    return true;
}

function validateInterestRate(interestRate) {
    let errorMessage;
    let interestRateEn = toEnglishNumber(interestRate);
    if (isEmpty(interestRate)) {
        errorMessage = 'نرخ سود را وارد کنید';
        printError(errorMessage, 'interestRateError');
        return false;
    }
    else if (interestRateEn < 0 || interestRateEn > 100) {
        errorMessage = 'نرخ سود باید بین ۰ تا ۱۰۰ باشد';
        printError(errorMessage, 'interestRateError');
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