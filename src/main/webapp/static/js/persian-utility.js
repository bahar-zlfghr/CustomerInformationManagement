const persianDigits = ['۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹'];

function toPersianNumber(input) {
    for (let i = 0; i < persianDigits.length; i++) {
        input = input.toString().replace(new RegExp(i.toString(), "g"), persianDigits[i]);
    }
    return input;
}

function toFarsiNumber(n) {
    return n
        .toString()
        .split('')
        .map(x => persianDigits[x])
        .join('');
}