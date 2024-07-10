import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Select an option:");
            System.out.println("1. Basic Arithmetic Operations");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("4. Exit");
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
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    public static void basicArithmetic(Scanner scanner) {
        System.out.println("Enter first number:");
        double num1 = scanner.nextDouble();
        System.out.println("Enter second number:");
        double num2 = scanner.nextDouble();
        System.out.println("Select operation (+, -, *, /):");
        char operation = scanner.next().charAt(0);

        switch (operation) {
            case '+':
                System.out.println("Result: " + (num1 + num2));
                break;
            case '-':
                System.out.println("Result: " + (num1 - num2));
                break;
            case '*':
                System.out.println("Result: " + (num1 * num2));
                break;
            case '/':
                if (num2 != 0) {
                    System.out.println("Result: " + (num1 / num2));
                } else {
                    System.out.println("Error: Division by zero.");
                }
                break;
            default:
                System.out.println("Invalid operation.");
        }
    }

    public static void scientificCalculations(Scanner scanner) {
        System.out.println("Select operation:");
        System.out.println("1. Square Root");
        System.out.println("2. Exponentiation");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter number:");
                double num = scanner.nextDouble();
                System.out.println("Result: " + Math.sqrt(num));
                break;
            case 2:
                System.out.println("Enter base:");
                double base = scanner.nextDouble();
                System.out.println("Enter exponent:");
                double exponent = scanner.nextDouble();
                System.out.println("Result: " + Math.pow(base, exponent));
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    public static void unitConversions(Scanner scanner) {
        System.out.println("Select conversion type:");
        System.out.println("1. Temperature (Celsius to Fahrenheit)");
        System.out.println("2. Currency (USD to EUR)");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter temperature in Celsius:");
                double celsius = scanner.nextDouble();
                double fahrenheit = (celsius * 9 / 5) + 32;
                System.out.println("Temperature in Fahrenheit: " + fahrenheit);
                break;
            case 2:
                System.out.println("Enter amount in USD:");
                double usd = scanner.nextDouble();
                // Assuming a conversion rate of 1 USD = 0.85 EUR
                double eur = usd * 0.85;
                System.out.println("Amount in EUR: " + eur);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}
