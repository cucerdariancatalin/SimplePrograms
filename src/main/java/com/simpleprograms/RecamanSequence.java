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

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Simple implementation of the Recaman sequence.
 *
 * @author Ivan Bobrov
 * @version 1.6.1
 */

public class RecamanSequence {

    /**
     * Prints the Recaman's sequence.
     *
     * @param quantity the number of elements to be printed.
     */
    public static void printRecamanSequence(final int quantity) {
        validateQuantity(quantity);

        final var recamanSequence = new ArrayList<Integer>(quantity);
        recamanSequence.add(0);

        for (int i = 1; i < quantity; i++) {
            final int newElementCandidate = recamanSequence.get(i - 1) - i;
            recamanSequence.add(newElementCandidate > 0 && !recamanSequence.contains(newElementCandidate)
                                ? newElementCandidate
                                : recamanSequence.get(i - 1) + i);
        }

        final Iterator<Integer> iterator = recamanSequence.iterator();

        while (iterator.hasNext()) {
            System.out.printf("%d%s", iterator.next(), iterator.hasNext() ? ", " : "\n");
        }
    }

    /**
     * Validates a quantity.
     *
     * @param quantity the quantity to be validated.
     */
    private static void validateQuantity(final int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("The quantity must be greater than 0");
        }
    }



    /**
     * The example of using the program.
     */
    public static void main(String[] args) {
        RecamanSequence.printRecamanSequence(20);
    }

}
