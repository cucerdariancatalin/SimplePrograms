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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit tests for the {@link CommonDenominators}.
 *
 * @author VitasSalvantes
 * @version 1.0.0
 */
class CommonDenominatorsTest {

    private int[][] fractions;

    @Test
    @DisplayName("Make denominators of the valid fractions common")
    void makeDenominatorsCommon() {
        fractions = new int[][]{{1, 2}};
        String expectedOutput = "(1,2)";
        assertEquals(expectedOutput, CommonDenominators.makeDenominatorsCommon(fractions));

        fractions = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        expectedOutput = "(30,60)(40,60)(45,60)(48,60)";
        assertEquals(expectedOutput, CommonDenominators.makeDenominatorsCommon(fractions));

        fractions = new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}};
        expectedOutput = "(1,1)(1,1)(1,1)(1,1)";
        assertEquals(expectedOutput, CommonDenominators.makeDenominatorsCommon(fractions));

        fractions = new int[][]{{1, 3}, {2, 3}};
        expectedOutput = "(1,3)(2,3)";
        assertEquals(expectedOutput, CommonDenominators.makeDenominatorsCommon(fractions));

        fractions = new int[][]{{10, 20}, {200, 300}, {6, 8}, {1, 6}};
        expectedOutput = "(6,12)(8,12)(9,12)(2,12)";
        assertEquals(expectedOutput, CommonDenominators.makeDenominatorsCommon(fractions));
    }

    @Test
    @DisplayName("Make denominators of the invalid fractions common")
    void makeDenominatorsCommonInvalidFractions() {
        fractions = null;
        assertThrows(IllegalArgumentException.class, () -> CommonDenominators.makeDenominatorsCommon(fractions));

        fractions = new int[][]{};
        assertThrows(IllegalArgumentException.class, () -> CommonDenominators.makeDenominatorsCommon(fractions));

        fractions = new int[][]{null};
        assertThrows(IllegalArgumentException.class, () -> CommonDenominators.makeDenominatorsCommon(fractions));

        fractions = new int[][]{{}};
        assertThrows(IllegalArgumentException.class, () -> CommonDenominators.makeDenominatorsCommon(fractions));

        fractions = new int[][]{{1}};
        assertThrows(IllegalArgumentException.class, () -> CommonDenominators.makeDenominatorsCommon(fractions));

        fractions = new int[][]{{1, 2, 3}};
        assertThrows(IllegalArgumentException.class, () -> CommonDenominators.makeDenominatorsCommon(fractions));

        fractions = new int[][]{{1, 0}};
        assertThrows(IllegalArgumentException.class, () -> CommonDenominators.makeDenominatorsCommon(fractions));
    }
}
