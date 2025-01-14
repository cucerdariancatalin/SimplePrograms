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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit tests for the {@link TicTacToe}.
 *
 * @author Ivan Bobrov
 * @version 1.0.0
 */
class TicTacToeTest {

    private TicTacToe testTicTacToe;



    @BeforeEach
    void setUp() {
        testTicTacToe = new TicTacToe(3, "X", 'X', "O", 'O');
    }



    @Test
    @DisplayName("Run")
    void run() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        final Scanner scanner = new Scanner(
                """
                2 2
                2 2
                two two
                1 4
                1 1
                3 3
                2 1
                3 1
                2 3
                3 2"""
        );
        testTicTacToe.run(scanner);

        String expectedOutput = """
                                ---------
                                |       |
                                |       |
                                |       |
                                ---------
                                ---------
                                |       |
                                |   X   |
                                |       |
                                ---------
                                This cell is occupied! Choose another one!
                                You should enter numbers!
                                Coordinates should be from 1 to 3!
                                ---------
                                | O     |
                                |   X   |
                                |       |
                                ---------
                                ---------
                                | O     |
                                |   X   |
                                |     X |
                                ---------
                                ---------
                                | O     |
                                | O X   |
                                |     X |
                                ---------
                                ---------
                                | O     |
                                | O X   |
                                | X   X |
                                ---------
                                ---------
                                | O     |
                                | O X O |
                                | X   X |
                                ---------
                                ---------
                                | O     |
                                | O X O |
                                | X X X |
                                ---------
                                X wins
                                """;

        assertEquals(expectedOutput, outputStreamCaptor.toString().replaceAll(System.lineSeparator(), "\n"));
    }

    @Test
    @DisplayName("Run invalid")
    void runInvalid() {
        //noinspection ConstantConditions
        assertThrows(IllegalArgumentException.class, () -> testTicTacToe.run(null));
    }

}
