package com.simpleprograms;

import org.jetbrains.annotations.NotNull;

/**
 * The program to reduce fractions to a common denominator.
 *
 * @author VitasSalvantes
 * @version 2.0.0
 */
public class CommonDenominators {

    /**
     * Calculates the common denominators of the given fractions.
     *
     * @param fractions the fractions to be processed. The fractions[n][0] is a numerator and the fractions[n][1] is a denominator, n >= 0.
     * @return the string containing the processed fractions.
     */
    public static @NotNull String makeDenominatorsCommon(final int @NotNull [] @NotNull [] fractions) {
        validateFractions(fractions);
        reduceFractions(fractions);

        final int commonDenominator = findCommonDenominator(fractions);

        for (int[] fraction : fractions) {
            //noinspection SuspiciousIntegerDivAssignment
            fraction[0] *= commonDenominator / fraction[1];
            fraction[1] = commonDenominator;
        }

        return convertFractionsToString(fractions);
    }

    /**
     * Validates fractions.
     *
     * @param fractions the fractions to be validated.
     */
    private static void validateFractions(final int[][] fractions) {
        if (fractions == null) {
            throw new IllegalArgumentException("The fractions must not be null");
        }

        if (fractions.length == 0) {
            throw new IllegalArgumentException("The fractions must not be empty");
        }

        for (int[] fraction : fractions) {
            if (fraction == null) {
                throw new IllegalArgumentException("Each fraction must not be null");
            }

            if (fraction.length != 2) {
                throw new IllegalArgumentException("Each fraction must have only both a numerator and a denominator");

            }

            if (fraction[1] == 0) {
                throw new IllegalArgumentException("The denominator must not be null");
            }
        }
    }

    /**
     * Reduces the fractions.
     *
     * @param fractions the fractions to be reduced.
     */
    private static void reduceFractions(final int @NotNull [] @NotNull [] fractions) {
        for (int[] fraction : fractions) {

            for (int i = 2; i <= Math.min(fraction[0], fraction[1]); i++) {
                while (fraction[0] % i == 0 && fraction[1] % i == 0) {
                    fraction[0] /= i;
                    fraction[1] /= i;
                }
            }
        }
    }

    /**
     * Finds the common denominator of fractions.
     *
     * @param fractions the fractions to be processed.
     * @return the common denominator.
     */
    private static int findCommonDenominator(int @NotNull [] @NotNull [] fractions) {
        int commonDenominatorCandidate = fractions[0][1];

        for (int i = 1; i < fractions.length; i++) {
            for (int multiplier = 2; commonDenominatorCandidate % fractions[i][1] != 0; multiplier++) {
                commonDenominatorCandidate *= multiplier;
            }
        }

        return commonDenominatorCandidate;
    }

    /**
     * Converts fractions to a string.
     *
     * @param fractions the fractions to be converted.
     * @return the string
     */
    private static @NotNull String convertFractionsToString(int @NotNull [] @NotNull [] fractions) {
        final StringBuilder fractionString = new StringBuilder();

        for (int[] fraction : fractions) {
            fractionString.append("(").append(fraction[0]).append(",").append(fraction[1]).append(")");
        }

        return fractionString.toString();
    }

    /**
     * The example of using the program.
     */
    public static void main(String[] args) {
        final int[][] listOfFractions = {{10, 20}, {200, 300}, {6, 8}, {1, 6}};
        System.out.printf("Fractions with a common denominator: %s%n", CommonDenominators.makeDenominatorsCommon(listOfFractions));
    }
}
