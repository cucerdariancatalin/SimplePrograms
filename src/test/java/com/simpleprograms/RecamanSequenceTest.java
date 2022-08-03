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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit tests for the {@link RecamanSequence}.
 *
 * @author Ivan Bobrov
 * @version 1.0.0
 */
class RecamanSequenceTest {

    @Test
    @DisplayName("Print the Recaman's sequence")
    void printRecamanSequence() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        RecamanSequence.printRecamanSequence(1);
        assertEquals("0\n", outputStreamCaptor.toString());

        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        RecamanSequence.printRecamanSequence(40);
        assertEquals(
                "0, 1, 3, 6, 2, 7, 13, 20, 12, 21, 11, 22, 10, 23, 9, 24, 8, 25, 43, 62, 42, 63, 41, 18, 42, " +
                "17, 43, 16, 44, 15, 45, 14, 46, 79, 113, 78, 114, 77, 39, 78\n",
                outputStreamCaptor.toString()
        );
    }

    @Test
    @DisplayName("Print an invalid quantity of the Recaman's sequence elements")
    void printRecamanSequenceInvalidQuantity() {
        for (int i = -10; i < 1; i++) {
            final int finalI = i;
            assertThrows(IllegalArgumentException.class, () -> RecamanSequence.printRecamanSequence(finalI));
        }
    }

}
