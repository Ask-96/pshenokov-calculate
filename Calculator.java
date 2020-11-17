package nyc.c4q.ac21.romancalc;


class Calculator {

    /**
     * Performs calculations on Roman numerals and prints the result.
     */
    static void calculateRomanNumber(String leftNumber, String rightNumber, String operation) {
        final int left = Utils.parseRomanNumber(leftNumber);
        final int right = Utils.parseRomanNumber(rightNumber);

        final int result = Utils.perform(left, right, operation);

        final String romanNumber = Utils.formatToRoman(result);

        System.out.println("Calculation result: " + romanNumber);
    }

    /**
     * Performs calculations on Arabic numerals and prints the result.
     */
    static void calculateArabicNumber(String leftNumber, String rightNumber, String operation) {
        final int left = Integer.parseInt(leftNumber);
        final int right = Integer.parseInt(rightNumber);
        final int result = Utils.perform(left, right, operation);

        System.out.println("Calculation result: " + result);
    }
}
