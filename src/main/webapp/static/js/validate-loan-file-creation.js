function validateLoanFileCreationForm() {
    let loanType = document.getElementById('loanType').value;
    let period = document.getElementById('period').value;
    let amount = document.getElementById('amount').value;
    let realCustomerName = document.getElementById('real-customer-name');
    console.log(realCustomerName);

    let vLoanType = validateLoanType(loanType);
    let vPeriod = validatePeriod(period);
    let vAmount = validateAmount(amount);
    let vRealCustomerName = validateRealCustomer(realCustomerName);

    if (vLoanType) {
        document.getElementById('loanTypeError').style.display = 'none';
    }
    if (vPeriod) {
        document.getElementById('periodError').style.display = 'none';
    }
    if (vAmount) {
        document.getElementById('amountError').style.display = 'none';
    }
    if (vRealCustomerName) {
        document.getElementById('customerNOError').style.display = 'none';
    }

    return vRealCustomerName && vLoanType && vPeriod && vAmount;
}

function validateCustomerNO() {
    let customerNO = document.getElementById('customerNO').value;
    if (isEmpty(customerNO)) {
        printError(loan_file_customer_no_error, 'customerNOError');
        return false;
    }
    return true;
}

function validateRealCustomer(name) {
    if (isEmpty(name)) {
        printError(loan_file_real_customer_recovery_error, 'customerNOError');
        return false;
    }
    return true;
}

function validateLoanType(loanType) {
    if (loanType === '-1') {
        printError(loan_file_loan_type_error, 'loanTypeError');
        return false;
    }
    return true;
}

function validatePeriod(period) {
    if (isEmpty(period)) {
        printError(loan_file_period_error, 'periodError');
        return false;
    }
    else if (period <= 0) {
        printError(loan_file_negative_period_error, 'periodError');
        return false;
    }
    return true;
}

function validateAmount(amount) {
    if (isEmpty(amount)) {
        printError(loan_file_amount_error, 'amountError');
        return false;
    }
    else if (amount <= 0) {
        printError(loan_file_negative_amount_error, 'amountError');
        return false;
    }
    return true;
}

function isEmpty(data) {
    return data === '' || data === null;
}

function printError(errorMessage, errorElement) {
    let element = document.getElementById(errorElement);
    element.style.display = 'block';
    element.innerHTML = errorMessage;
}