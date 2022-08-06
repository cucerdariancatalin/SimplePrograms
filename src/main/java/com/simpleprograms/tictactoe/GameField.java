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
import org.jetbrains.annotations.Nullable;

/**
 * The game field of the Tic-Tac-Toe game.
 *
 * @author Ivan Bobrov
 * @version 1.0.4
 */
public class GameField {

    /**
     * The character of the empty game field cell.
     */
    final private char INITIAL_CHAR;

    /**
     * The length of a column and of a row of the game field.<br>
     * The size of the game field is DIMENSION_SIZE * DIMENSION_SIZE.
     */
    final private int DIMENSION_SIZE;

    /**
     * The state of the game field.
     */
    final private char @NotNull [] @NotNull [] state;

    /**
     * The number of the game field updates.
     */
    private int updatesNumber;



    /**
     * Sets default values of the fields.
     *
     * @param dimensionSize a default value of the {@link GameField#DIMENSION_SIZE}. It must be greater than 2.
     */
    public GameField(final int dimensionSize) {
        validateDimensionSize(dimensionSize);

        updatesNumber = 0;
        INITIAL_CHAR = ' ';
        DIMENSION_SIZE = dimensionSize;
        state = new char[dimensionSize][dimensionSize];

        for (int i = 0; i < dimensionSize; i++) {
            for (int j = 0; j < dimensionSize; j++) {
                state[i][j] = INITIAL_CHAR;
            }
        }
    }

    /**
     * The getter for the {@link GameField#DIMENSION_SIZE}.
     *
     * @return the size of the game field dimension.
     */
    public int getDimensionSize() {
        return DIMENSION_SIZE;
    }

    /**
     * The getter for the {@link GameField#state}.
     *
     * @return a copy of the game field state.
     */
    public char @NotNull [] @NotNull [] getState() {
        return state.clone();
    }

    /**
     * The getter for the {@link GameField#updatesNumber}.
     *
     * @return the number of the game field updates.
     */
    public int getUpdateNumber() {
        return updatesNumber;
    }



    /**
     * Validates a game field size.
     *
     * @param gameFieldSize the game field size to be validated.
     */
    private void validateDimensionSize(final int gameFieldSize) {
        if (gameFieldSize < 3) {
            throw new IllegalArgumentException("The size of the game field must be greater than 2");
        }
    }

    @Override
    public @NotNull String toString() {
        final StringBuilder stringGameField = new StringBuilder();
        final String horizontalBorder = "-".repeat(DIMENSION_SIZE * 2 + 3);

        // The top border
        stringGameField.append(horizontalBorder).append("\n");

        // Rows
        for (char[] row : state) {
            // The left border
            stringGameField.append("| ");

            // A row
            for (char character : row) {
                stringGameField.append(character).append(" ");
            }

            // The right border
            stringGameField.append("|\n");
        }

        // The bottom border
        stringGameField.append(horizontalBorder);

        return stringGameField.toString();
    }

    /**
     * Updates the game field.
     *
     * @param coordinates the coordinates of the game field cell to be updated. They must not be less than 0 and greater than or equal to the {@link GameField#DIMENSION_SIZE}.
     * @param character   the character to be written into the game field cell. It must not equal to the {@link GameField#INITIAL_CHAR}.
     *
     * @return the boolean true if the game field was successfully updated or the boolean false otherwise.
     */
    public boolean update(final int @NotNull [] coordinates, final char character) {
        validateCoordinates(coordinates);
        validateCharacter(character);

        if (state[coordinates[0]][coordinates[1]] != INITIAL_CHAR) {
            return false;
        } else {
            updatesNumber++;
            state[coordinates[0]][coordinates[1]] = character;

            return true;
        }
    }

    /**
     * Validates a character.
     *
     * @param character the character to be validated.
     */
    private void validateCharacter(final char character) {
        if (character == INITIAL_CHAR) {
            throw new IllegalArgumentException("The character must not equal to the initial character of the game field");
        }
    }

    /**
     * Validates coordinates.
     *
     * @param coordinates the coordinates to be validated.
     */
    private void validateCoordinates(final int @Nullable [] coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("The coordinates must not be null");
        }

        if (coordinates.length == 0) {
            throw new IllegalArgumentException("The coordinates must not be empty");
        }

        if (coordinates.length != 2) {
            throw new IllegalArgumentException("There are must be only 2 coordinates");
        }

        for (int coordinate : coordinates) {
            if (coordinate < 0) {
                throw new IllegalArgumentException("The coordinate must not be less than 0");
            }

            if (coordinate >= DIMENSION_SIZE) {
                throw new IllegalArgumentException(
                        "The coordinate must not be neither greater than nor equal to the size of the game field");
            }
        }
    }

    /**
     * Checks if the game field is full.
     *
     * @return the boolean true if the game field is full or the boolean false otherwise.
     */
    public boolean isFull() {
        return updatesNumber == DIMENSION_SIZE * DIMENSION_SIZE;
    }

    /**
     * Checks if a coordinate is out of the range from 0 to the {@link GameField#DIMENSION_SIZE}.
     *
     * @param coordinate the coordinate to be checked.
     *
     * @return the boolean true if the coordinate is out of the range or the boolean false otherwise.
     */
    public boolean isCoordinateOutOfRange(final int coordinate) {
        return coordinate < 0 || coordinate >= DIMENSION_SIZE;
    }

}
