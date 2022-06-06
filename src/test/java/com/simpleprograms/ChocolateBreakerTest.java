package com.simpleprograms;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @AfterEach
    void tearDown() {
        testChocolateLength = 0;
        testChocolateWidth = 0;
        chocolateBreaker = null;
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
        assertThrows(IllegalArgumentException.class, () -> new ChocolateBreaker(testChocolateLength, testChocolateWidth));

        testChocolateLength = testChocolateWidth;
        testChocolateWidth = 0;
        assertThrows(IllegalArgumentException.class, () -> new ChocolateBreaker(testChocolateLength, testChocolateWidth));

        testChocolateLength = testChocolateWidth;
        assertThrows(IllegalArgumentException.class, () -> new ChocolateBreaker(testChocolateLength, testChocolateWidth));
    }
}