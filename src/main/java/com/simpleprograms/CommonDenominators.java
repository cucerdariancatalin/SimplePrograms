package com.simpleprograms;

/**
 * A program for reducing fractions to a common denominator
 *
 * @author VitasSalvantes
 * @version 1.0
 */
public class CommonDenominators {

    /**
     * Method that launches the program
     */
    public static void main(String[] args) {
        CommonDenominators cd = new CommonDenominators();
        int[][] listOfFractions = {{10, 20}, {200, 300}, {6, 8}, {1, 6}};

        String output = cd.getCommonDenominators(listOfFractions);
        System.out.println("Fractions with a common denominator: " + output);
    }

    /**
     * A method that simplifies the original fractions (abbreviates by multiples of 10 and the first 100 primes)
     */
    private int[][] reduceFractions(int[][] listOfFractions) {
        for (int[] fraction : listOfFractions) {
            int[] primeNumbers = createPrimeNumbers();

            while (fraction[0] % 10 == 0 && fraction[1] % 10 == 0) {
                fraction[0] /= 10;
                fraction[1] /= 10;
            }

            for (int i = 0; i < primeNumbers.length; ) {
                if (fraction[0] % primeNumbers[i] == 0 && fraction[1] % primeNumbers[i] == 0) {
                    fraction[0] /= primeNumbers[i];
                    fraction[1] /= primeNumbers[i];
                    continue;
                }

                i++;
            }
        }

        return listOfFractions;
    }

    /**
     * Method for creating array containing 100 prime numbers
     */
    private int[] createPrimeNumbers() {
        int[] primeNumbers = new int[100];
        int quantity = 100;
        int number = 2;
        int element = 0;

        while (quantity > 0) {

            for (int i = 2; i <= number; i++) {

                if (number % i == 0 && number != i) {
                    break;
                }

                if (number == i) {
                    primeNumbers[element] = number;
                    element++;
                    quantity--;
                }
            }

            number++;
        }
        return primeNumbers;
    }

    /**
     * A method that finds the least common multiple of all denominators
     */
    private int findLeastCommonMultipleForDenominators(int[][] listOfFractions) {
        int oldLeastCommonMultiple = 1, newLeastCommonMultiple = 1, counter = 2;

        for (int[] fraction : listOfFractions) {
            while (newLeastCommonMultiple % fraction[1] != 0) {
                newLeastCommonMultiple = oldLeastCommonMultiple;
                newLeastCommonMultiple *= counter;
                counter++;
            }
            oldLeastCommonMultiple = newLeastCommonMultiple;
            counter = 2;
        }

        return oldLeastCommonMultiple;
    }

    /**
     * A method that returns fractions, converting to a common denominator, as a string
     */
    public String getCommonDenominators(int[][] listOfFractions) {
        StringBuilder formattedOutput = new StringBuilder();
        listOfFractions = reduceFractions(listOfFractions);
        int leastCommonMultipleForDenominators = findLeastCommonMultipleForDenominators(listOfFractions);

        System.out.println("Least common multiple for the denominators of fractions: " + leastCommonMultipleForDenominators);

        for (int[] fraction : listOfFractions) {
            int numerator = fraction[0] * leastCommonMultipleForDenominators / fraction[1];
            int denominator = leastCommonMultipleForDenominators;
            formattedOutput.append("(").append(numerator).append(",").append(denominator).append(")");
        }

        return formattedOutput.toString();
    }
}