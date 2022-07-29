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
 * The implementation of the Euclidean algorithm for positive integers.
 *
 * @author Ivan Bobrov
 * @version 1.1.1
 */
public class EuclideanAlgorithm {

    /**
     * Calculates the greatest common divisor.
     *
     * @param firstInteger  an integer greater than 0.
     * @param secondInteger an integer greater than 0.
     * @return the greatest common divisor.
     */
    public static int calculateGCD(final int firstInteger, final int secondInteger) {
        validateInteger(firstInteger);
        validateInteger(secondInteger);

        int greatestNumber = Math.max(firstInteger, secondInteger);
        int leastNumber = Math.min(firstInteger, secondInteger);
        int remainder = greatestNumber % leastNumber;
        int gcdCandidate = leastNumber;

        while (remainder != 0) {
            gcdCandidate = remainder;
            greatestNumber = leastNumber;
            leastNumber = remainder;

            remainder = greatestNumber % leastNumber;
        }

        return gcdCandidate;
    }

    /**
     * Validates an integer.
     *
     * @param integer the integer to be validated.
     */
    private static void validateInteger(final int integer) {
        if (integer < 1) {
            throw new IllegalArgumentException("The integer must be greater than 0");
        }
    }

    /**
     * The example of using the program.
     */
    public static void main(String[] args) {
        System.out.println(EuclideanAlgorithm.calculateGCD(391, 544));
    }
}
