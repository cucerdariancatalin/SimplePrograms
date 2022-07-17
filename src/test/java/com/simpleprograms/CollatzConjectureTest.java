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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit tests for the {@link CollatzConjecture}.
 *
 * @author VitasSalvantes
 * @version 1.0.0
 */
class CollatzConjectureTest {

    @Test
    @DisplayName("Compute the sequence starting with a valid integer")
    void compute() {
        List<Integer> expectedOutput = List.of(1);
        assertEquals(expectedOutput, CollatzConjecture.compute(1));

        expectedOutput = List.of(2, 1);
        assertEquals(expectedOutput, CollatzConjecture.compute(2));

        expectedOutput = List.of(3, 10, 5, 16, 8, 4, 2, 1);
        assertEquals(expectedOutput, CollatzConjecture.compute(3));

        expectedOutput = List.of(12, 6, 3, 10, 5, 16, 8, 4, 2, 1);
        assertEquals(expectedOutput, CollatzConjecture.compute(12));

        expectedOutput = List.of(19, 58, 29, 88, 44, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1);
        assertEquals(expectedOutput, CollatzConjecture.compute(19));

        expectedOutput = List.of(34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1);
        assertEquals(expectedOutput, CollatzConjecture.compute(34));
    }

    @Test
    @DisplayName("Compute the sequence starting with an invalid integer")
    void computeInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> CollatzConjecture.compute(0));
        assertThrows(IllegalArgumentException.class, () -> CollatzConjecture.compute(-1));
    }
}
