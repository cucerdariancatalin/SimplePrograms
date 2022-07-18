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

import java.math.BigInteger;

/**
 * Simple implementation of the Fibonacci numbers.
 *
 * @author VitasSalvantes
 * @version 2.0.4
 */
public class FibonacciNumbers {

    /**
     * Computes the Fibonacci numbers until the number with the given index.
     *
     * @param maxIndex the index of the last computed number.
     */
    public static void computeFibonacciNumbers(final int maxIndex) {
        validateIndex(maxIndex);

        BigInteger nextNumber = BigInteger.ZERO;
        BigInteger sum = BigInteger.ONE;

        for (int index = 1; index <= maxIndex; index++) {
            System.out.printf("%s%s", nextNumber, index == maxIndex ? "\n" : ", ");

            BigInteger currentNumber = nextNumber;
            nextNumber = sum;
            sum = sum.add(currentNumber);
        }
    }

    /**
     * Validates an input index.
     *
     * @param index the index to be validated.
     */
    private static void validateIndex(final int index) {
        if (index < 1) {
            throw new IllegalArgumentException("The index must be greater than 0");
        }
    }

    /**
     * The example of using the program.
     */
    public static void main(String[] args) {
        FibonacciNumbers.computeFibonacciNumbers(100);
    }
}
