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

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Simple implementation of the Tic-Tac-Toe game.
 *
 * @author Ivan Bobrov
 * @version 2.0.0
 */
public class TicTacToe {

    /**
     * The game field.
     */
    final GameField gameField;

    /**
     * The first player.
     */
    final @NotNull Player player1;

    /**
     * The second player.
     */
    final @NotNull Player player2;

    /**
     * Sets default values of the fields.
     *
     * @param dimensionalSize the size of a game field dimension.
     * @param player1Name     the name of the first player.
     * @param player1GameChar the character the first player makes a move with.
     * @param player2Name     the name of the second player.
     * @param player2GameChar the character the second player makes a move with.
     */
    public TicTacToe(
            final int dimensionalSize,
            final @NotNull String player1Name,
            final char player1GameChar,
            final @NotNull String player2Name,
            final char player2GameChar
    ) {
        gameField = new GameField(dimensionalSize);
        player1 = new Player(player1Name, player1GameChar);
        player2 = new Player(player2Name, player2GameChar);
    }

    /**
     * Runs the game.
     *
     * @param scanner a scanner object to get the user input.
     */
    public void run(final @NotNull Scanner scanner) {
        System.out.println(gameField);

        while (true) {
            final Player currentPlayer = gameField.getUpdateNumber() % 2 == 0 ? player1 : player2;

            currentPlayer.makeMove(scanner, gameField);

            System.out.println(gameField);

            if (isGameOver(currentPlayer.getGameChar())) {
                System.out.printf("%s wins%n", currentPlayer.getName());
                break;
            } else if (gameField.isFull()) {
                System.out.println("Draw");
                break;
            }
        }
    }

    /**
     * Checks if the game is over.
     *
     * @param playerGameChar the game character of the current player.
     *
     * @return the boolean true if the game is over or the boolean false otherwise.
     */
    private boolean isGameOver(final char playerGameChar) {
        final char[] winCombination = new char[gameField.getDimensionSize()];
        Arrays.fill(winCombination, playerGameChar);

        final int dimensionalSize = gameField.getDimensionSize();
        final char[][] state = gameField.getState();
        final char[][] rotatedState = new char[dimensionalSize][dimensionalSize];
        for (int i = 0; i < rotatedState.length; i++) {
            for (int j = 0; j < rotatedState[i].length; j++) {
                rotatedState[i][j] = state[state.length - j - 1][i];
            }
        }

        return isStateFinal(state, winCombination) || isStateFinal(rotatedState, winCombination);
    }

    /**
     * Checks if a state is final.
     *
     * @param state          the state to be checked.
     * @param winCombination the win combination the final state must contain.
     *
     * @return the boolean true if the state is final or the boolean false otherwise.
     */
    private boolean isStateFinal(final char[][] state, final char[] winCombination) {
        for (char[] row : state) {
            if (Arrays.equals(winCombination, row)) {
                return true;
            }
        }

        char[] diagonal = new char[gameField.getDimensionSize()];

        for (int i = 0; i < state.length; i++) {
            diagonal[i] = state[i][i];
        }

        return Arrays.equals(winCombination, diagonal);
    }



    /**
     * The example of using the program.
     */
    public static void main(String[] args) {
        final TicTacToe ticTacToe = new TicTacToe(3, "X", 'X', "O", 'O');
        ticTacToe.run(new Scanner(System.in));
    }

}
