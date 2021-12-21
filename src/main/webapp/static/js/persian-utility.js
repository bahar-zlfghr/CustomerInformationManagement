const persianDigits = ['۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹'];
const persianNumbers = [/۰/g, /۱/g, /۲/g, /۳/g, /۴/g, /۵/g, /۶/g, /۷/g, /۸/g, /۹/g];

function toPersianNumber(input) {
    for (let i = 0; i < persianDigits.length; i++) {
        input = input.toString().replace(new RegExp(i.toString(), "g"), persianDigits[i]);
    }
    return input;
}

function toEnglishNumber(input) {
    if (typeof input === 'string') {
        for (let i = 0; i < 10; i++) {
            input = input.replace(persianNumbers[i], i);
        }
    }
    return input;
}