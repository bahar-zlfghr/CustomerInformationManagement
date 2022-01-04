let grantConditions;
if (localStorage.getItem("grantConditions") == null) {
    grantConditions = [];
}
else {
    grantConditions = JSON.parse(localStorage.getItem("grantConditions"))
}

function showGrantConditionItems() {
    for (let i = 0; i < grantConditions.length; i++) {
        const table = document.getElementById("table");

        table.style.display = 'flex';
        table.style.justifyContent = 'center';

        let row = table.insertRow(table.rows.length);
        row.insertCell(0).innerHTML = grantConditions[i].name;
        row.insertCell(1).innerHTML = grantConditions[i].minPeriod;
        row.insertCell(2).innerHTML = grantConditions[i].maxPeriod;
        row.insertCell(3).innerHTML = grantConditions[i].minAmount;
        row.insertCell(4).innerHTML = grantConditions[i].maxAmount;
    }
}


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
    if (isEmpty(name)) {
        printError(grant_condition_name_error, 'nameError');
        return false;
    }
    else if (name.length < grant_condition_name_min_length) {
        printError(grant_condition_name_min_length_error, 'nameError');
        return false;
    }
    return true;
}

function validateMinPeriod(minPeriod) {
    if (isEmpty(minPeriod)) {
        printError(grant_condition_min_period_error, 'minPeriodError');
        return false;
    }
    else if (minPeriod <= 0) {
        printError(grant_condition_negative_min_period_error, 'minPeriodError');
        return false;
    }
    return true;
}

function validateMaxPeriod(maxPeriod) {
    if (isEmpty(maxPeriod)) {
        printError(grant_condition_max_period_error, 'maxPeriodError');
        return false;
    }
    else if (maxPeriod <= 0) {
        printError(grant_condition_negative_max_period_error, 'maxPeriodError');
        return false;
    }
    return true;
}

function validateMinAmount(minAmount) {
    if (isEmpty(minAmount)) {
        printError(grant_condition_min_amount_error, 'minAmountError');
        return false;
    }
    else if (minAmount <= 0) {
        printError(grant_condition_negative_min_amount_error, 'minAmountError');
        return false;
    }
    return true;
}

function validateMaxAmount(maxAmount) {
    if (isEmpty(maxAmount)) {
        printError(grant_condition_max_amount_error, 'maxAmountError');
        return false;
    }
    else if (maxAmount <= 0) {
        printError(grant_condition_negative_max_amount_error, 'maxAmountError');
        return false;
    }
    return true;
}

function validateGrantConditions() {
    if (grantConditions.length === 0) {
        printError(loan_type_min_grant_conditions_error, 'grantConditionsError');
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