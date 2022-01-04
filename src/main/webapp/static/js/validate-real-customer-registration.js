function validateRealCustomerRegistrationForm() {
    let firstName = document.getElementById('firstName').value;
    let lastName = document.getElementById('lastName').value;
    let fatherName = document.getElementById('fatherName').value;
    let birthDate = document.getElementById('birthDate').value;
    let nationalCode = document.getElementById('nationalCode').value;

    let vFirstName = validateFirstName(firstName);
    let vLastName = validateLastName(lastName);
    let vFatherName = validateFatherName(fatherName);
    let vBirthDate = validateBirthDate(birthDate);
    let vNationalCode = validateNationalCode(nationalCode);

    if (vFirstName) {
        document.getElementById('firstNameError').style.display = 'none';
    }
    if (vLastName) {
        document.getElementById('lastNameError').style.display = 'none';
    }
    if (vFatherName) {
        document.getElementById('fatherNameError').style.display = 'none';
    }
    if (vBirthDate) {
        document.getElementById('birthDateError').style.display = 'none';
    }
    if (vNationalCode) {
        document.getElementById('nationalCodeError').style.display = 'none';
    }

    return vFirstName && vLastName && vFatherName && vBirthDate && vNationalCode;
}

function validateFirstName(firstName) {
    if (isEmpty(firstName)) {
        printError(real_customer_first_name_error, 'firstNameError');
        return false;
    }
    else if (firstName.length < real_customer_first_name_min_length) {
        printError(real_customer_first_name_min_length_error, 'firstNameError');
        return false;
    }
    return true;
}

function validateLastName(lastName) {
    if (isEmpty(lastName)) {
        printError(real_customer_last_name_error, 'lastNameError');
        return false;
    }
    else if (lastName.length < real_customer_last_name_min_length) {
        printError(real_customer_last_name_min_length_error, 'lastNameError');
        return false;
    }
    return true;
}

function validateFatherName(fatherName) {
    if (isEmpty(fatherName)) {
        printError(real_customer_father_name_error, 'fatherNameError');
        return false;
    }
    else if (fatherName.length < real_customer_father_name_min_length) {
        printError(real_customer_father_name_length_error, 'fatherNameError');
        return false;
    }
    return true;
}

function validateBirthDate(birthDate) {
    if (isEmpty(birthDate)) {
        printError(real_customer_birth_date_error, 'birthDateError');
        return false;
    }
    else if (!date_pattern.test(toEnglishNumber(birthDate))) {
        printError(real_customer_birth_date_not_valid_error, 'birthDateError');
        return false;
    }
    return true;
}

function validateNationalCode(nationalCode) {
    if (isEmpty(nationalCode)) {
        printError(real_customer_national_code_error, 'nationalCodeError');
        return false;
    }
    else if (nationalCode.length !== real_customer_national_code_length) {
        printError(real_customer_national_code_length_error, 'nationalCodeError');
        return false;
    } else if (!checkNationalCode(nationalCode)) {
        printError(real_customer_national_code_not_valid_error, 'nationalCodeError');
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