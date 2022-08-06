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

import java.util.Scanner;

/**
 * The player of the Tic-Tac-Toe game.
 *
 * @author Ivan Bobrov
 * @version 1.0.2
 */
public class Player {

    /**
     * The name of a player.
     */
    private final @NotNull String name;

    /**
     * The character the player marks a move.
     */
    private final char gameChar;



    /**
     * Sets default values of the fields.
     *
     * @param name     the default value of the {@link Player#name}. It must not be neither null nor blank.
     * @param gameChar the default value of the {@link Player#gameChar}.
     */
    public Player(final @NotNull String name, final char gameChar) {
        validateName(name);

        this.name = name;
        this.gameChar = gameChar;
    }

    /**
     * Validates a name.
     *
     * @param name the name to be validated.
     */
    private void validateName(final @Nullable String name) {
        if (name == null) {
            throw new IllegalArgumentException("The player name must not be null");
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException("The player name must not be blank");
        }
    }

    /**
     * The getter for the {@link Player#name}.
     *
     * @return the name of the player.
     */
    public @NotNull String getName() {
        return name;
    }

    /**
     * The getter for the {@link Player#gameChar}.
     *
     * @return the game character of the player.
     */
    public char getGameChar() {
        return gameChar;
    }



    /**
     * Makes a player move.
     *
     * @param scanner   a scanner object to read the user input.
     * @param gameField the game field.
     */
    public void makeMove(final @NotNull Scanner scanner, final @NotNull GameField gameField) {
        validateScanner(scanner);
        validateGameField(gameField);

        while (true) {
            final String move = scanner.nextLine();

            if (!move.matches("\\d+ \\d+")) {
                System.out.println("You should enter numbers!");
            } else {
                final String[] moveArray = move.split(" ");
                final int[] coordinates = new int[2];
                coordinates[0] = Integer.parseInt(moveArray[0]) - 1;
                coordinates[1] = Integer.parseInt(moveArray[1]) - 1;

                if (gameField.isCoordinateOutOfRange(coordinates[0]) ||
                    gameField.isCoordinateOutOfRange(coordinates[1])) {
                    System.out.printf("Coordinates should be from 1 to %d!%n", gameField.getDimensionSize());
                } else if (!gameField.update(coordinates, gameChar)) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Validates a scanner object.
     *
     * @param scanner the scanner object to be validated.
     */
    private void validateScanner(final @Nullable Scanner scanner) {
        if (scanner == null) {
            throw new IllegalArgumentException("The scanner object must not be null");
        }
    }

    /**
     * Validates a game field.
     *
     * @param gameField the game field to be validated.
     */
    private void validateGameField(@Nullable GameField gameField) {
        if (gameField == null) {
            throw new IllegalArgumentException("The game field must not be null");
        }
    }

}
