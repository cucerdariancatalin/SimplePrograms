package com.simpleprograms;

import java.util.Scanner;

/**
 * Simple program to check sequence is ordered.
 *
 * @author VitasSalvantes
 * @version 1.0
 */
public class OrderedSequence {
    /**
     * Method that launches the program.
     */
    public static void main(String[] args) {
        // The Scanner object to get the user input
        Scanner scanner = new Scanner(System.in);

        // Is it as- or descending order
        boolean ascendingOrder = true;
        boolean descendingOrder = true;

        // Two numbers to compare
        int previousNumber = scanner.nextInt();
        int currentNumber = scanner.nextInt();

        // If the sequence has only previousNumber
        if (currentNumber == 0) {
            System.out.println(true);
        } else {
            // If the sequence is in order
            while (currentNumber != 0) {
                // In ascending order
                ascendingOrder = previousNumber <= currentNumber && ascendingOrder;

                // In descending order
                descendingOrder = previousNumber >= currentNumber && descendingOrder;

                // Go to a next number
                previousNumber = currentNumber;
                currentNumber = scanner.nextInt();
            }

            // Print the result
            System.out.println(ascendingOrder ^ descendingOrder);
        }
    }
}
