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
 * JUnit tests for the {@link PerfectNumbers}.
 *
 * @author Ivan Bobrov
 * @version 1.0.0
 */
class PerfectNumbersTest {

    @Test
    @DisplayName("Print perfect numbers")
    void printPerfectNumbers() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        PerfectNumbers.printPerfectNumbers(1);
        assertEquals("6\n", outputStreamCaptor.toString());

        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        PerfectNumbers.printPerfectNumbers(2);
        assertEquals("6, 28\n", outputStreamCaptor.toString());

        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        PerfectNumbers.printPerfectNumbers(3);
        assertEquals("6, 28, 496\n", outputStreamCaptor.toString());

        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        PerfectNumbers.printPerfectNumbers(4);
        assertEquals("6, 28, 496, 8128\n", outputStreamCaptor.toString());
    }

    @Test
    @DisplayName("Print an invalid quantity of perfect numbers")
    void printPerfectNumbersInvalidQuantity() {
        for (int i = -10; i < 1; i++) {
            final int finalI = i;
            assertThrows(IllegalArgumentException.class, () -> PerfectNumbers.printPerfectNumbers(finalI));
        }
    }

}
