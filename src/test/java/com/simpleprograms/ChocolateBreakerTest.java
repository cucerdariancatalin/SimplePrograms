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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit tests for the {@link ChocolateBreaker}.
 *
 * @author Ivan Bobrov
 * @version 1.0.2
 */
class ChocolateBreakerTest {

    private ChocolateBreaker chocolateBreaker;
    private int testChocolateLength;
    private int testChocolateWidth;



    @BeforeEach
    void setUp() {
        testChocolateLength = 2;
        testChocolateWidth = 3;
        chocolateBreaker = new ChocolateBreaker(testChocolateLength, testChocolateWidth);
    }



    @Test
    @DisplayName("Constructor")
    void testConstructor() {
        testChocolateLength = 5;
        testChocolateWidth = 10;
        chocolateBreaker = new ChocolateBreaker(testChocolateLength, testChocolateWidth);

        assertEquals(testChocolateLength, chocolateBreaker.getChocolateLength());
        assertEquals(testChocolateWidth, chocolateBreaker.getChocolateWidth());
    }

    @Test
    @DisplayName("Length getter")
    void getChocolateLength() {
        chocolateBreaker = new ChocolateBreaker(testChocolateLength, testChocolateWidth);
        assertEquals(testChocolateLength, chocolateBreaker.getChocolateLength());
    }

    @Test
    @DisplayName("Length setter")
    void setChocolateLength() {
        testChocolateLength = 7;
        chocolateBreaker.setChocolateLength(testChocolateLength);
        assertEquals(testChocolateLength, chocolateBreaker.getChocolateLength());
    }

    @Test
    @DisplayName("Width getter")
    void getChocolateWidth() {
        chocolateBreaker = new ChocolateBreaker(testChocolateLength, testChocolateWidth);
        assertEquals(testChocolateWidth, chocolateBreaker.getChocolateWidth());
    }

    @Test
    @DisplayName("Width setter")
    void setChocolateWidth() {
        testChocolateWidth = 7;
        chocolateBreaker.setChocolateWidth(testChocolateLength);
        assertEquals(testChocolateLength, chocolateBreaker.getChocolateWidth());
    }

    @Test
    @DisplayName("Check if the break is possible")
    void checkBreakPossibility() {
        final var testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));

        chocolateBreaker.checkBreakPossibility(testChocolateLength);
        assertEquals("YES", testOut.toString().trim());

        testOut.reset();
        testChocolateLength = 12;
        chocolateBreaker.checkBreakPossibility(testChocolateLength);
        assertEquals("NO", testOut.toString().trim());

        System.setOut(System.out);
    }

    @Test
    @DisplayName("Wrong length or width")
    void testUnsuitableSize() {
        testChocolateLength = -1;
        assertThrows(
                IllegalArgumentException.class,
                () -> new ChocolateBreaker(testChocolateLength, testChocolateWidth)
        );

        testChocolateLength = testChocolateWidth;
        testChocolateWidth = 0;
        assertThrows(
                IllegalArgumentException.class,
                () -> new ChocolateBreaker(testChocolateLength, testChocolateWidth)
        );

        testChocolateLength = testChocolateWidth;
        assertThrows(
                IllegalArgumentException.class,
                () -> new ChocolateBreaker(testChocolateLength, testChocolateWidth)
        );
    }

}
