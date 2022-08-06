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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for the {@link Player}.
 *
 * @author Ivan Bobrov
 * @version 1.0.0
 */
class PlayerTest {

    private Player testPlayer;

    @BeforeEach
    void setUp() {
        testPlayer = new Player("Player", 'X');
    }

    @Test
    @DisplayName("Test constructor")
    void testConstructor() {
        //noinspection ConstantConditions
        assertThrows(IllegalArgumentException.class, () -> new Player(null, 'X'));
        assertThrows(IllegalArgumentException.class, () -> new Player("", 'X'));
        assertThrows(IllegalArgumentException.class, () -> new Player("   ", 'X'));
    }

    @Test
    @DisplayName("Get the player's name")
    void getName() {
        assertEquals("Player", testPlayer.getName());
    }

    @Test
    @DisplayName("Get the player's game character")
    void getGameChar() {
        assertEquals('X', testPlayer.getGameChar());
    }

    @Test
    @DisplayName("Make a move")
    void makeMove() {
        final GameField gameField = new GameField(3);
        final char[][] expectedState = gameField.getState();

        for (int i = 0; i < gameField.getDimensionSize(); i++) {
            for (int j = 0; j < gameField.getDimensionSize(); j++) {
                final Scanner scanner = new Scanner(String.format("%d %d", i + 1, j + 1));
                testPlayer.makeMove(scanner, gameField);

                expectedState[i][j] = testPlayer.getGameChar();

                assertTrue(Arrays.deepEquals(expectedState, gameField.getState()));
            }
        }
    }

    @Test
    @DisplayName("Make an invalid move")
    void makeMoveInvalid() {
        //noinspection ConstantConditions
        assertThrows(IllegalArgumentException.class, () -> testPlayer.makeMove(null, new GameField(3)));
        //noinspection ConstantConditions
        assertThrows(IllegalArgumentException.class, () -> testPlayer.makeMove(new Scanner("Scanner"), null));
    }

}
