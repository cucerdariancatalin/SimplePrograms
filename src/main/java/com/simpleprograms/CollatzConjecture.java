/*
 * MIT License
 *
 * Copyright (c) 2022 VitasSalvantes
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

import java.util.ArrayList;
import java.util.List;

/**
 * Simple implementation of the Collatz conjecture.
 *
 * @author VitasSalvantes
 * @version 2.0.1
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
