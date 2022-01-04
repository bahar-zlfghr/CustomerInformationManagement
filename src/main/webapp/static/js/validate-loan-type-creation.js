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
    if (isEmpty(name)) {
        printError(loan_type_name_error, 'nameError');
        return false;
    }
    else if (name.length < loan_type_name_min_length) {
        printError(loan_type_name_min_length_error, 'nameError');
        return false;
    }
    return true;
}

function validateInterestRate(interestRate) {
    if (isEmpty(interestRate)) {
        printError(loan_type_interest_rate_error, 'interestRateError');
        return false;
    }
    else if (interestRate < loan_type_interest_rate_min_value || interestRate > loan_type_interest_rate_max_value) {
        printError(loan_type_interest_rate_value_error, 'interestRateError');
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