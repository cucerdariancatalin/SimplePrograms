package com.simpleprograms;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple implementation of the Collatz conjecture.
 *
 * @author VitasSalvantes
 * @version 2.0.0
 */
public class CollatzConjecture {

    /**
     * Computes the integer sequence until the computed integer equals 1.
     *
     * @param initialInteger the initial integer to start computation with.
     * @return the list of the computed integers.
     */
    public static List<Integer> compute(final int initialInteger) {
        validateInteger(initialInteger);

        int currentInteger = initialInteger;
        final List<Integer> integerSequence = new ArrayList<>();
        integerSequence.add(initialInteger);

        while (currentInteger > 1) {
            if (currentInteger % 2 == 0) {
                currentInteger /= 2;
            } else {
                currentInteger = currentInteger * 3 + 1;
            }

            integerSequence.add(currentInteger);
        }

        return integerSequence;
    }

    /**
     * Validates an integer. It must be greater than 0.
     *
     * @param initialInteger the integer to be validated.
     */
    private static void validateInteger(final int initialInteger) {
        if (initialInteger < 1) {
            throw new IllegalArgumentException("The initial integer must be greater than 0");
        }
    }

    /**
     * The example of using the program.
     */
    public static void main(String[] args) {
        final List<Integer> integerSequence = CollatzConjecture.compute(34);

        System.out.println(integerSequence);
    }
}
