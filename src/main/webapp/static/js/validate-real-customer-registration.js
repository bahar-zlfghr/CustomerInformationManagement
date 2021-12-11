function validateRealCustomerRegistrationForm() {
    let firstName = document.getElementById('firstName').value;
    let lastName = document.getElementById('lastName').value;
    let fatherName = document.getElementById('fatherName').value;
    let birthDate = document.getElementById('birthDate').value;
    let nationalCode = document.getElementById('nationalCode').value;
    console.log(nationalCode);

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
    let errorMessage;
    if (isEmpty(firstName)) {
        errorMessage = 'نام مشتری را وارد کنید';
        printError(errorMessage, 'firstNameError');
        return false;
    }
    else if (firstName.length < 3) {
        errorMessage = 'حداقل طول نام مشتری ۳ است';
        printError(errorMessage, 'firstNameError');
        return false;
    }
    return true;
}

function validateLastName(lastName) {
    let errorMessage;
    if (isEmpty(lastName)) {
        errorMessage = 'نام خانوادگی مشتری را وارد کنید';
        printError(errorMessage, 'lastNameError');
        return false;
    }
    else if (lastName.length < 3) {
        errorMessage = 'حداقل طول نام خانوادگی مشتری ۳ است';
        printError(errorMessage, 'lastNameError');
        return false;
    }
    return true;
}

function validateFatherName(fatherName) {
    let errorMessage;
    if (isEmpty(fatherName)) {
        errorMessage = 'نام پدر مشتری را وارد کنید';
        printError(errorMessage, 'fatherNameError');
        return false;
    }
    else if (fatherName.length < 3) {
        errorMessage = 'حداقل طول نام پدر مشتری ۳ است';
        printError(errorMessage, 'fatherNameError');
        return false;
    }
    return true;
}

function validateBirthDate(birthDate) {
    let errorMessage;
    if (isEmpty(birthDate)) {
        errorMessage = 'تاریخ تولد مشتری را وارد کنید';
        printError(errorMessage, 'birthDateError');
        return false;
    }
    return true;
}

function validateNationalCode(nationalCode) {
    let errorMessage;
    if (isEmpty(nationalCode)) {
        errorMessage = 'کد ملی مشتری را وارد کنید';
        printError(errorMessage, 'nationalCodeError');
        return false;
    }
    else if (nationalCode.length !== 10) {
        errorMessage = 'کد ملی مشتری باید 10 رقمی باشد';
        printError(errorMessage, 'nationalCodeError');
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