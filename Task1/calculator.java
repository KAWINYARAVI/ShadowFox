import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nCalculator Menu:");
            System.out.println("1. Basic Arithmetic Operations");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    basicArithmetic(scanner);
                    break;
                case 2:
                    scientificCalculations(scanner);
                    break;
                case 3:
                    unitConversions(scanner);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }

    private static void basicArithmetic(Scanner scanner) {
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Choose operation: ");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        int operation = scanner.nextInt();

        double result = 0;
        switch (operation) {
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 * num2;
                break;
            case 4:
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero!");
                    return;
                }
                break;
            default:
                System.out.println("Invalid operation! Please try again.");
                return;
        }

        System.out.println("The result is: " + result);
    }

    private static void scientificCalculations(Scanner scanner) {
        System.out.println("Choose scientific calculation: ");
        System.out.println("1. Square Root");
        System.out.println("2. Exponentiation");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a number: ");
                double num = scanner.nextDouble();
                if (num >= 0) {
                    System.out.println("The square root is: " + Math.sqrt(num));
                } else {
                    System.out.println("Error: Negative number for square root!");
                }
                break;
            case 2:
                System.out.print("Enter the base: ");
                double base = scanner.nextDouble();
                System.out.print("Enter the exponent: ");
                double exponent = scanner.nextDouble();
                System.out.println("The result is: " + Math.pow(base, exponent));
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    private static void unitConversions(Scanner scanner) {
        System.out.println("Choose unit conversion: ");
        System.out.println("1. Temperature (Celsius to Fahrenheit)");
        System.out.println("2. Temperature (Fahrenheit to Celsius)");
        System.out.println("3. Currency (USD to EUR)");
        System.out.println("4. Currency (EUR to USD)");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter temperature in Celsius: ");
                double celsius = scanner.nextDouble();
                double fahrenheit = celsius * 9/5 + 32;
                System.out.println(celsius + "°C = " + fahrenheit + "°F");
                break;
            case 2:
                System.out.print("Enter temperature in Fahrenheit: ");
                fahrenheit = scanner.nextDouble();
                celsius = (fahrenheit - 32) * 5/9;
                System.out.println(fahrenheit + "°F = " + celsius + "°C");
                break;
            case 3:
                System.out.print("Enter amount in USD: ");
                double usd = scanner.nextDouble();
                double eur = usd * 0.85;  // Assuming 1 USD = 0.85 EUR
                System.out.println(usd + " USD = " + eur + " EUR");
                break;
            case 4:
                System.out.print("Enter amount in EUR: ");
                eur = scanner.nextDouble();
                usd = eur / 0.85;  // Assuming 1 EUR = 1/0.85 USD
                System.out.println(eur + " EUR = " + usd + " USD");
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }
}
