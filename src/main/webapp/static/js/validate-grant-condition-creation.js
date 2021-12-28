const grantConditions = [];

function validateGrantConditionCreationForm() {
    let name = document.getElementById('name').value;
    let minPeriod = document.getElementById('minPeriod').value;
    let maxPeriod = document.getElementById('maxPeriod').value;
    let minAmount = document.getElementById('minAmount').value;
    let maxAmount = document.getElementById('maxAmount').value;

    let vName = validateName(name);
    let vMinPeriod = validateMinPeriod(minPeriod);
    let vMaxPeriod = validateMaxPeriod(maxPeriod);
    let vMinAmount = validateMinAmount(minAmount);
    let vMaxAmount = validateMaxAmount(maxAmount);

    if (vName) {
        document.getElementById('nameError').style.display = 'none';
    }
    if (vMinPeriod) {
        document.getElementById('minPeriodError').style.display = 'none';
    }
    if (vMaxPeriod) {
        document.getElementById('maxPeriodError').style.display = 'none';
    }
    if (vMinAmount) {
        document.getElementById('minAmountError').style.display = 'none';
    }
    if (vMaxAmount) {
        document.getElementById('maxAmountError').style.display = 'none';
    }

    return vName && vMinPeriod && vMaxPeriod && vMinAmount && vMaxAmount;
}

function validateName(name) {
    let errorMessage;
    if (isEmpty(name)) {
        errorMessage = 'نام شرط اعطاء را وارد کنید';
        printError(errorMessage, 'nameError');
        return false;
    }
    else if (name.length < 3) {
        errorMessage = 'حداقل طول نام شرط اعطاء ۳ است';
        printError(errorMessage, 'nameError');
        return false;
    }
    return true;
}

function validateMinPeriod(minPeriod) {
    let errorMessage;
    let minPeriodEn = toEnglishNumber(minPeriod);
    if (isEmpty(minPeriod)) {
        errorMessage = 'حداقل مدت قرارداد را وارد کنید';
        printError(errorMessage, 'minPeriodError');
        return false;
    }
    else if (minPeriodEn < 0) {
        errorMessage = 'حداقل مدت قرارداد باید بزرگتر از ۰ باشد';
        printError(errorMessage, 'minPeriodError');
        return false;
    }
    return true;
}

function validateMaxPeriod(maxPeriod) {
    let errorMessage;
    let maxPeriodEn = toEnglishNumber(maxPeriod);
    if (isEmpty(maxPeriod)) {
        errorMessage = 'حداکثر مدت قرارداد را وارد کنید';
        printError(errorMessage, 'maxPeriodError');
        return false;
    }
    else if (maxPeriodEn < 0) {
        errorMessage = 'حداکثر مدت قرارداد باید بزرگتر از ۰ باشد';
        printError(errorMessage, 'maxPeriodError');
        return false;
    }
    return true;
}

function validateMinAmount(minAmount) {
    let errorMessage;
    let minAmountEn = toEnglishNumber(minAmount);
    if (isEmpty(minAmount)) {
        errorMessage = 'حداقل مبلغ قرارداد را وارد کنید';
        printError(errorMessage, 'minAmountError');
        return false;
    }
    else if (minAmountEn < 0) {
        errorMessage = 'حداقل مبلغ قرارداد باید بزرگتر از ۰ باشد';
        printError(errorMessage, 'minAmountError');
        return false;
    }
    return true;
}

function validateMaxAmount(maxAmount) {
    let errorMessage;
    let maxAmountEn = toEnglishNumber(maxAmount);
    if (isEmpty(maxAmount)) {
        errorMessage = 'حداکثر مبلغ قرارداد را وارد کنید';
        printError(errorMessage, 'maxAmountError');
        return false;
    }
    else if (maxAmountEn < 0) {
        errorMessage = 'حداکثر مبلغ قرارداد باید بزرگتر از ۰ باشد';
        printError(errorMessage, 'maxAmountError');
        return false;
    }
    return true;
}

function validateGrantConditions() {
    let errorMessage;
    if (grantConditions.length === 0) {
        errorMessage = 'هر نوع تسهیلات حداقل باید یک شرط اعطاء داشته باشد';
        printError(errorMessage, 'grantConditionsError');
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