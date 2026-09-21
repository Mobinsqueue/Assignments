import java.util.Scanner;
import java.util.Random;

public class NumericToolkit {

    // Part 3
    public static int gcd(int first, int second) {
        while (second != 0) {
            int remainder = first % second;
            first = second;
            second = remainder;
        }
        return first;
    }

    // Part 4
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    // Part 5
    public static int hexDigitToDecimal(char digit) {
        if (digit >= '0' && digit <= '9') {
            return digit - '0';
        } else if (digit >= 'A' && digit <= 'F') {
            return digit - 'A' + 10;
        } else if (digit >= 'a' && digit <= 'f') {
            return digit - 'a' + 10;
        } else {
            throw new IllegalArgumentException("Invalid hex digit: " + digit);
        }
    }

    public static int hexToDecimal(String hex) {
        int result = 0;
        for (int i = 0; i < hex.length(); i++) {
            char digit = hex.charAt(i);
            result = result * 16 + hexDigitToDecimal(digit);
        }
        return result;
    }

    // Part 6
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static double max(double a, double b) {
        return (a > b) ? a : b;
    }

    public static int max(int a, int b, int c) {
        return max(max(a, b), c);
    }

    // Part 7:
    //7.1 : both numbers 5,5 are int values while from the part7 code one is converted to double
    //7.2 : modify the argument to make intended overload clear
    //7.3 : make them both into one overload combine(double a, double b)

    // Part 8
    //8.1 : fail because result was never declared until the if block  so it cant find it
    //8.2 : starts at int result = value * 2 and ends after close bracket
    //8.3 :
    // public static void scopeDemo() {
    //    int value = 10;
    //    int result = 0;
    //
    //    if (value > 0) {
    //        result = value * 2;
    //    }
    //
    //    System.out.println(result);
    //}



    // Part 9:
    public static void displayMenu() {
        System.out.println();
        System.out.println("1. Greatest Common Divisor");
        System.out.println("2. Prime Test");
        System.out.println("3. Hexadecimal to Decimal");
        System.out.println("4. Maximum Value");
        System.out.println("0. Exit");
    }

    public static int readChoice(Scanner input) {
        System.out.print("Enter choice: ");
        while (!input.hasNextInt()) {
            System.out.print("Please enter a number: ");
            input.next();
        }
        return input.nextInt();
    }

    // Part 10
    public static void handleGcd(Scanner input) {
        System.out.print("Enter first positive integer: ");
        int first = input.nextInt();
        System.out.print("Enter second positive integer: ");
        int second = input.nextInt();

        int result = gcd(first, second);
        System.out.println("GCD(" + first + ", " + second + ") = " + result);
    }

    public static void handlePrime(Scanner input) {
        System.out.print("Enter an integer to test: ");
        int number = input.nextInt();

        if (isPrime(number)) {
            System.out.println(number + " is prime.");
        } else {
            System.out.println(number + " is not prime.");
        }
    }

    public static void handleHexConversion(Scanner input) {
        System.out.print("Enter a hexadecimal string: ");
        String hex = input.next();

        int result = hexToDecimal(hex);
        System.out.println(hex + " (hex) = " + result + " (decimal)");
    }

    public static void handleMaximum(Scanner input) {
        System.out.print("How many values to compare, 2 or 3? ");
        int count = input.nextInt();

        if (count == 2) {
            System.out.print("Enter two integers separated by a space: ");
            int a = input.nextInt();
            int b = input.nextInt();
            System.out.println("Maximum = " + max(a, b));
        } else if (count == 3) {
            System.out.print("Enter three integers separated by spaces: ");
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            System.out.println("Maximum = " + max(a, b, c));
        } else {
            System.out.println("Unsupported count: " + count);
        }
    }

    // Part 11: main
    public static void main(String[] args) {

        runIndependentTests();

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = readChoice(input);

            switch (choice) {
                case 1:
                    handleGcd(input);
                    break;

                case 2:
                    handlePrime(input);
                    break;

                case 3:
                    handleHexConversion(input);
                    break;

                case 4:
                    handleMaximum(input);
                    break;

                case 0:
                    System.out.println("Exiting.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        input.close();
    }
    //part 12
    //caller only need to know input parameter to use the system, to keep it simple
    // as things can be rewritten yet keep it easy to read

    // Part 14:
    public static void runIndependentTests() {

        System.out.println("gcd(24, 36) = " + gcd(24, 36));

        System.out.println("isPrime(29) = " + isPrime(29));

        System.out.println("hexToDecimal(\"1F\") = " + hexToDecimal("1F"));


        System.out.println("max(5, 8) = " + max(5, 8));
        System.out.println("max(4.5, 2.7) = " + max(4.5, 2.7));
        System.out.println("max(5, 8, 3) = " + max(5, 8, 3));


        System.out.println("randomLowercaseLetter() = " + randomLowercaseLetter());
        System.out.println("randomUppercaseLetter() = " + randomUppercaseLetter());
        System.out.println("randomDigit() = " + randomDigit());
    //this does not affect the code just independently testing to see if it works
    }

    // Part 15:
    private static final Random RANDOM = new Random();

    public static char randomCharacter(char first, char last) {
        int range = last - first + 1;
        int offset = RANDOM.nextInt(range);
        return (char) (first + offset);
    }

    public static char randomLowercaseLetter() {
        return randomCharacter('a', 'z');
    }

    public static char randomUppercaseLetter() {
        return randomCharacter('A', 'Z');
    }

    public static char randomDigit() {
        return randomCharacter('0', '9');
    }
}