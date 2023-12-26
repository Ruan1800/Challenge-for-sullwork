package com.desafiowl.demo.utils;

public class CpfValidator {

    public static boolean isValidCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        int[] cpfDigits = new int[11];
        for (int i = 0; i < 11; i++) {
            cpfDigits[i] = Character.getNumericValue(cpf.charAt(i));
        }

        if (areAllDigitsEqual(cpfDigits) || !isValidChecksum(cpfDigits)) {
            return false;
        }

        return true;
    }

    private static boolean areAllDigitsEqual(int[] digits) {
        int firstDigit = digits[0];
        for (int digit : digits) {
            if (digit != firstDigit) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidChecksum(int[] digits) {
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            sum += digits[i] * (10 - i);
        }
        int firstChecksumDigit = 11 - (sum % 11);
        if (firstChecksumDigit == 10 || firstChecksumDigit == 11) {
            firstChecksumDigit = 0;
        }

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += digits[i] * (11 - i);
        }
        int secondChecksumDigit = 11 - (sum % 11);
        if (secondChecksumDigit == 10 || secondChecksumDigit == 11) {
            secondChecksumDigit = 0;
        }

        return digits[9] == firstChecksumDigit && digits[10] == secondChecksumDigit;
    }
}