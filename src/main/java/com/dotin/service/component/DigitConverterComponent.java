package com.dotin.service.component;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
@Component
public interface DigitConverterComponent {

    static String convertDigitsEnToFa(String text) {
        Character[] persianDigits = {'۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹'};
        List<Character> persianChars = Arrays.asList(persianDigits);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentCharacter = text.charAt(i);
            if (!persianChars.contains(currentCharacter) && Character.isDigit(currentCharacter)) {
                stringBuilder.append(persianChars.get((int) currentCharacter - 48));
            }
            else {
                stringBuilder.append(currentCharacter);
            }
        }
        return stringBuilder.toString();
    }
}
