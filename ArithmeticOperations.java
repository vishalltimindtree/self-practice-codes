import java.util.Scanner;

public class ArithmeticOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the first number: ");
            String input1 = scanner.nextLine();
            System.out.print("Enter the second number: ");
            String input2 = scanner.nextLine();

            int num1 = Integer.parseInt(input1);
            int num2 = Integer.parseInt(input2);

            divide(num1, num2);

        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input. Please enter valid numbers.");
        } finally {
            scanner.close();
        }
    }

    public static void divide(int dividend, int divisor) {
        try {
            int result = dividend / divisor;
            System.out.println("The result of the division is: " + result);
        } catch (ArithmeticException ae) {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}