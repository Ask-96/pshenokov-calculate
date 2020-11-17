package nyc.c4q.ac21.romancalc;

import static nyc.c4q.ac21.romancalc.Main.ALLOWED_OPERATIONS;
import static nyc.c4q.ac21.romancalc.Main.ALLOWED_ARABIC_NUMBERS;
import static nyc.c4q.ac21.romancalc.Main.ALLOWED_ROMAN_NUMBERS;

class Utils {

    /**
     * Validate that input string is roman number
     */
    static boolean isRomanNumber(String value) {
        boolean isRoman = true;

        // iterate over String[] array using enhanced for loop
        for (String s : value.split("")) {
            if (!ALLOWED_ROMAN_NUMBERS.contains(s)) {
                isRoman = false;
                break;
            }
        }

        return isRoman;
    }

    /**
     * Validate that input string is arabic number
     */
    static boolean isArabicNumber(String value) {
        boolean isArabic = true;

        // iterate over String[] array using enhanced for loop
        for (String s : value.split("")) {
            if (!ALLOWED_ARABIC_NUMBERS.contains(s)) {
                isArabic = false;
                break;
            }
        }

        return isArabic;
    }

    /**
     * Validate that input string is operator
     */
    static boolean isValidOperation(String value) {
        return ALLOWED_OPERATIONS.contains(value);
    }

    /**
     * Parse roman input string and return arabic number
     */
    static int parseRomanNumber(String number) {
        int lengthOfNumber = number.length();

        int[] value = new int[lengthOfNumber];

        for (int i = lengthOfNumber; i > 0; i -= 1) {
            if (number.charAt(i - 1) == ('I'))
                value[i - 1] = 1;
            else if (number.charAt(i - 1) == ('V'))
                value[i - 1] = 5;
            else if (number.charAt(i - 1) == ('X'))
                value[i - 1] = 10;
            else if (number.charAt(i - 1) == ('L'))
                value[i - 1] = 50;
            else if (number.charAt(i - 1) == ('C'))
                value[i - 1] = 100;
            else if (number.charAt(i - 1) == ('D'))
                value[i - 1] = 500;
            else
                // Symbol M
                value[i - 1] = 1000;
        }

        //iterates through values of roman numerals in numbers array and returns -1 if there are 4 equal values in a row
        for (int i = 0; i < lengthOfNumber - 3; i += 1) {
            if (value[i] == value[i + 1] && value[i + 1] == value[i + 2] && value[i + 2] == value[i + 3]) {
                return -1;
            }
        }

        int total = value[lengthOfNumber - 1];
        for (int i = lengthOfNumber; i > 1; i -= 1) {
            if (value[i - 1] <= value[i - 2]) {
                total += value[i - 2];
            }
            if (value[i - 1] > value[i - 2]) {
                total -= value[i - 2];
            }
        }

        return total;
    }

    /**
     * Convert arabic number to roman numerals
     */
    static String formatToRoman(int value) {
        String romanNum = "";

        while (value > 0) {
            while (value >= 1000) {
                romanNum = romanNum + "M";
                value -= 1000;
            }
            while (value >= 900) {
                romanNum = romanNum + "CM";
                value -= 900;
            }
            while (value >= 500) {
                romanNum = romanNum + "D";
                value -= 500;
            }
            while (value >= 400) {
                romanNum = romanNum + "CD";
                value -= 400;
            }
            while (value >= 100) {
                romanNum = romanNum + "C";
                value -= 100;
            }
            while (value >= 90) {
                romanNum = romanNum + "XC";
                value -= 90;
            }
            while (value >= 50) {
                romanNum = romanNum + "L";
                value -= 50;
            }
            while (value >= 40) {
                romanNum = romanNum + "XL";
                value -= 40;
            }
            while (value >= 10) {
                romanNum = romanNum + "X";
                value -= 10;
            }
            while (value >= 9) {
                romanNum = romanNum + "IX";
                value -= 9;
            }
            while (value >= 5) {
                romanNum = romanNum + "V";
                value -= 5;
            }
            while (value >= 4) {
                romanNum = romanNum + "IV";
                value -= 4;
            }
            while (value >= 1) {
                romanNum = romanNum + "I";
                value -= 1;
            }
        }
        return romanNum;
    }

    /**
     * This block performs the operation if user input is valid
     */
    static int perform(int left, int right, String operation) {
        switch (operation) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            default:
                return left / right;
        }
    }
}
