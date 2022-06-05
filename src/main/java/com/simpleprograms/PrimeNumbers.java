package com.simpleprograms;

import java.util.Scanner;

/**
 * Class with methods for printing prime numbers
 *
 * @author VitasSalvantes
 * @version 1.5
 */
public class PrimeNumbers {

    /**
     * A Scanner class object that accepts user input
     */
    private Scanner scanner;

    /**
     * The number of prime numbers displayed
     */
    private int numberOfPrimes;

    /**
     * Method that launches the program
     */
    public static void main(String[] args) {
        PrimeNumbers pn = new PrimeNumbers();

        pn.setQuantity();
        System.out.println(pn.createPrimeNumbers());
    }

    /**
     * Method for creating strings containing prime numbers
     */
    public String createPrimeNumbers() {
        StringBuilder primesOutput = new StringBuilder();
        int number = 2;

        while (numberOfPrimes > 0) {

            for (int i = 2; i <= number; i++) {

                if (number % i == 0 && number != i) {
                    break;
                }

                if (number == i) {
                    primesOutput.append(number).append(" ");
                    numberOfPrimes--;
                }
            }

            number++;
        }
        return primesOutput.toString();
    }

    /**
     * Setter for {@link PrimeNumbers#numberOfPrimes}
     */
    public void setQuantity() {
        scanner = new Scanner(System.in);

        System.out.println("- Quantity?");
        numberOfPrimes = scanner.nextInt();
        scanner.close();
    }
}