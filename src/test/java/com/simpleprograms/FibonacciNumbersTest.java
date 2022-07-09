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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit tests for the {@link FibonacciNumbers}.
 *
 * @author VitasSalvantes
 * @version 1.0.0
 */
class FibonacciNumbersTest {

    @Test
    @DisplayName("Compute the Fibonacci numbers until the valid given index")
    void computeFibonacciNumbers() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        FibonacciNumbers.computeFibonacciNumbers(1);
        assertEquals("0\n", outputStreamCaptor.toString());

        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        FibonacciNumbers.computeFibonacciNumbers(2);
        assertEquals("0, 1\n", outputStreamCaptor.toString());

        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        FibonacciNumbers.computeFibonacciNumbers(10);
        assertEquals("0, 1, 1, 2, 3, 5, 8, 13, 21, 34\n", outputStreamCaptor.toString());
    }

    @Test
    @DisplayName("Compute the Fibonacci numbers until the invalid given index")
    void computeFibonacciNumbersInvalidIndex() {
        assertThrows(IllegalArgumentException.class, () -> FibonacciNumbers.computeFibonacciNumbers(0));
        assertThrows(IllegalArgumentException.class, () -> FibonacciNumbers.computeFibonacciNumbers(-1));
    }
}
