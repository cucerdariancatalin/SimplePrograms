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

package com.simpleprograms.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for the {@link GameField}.
 *
 * @author Ivan Bobrov
 * @version 1.0.0
 */
class GameFieldTest {

    private GameField testGameField;



    @BeforeEach
    void setUp() {
        testGameField = new GameField(3);
    }



    @Test
    void getDimensionSize() {
        assertEquals(3, testGameField.getDimensionSize());
    }

    @Test
    void getState() {
        final char[][] testState = testGameField.getState();
        assertTrue(Arrays.deepEquals(testState, testGameField.getState()));

        final char testGameChar = 'X';
        testGameField.update(new int[]{0, 0}, testGameChar);
        testState[0][0] = testGameChar;
        assertTrue(Arrays.deepEquals(testState, testGameField.getState()));
    }

    @Test
    void getUpdateNumber() {
        int testUpdateNumber = 0;
        assertEquals(testUpdateNumber, testGameField.getUpdateNumber());

        for (int i = 0; i < testGameField.getDimensionSize(); i++) {
            for (int j = 0; j < testGameField.getDimensionSize(); j++) {
                testUpdateNumber++;

                testGameField.update(new int[]{i, j}, 'X');

                assertEquals(testUpdateNumber, testGameField.getUpdateNumber());
            }
        }
    }

    @Test
    void testToString() {
        String expectedString = """
                                ---------
                                |       |
                                |       |
                                |       |
                                ---------""";
        assertEquals(expectedString, testGameField.toString());

        testGameField.update(new int[]{0, 0}, 'O');
        expectedString = """
                         ---------
                         | O     |
                         |       |
                         |       |
                         ---------""";
        assertEquals(expectedString, testGameField.toString());


        testGameField = new GameField(4);
        expectedString = """
                         -----------
                         |         |
                         |         |
                         |         |
                         |         |
                         -----------""";
        assertEquals(expectedString, testGameField.toString());
    }

    @Test
    void update() {
        final char[][] testState = testGameField.getState();
        assertTrue(Arrays.deepEquals(testState, testGameField.getState()));

        final char testGameChar = 'X';

        for (int i = 0; i < testGameField.getDimensionSize(); i++) {
            for (int j = 0; j < testGameField.getDimensionSize(); j++) {
                testGameField.update(new int[]{i, j}, testGameChar);
                testState[i][j] = testGameChar;

                assertTrue(Arrays.deepEquals(testState, testGameField.getState()));
            }
        }
    }

    @Test
    void isFull() {
        assertFalse(testGameField.isFull());

        for (int i = 0; i < testGameField.getDimensionSize(); i++) {
            for (int j = 0; j < testGameField.getDimensionSize(); j++) {
                testGameField.update(new int[]{i, j}, 'X');
                if (i != testGameField.getDimensionSize() - 1 && j != testGameField.getDimensionSize() - 1) {
                    assertFalse(testGameField.isFull());
                }
            }
        }

        assertTrue(testGameField.isFull());
    }

    @Test
    void isCoordinateOutOfRange() {
        for (int i = 3; i < 14; i++) {
            testGameField = new GameField(i);
            assertTrue(testGameField.isCoordinateOutOfRange(-1));

            for (int j = 0; j < i; j++) {
                assertFalse(testGameField.isCoordinateOutOfRange(j));
            }

            assertTrue(testGameField.isCoordinateOutOfRange(i));
        }
    }

}
