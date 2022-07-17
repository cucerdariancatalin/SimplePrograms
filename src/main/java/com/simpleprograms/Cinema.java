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

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

/**
 * Simple program to find the suitable row in the cinema.
 *
 * @author VitasSalvantes
 * @version 2.0.3
 */
public class Cinema {

    /**
     * The representation of the cinema current state.<br>
     * The sold seats are marked with "0", free seats - with "1".
     */
    private final int[][] seats;

    /**
     * The default constructor sets the value of the {@link #seats}.
     *
     * @param seats the value of the {@link #seats}.
     */
    public Cinema(final int @NotNull [] @NotNull [] seats) {
        validateSeats(seats);

        this.seats = seats.clone();
    }

    /**
     * The getter for the {@link #seats}.
     *
     * @return a copy of the {@link #seats}.
     */
    public int @NotNull [] @NotNull [] getSeats() {
        return seats.clone();
    }

    /**
     * Validates seats.
     *
     * @param seats the value to be validated.
     */
    private void validateSeats(final int[][] seats) {
        if (seats == null) {
            throw new IllegalArgumentException("The seats must not be null");
        }

        for (int[] row : seats) {
            if (row == null) {
                throw new IllegalArgumentException("The row must not be null");
            }

            for (int seat : row) {
                if (seat != 0 && seat != 1) {
                    throw new IllegalArgumentException("The seat must be either 1 or 0");
                }
            }
        }
    }

    /**
     * Finds the row which contains a desired number of hte consecutive seats.
     *
     * @param consecutiveSeatsNumber the desired number of the consecutive seats.
     * @return the number of the first found suitable row or 0 if the row was not found.
     */
    public int findConsecutiveAvailableSeats(final int consecutiveSeatsNumber) {
        int freeSeats = 0;

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 0) {
                    freeSeats++;

                    if (freeSeats == consecutiveSeatsNumber) {
                        return i + 1;
                    }
                } else {
                    freeSeats = 0;
                }
            }

            freeSeats = 0;
        }

        return 0;
    }

    /**
     * The example of using the program.
     */
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final int rowsNumber = scanner.nextInt();
        final int seatsNumber = scanner.nextInt();
        int[][] seats = new int[rowsNumber][seatsNumber];

        for (int i = 0; i < rowsNumber; i++) {
            for (int j = 0; j < seatsNumber; j++) {
                seats[i][j] = scanner.nextInt();
            }
        }

        final Cinema cinema = new Cinema(seats);
        final int ticketsNumber = scanner.nextInt();
        seats = cinema.getSeats();

        for (int[] row : seats) {
            for (int seatIndex = 0; seatIndex < row.length; seatIndex++) {
                final char splitter = (seatIndex == row.length - 1) ? '\n' : ' ';

                System.out.printf("%d%c", row[seatIndex], splitter);
            }
        }

        System.out.println(cinema.findConsecutiveAvailableSeats(ticketsNumber));
    }
}
