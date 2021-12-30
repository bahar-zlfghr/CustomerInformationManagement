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
        let errorMessage = 'شماره مشتری را وارد کنید';
        printError(errorMessage, 'customerNOError');
        return false;
    }
    return true;
}

function validateRealCustomer(name) {
    if (isEmpty(name)) {
        let errorMessage = 'ابتدا اطلاعات مشتری مورد نظر را بازیابی کنید';
        printError(errorMessage, 'customerNOError');
        return false;
    }
    return true;
}

function validateLoanType(loanType) {
    let errorMessage;
    if (loanType === '-1') {
        errorMessage = 'نوع تسهیلات را انتخاب کنید';
        printError(errorMessage, 'loanTypeError');
        return false;
    }
    return true;
}

function validatePeriod(period) {
    let errorMessage;
    if (isEmpty(period)) {
        errorMessage = 'مدت قرارداد را وارد کنید';
        printError(errorMessage, 'periodError');
        return false;
    }
    else if (period < 0) {
        errorMessage = 'مدت قرارداد باید بزرگتر از ۰ باشد';
        printError(errorMessage, 'periodError');
        return false;
    }
    return true;
}

function validateAmount(amount) {
    let errorMessage;
    if (isEmpty(amount)) {
        errorMessage = 'مبلغ قرارداد را وارد کنید';
        printError(errorMessage, 'amountError');
        return false;
    }
    else if (amount < 0) {
        errorMessage = 'مبلغ قرارداد باید بزرگتر از ۰ باشد';
        printError(errorMessage, 'amountError');
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