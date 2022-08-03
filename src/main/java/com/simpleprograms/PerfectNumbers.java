/*
 * MIT License
 *
 * Copyright (c) 2022 Ivan Bobrov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to
 * whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.simpleprograms;

/**
 * The program creates a sequence of perfect numbers.
 *
 * @author Ivan Bobrov
 * @version 2.1.2
 */
public class PerfectNumbers {

    /**
     * Prints a perfect number sequence.<br>
     * Attention! It takes a lot of time to display more than 4 numbers!
     *
     * @param quantity the quantity of perfect numbers to be printed.
     *                 It must be greater than 0.
     */
    public static void printPerfectNumbers(int quantity) {
        validateQuantity(quantity);

        long perfectNumberCandidate = 1L;

        while (quantity > 0) {
            long sum = 0;

            for (long divisorCandidate = 1L; divisorCandidate < perfectNumberCandidate; divisorCandidate++) {
                if (perfectNumberCandidate % divisorCandidate == 0) {
                    sum += divisorCandidate;
                }
            }

            if (sum == perfectNumberCandidate) {
                quantity--;
                System.out.printf("%d%s", perfectNumberCandidate, quantity == 0 ? "\n" : ", ");
            }

            perfectNumberCandidate++;
        }
    }

    /**
     * Validates a quantity.
     *
     * @param quantity the quantity to be validated.
     */
    private static void validateQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("The quantity must be greater than 0");
        }
    }



    /**
     * The example of using the program.
     */
    public static void main(String[] args) {
        PerfectNumbers.printPerfectNumbers(4);
    }

}
