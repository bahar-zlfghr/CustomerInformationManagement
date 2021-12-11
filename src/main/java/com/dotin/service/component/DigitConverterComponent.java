package com.dotin.service.component;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
@Component
public class DigitConverterComponent {
    private static final Character[] persianDigits = {'۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹'};
    private static final Character[] englishDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static String convertEnToFa(String text) {
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

    public static Integer convertFaToEn(String text) {
        List<Character> persianChars = Arrays.asList(persianDigits);
        List<Character> englishChars = Arrays.asList(englishDigits);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentCharacter = text.charAt(i);
            if (persianChars.contains(currentCharacter)) {
                stringBuilder.append(englishChars.get((int) currentCharacter - 1776));
            }
            else {
                stringBuilder.append(currentCharacter);
            }
        }
        return Integer.valueOf(stringBuilder.toString());
    }
}
