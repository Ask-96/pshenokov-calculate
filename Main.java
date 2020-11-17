package nyc.c4q.ac21.romancalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    static List<String> ALLOWED_OPERATIONS = Arrays.asList("+", "-", "*", "/");
    static List<String> ALLOWED_ROMAN_NUMBERS = Arrays.asList("M", "D", "C", "L", "X", "V", "I");
    static List<String> ALLOWED_ARABIC_NUMBERS = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

    /**
     * Program prints a prompt and waits for you to type a simple expression to calculate.
     * An expression consists of a number in Roman or Arabic numerals, followed
     * by an operation, followed by another number in Roman or Arabic numerals.
     * Each should be separated by a space.
     */
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Loop forever
        while (true) {
            // Show the prompt
            System.out.print("> ");
            // Read a line of input.
            final String line = reader.readLine();
            if (line.length() == 0) {
                System.out.println("done");
                break;
            }
            // Scan the line into three parts: two numbers with an operator between them.
            final Scanner scanner = new Scanner(line);
            final String leftNumber, operation, rightNumber;
            try {
                leftNumber = scanner.next().toUpperCase();
                operation = scanner.next().toUpperCase();
                rightNumber = scanner.next().toUpperCase();
            } catch (NoSuchElementException e) {
                System.err.println("syntax error");
                System.out.println();
                continue;
            }

            // Check if input operator is valid
            if (!Utils.isValidOperation(operation)) {
                System.out.println("Received invalid operation " + operation);
                continue;
            }

            if (Utils.isRomanNumber(leftNumber) && Utils.isRomanNumber(rightNumber)) {
                Calculator.calculateRomanNumber(leftNumber, rightNumber, operation);
            } else if (Utils.isArabicNumber(leftNumber) && Utils.isArabicNumber(rightNumber)) {
                Calculator.calculateArabicNumber(leftNumber, rightNumber, operation);
            } else {
                System.out.println("Received invalid numbers " + leftNumber + " and " + rightNumber);
                continue;
            }

            System.out.println();
        }
    }
}
