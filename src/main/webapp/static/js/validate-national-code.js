function checkNationalCode(PersianNationalCode) {
    const nationalCode = toEnglishNumber(PersianNationalCode);
    let nationalCodeDigits = String(nationalCode)
        .split("")
        .map(
            number => Number(number)
        );
    let lastDigit = nationalCodeDigits[9];
    nationalCodeDigits.pop();
    let remaining = nationalCodeDigits.reduce(sum, 0) % 11;
    return remaining === lastDigit || remaining === 11 - lastDigit;
}

function sum(total, currentValue, currentIndex) {
    return total + (currentValue * (10 - currentIndex));
}