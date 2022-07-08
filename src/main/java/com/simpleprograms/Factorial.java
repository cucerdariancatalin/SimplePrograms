/*
 * MIT License
 *
 * Copyright (c) 2022 VitasSalvantes
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.simpleprograms;

/**
 * Class-example of factorial implementation.
 *
 * @author VitasSalvantes
 * @version 3.1.0
 */
public class Factorial {

    /**
     * Calculates the factorial of the positive number.
     *
     * @param number the positive number.
     * @return the factorial.
     */
    public static int calculateFactorial(int number) {
        validateNumber(number);

        int factorial = 1;

        while (number > 1) {
            factorial *= number;
            number--;
        }

        return factorial;
    }

    /**
     * Validates a number.
     *
     * @param number the number to be validated.
     */
    private static void validateNumber(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException("The number must not be negative");
        }
    }

    /**
     * The example of using the program
     */
    public static void main(String[] args) {
        System.out.println(Factorial.calculateFactorial(4));
    }
}
