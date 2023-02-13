package org.godstime;

import java.util.Scanner;

public class Calculator {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continueCalculating = true;

        while (continueCalculating) {
            double firstNumber = getFirstNumber();
            double secondNumber = getSecondNumber();
            int operation = getOperation();
            double result = performCalculation(firstNumber, secondNumber, operation);
            if (Double.isNaN(result)) {
                System.out.println("Cannot divide by zero.");
            } else {
                displayResult(result);
            }
            continueCalculating = getContinueCalculating();
        }
    }

    private static double getFirstNumber() {
        System.out.println("Godstime Basic Arithmetic Calculator");
        System.out.println("-------------------------------------- ");
        System.out.print("Enter first number: ");
        while (!input.hasNextDouble()) {
            input.next();
            System.out.print("Invalid input. Please enter a valid number: ");
        }
        return input.nextDouble();
    }

    private static double getSecondNumber() {
        System.out.print("Enter second number: ");
        while (!input.hasNextDouble()) {
            input.next();
            System.out.print("Invalid input. Please enter a valid number: ");
        }
        return input.nextDouble();
    }

    private static int getOperation() {
        System.out.println("Choose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        int operation;
        do {
            System.out.print("Enter operation number: ");
            while (!input.hasNextInt()) {
                input.next();
                System.out.print("Invalid input. Please enter a valid number: ");
            }
            operation = input.nextInt();
        } while (operation < 1 || operation > 4);

        return operation;
    }

    private static double performCalculation(double firstNumber, double secondNumber, int operation) {
        switch (operation) {
            case 1:
                return firstNumber + secondNumber;
            case 2:
                return firstNumber - secondNumber;
            case 3:
                return firstNumber * secondNumber;
            case 4:
                if (secondNumber == 0) {
                    return Double.NaN;
                } else {
                    return firstNumber / secondNumber;
                }
            default:
                return 0;
        }
    }

    private static void displayResult(double result) {
        System.out.println("Result: " + result);
    }

    private static boolean getContinueCalculating() {
        System.out.print("Do you want to perform another calculation? (yes(Y)/no(N): ");
        String response = input.next();
        while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
            System.out.print("Invalid input. Please enter 'yes'(Y) or 'no'(N): ");
            response = input.next();
        }
        return response.equalsIgnoreCase("y");
    }
}
