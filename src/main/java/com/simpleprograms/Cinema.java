package com.simpleprograms;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

/**
 * Simple program to find the suitable row in the cinema.
 *
 * @author VitasSalvantes
 * @version 2.0
 */
public class Cinema {

    /**
     * The representation of the cinema current state.<br>
     * The sold seats are marked with "0", free seats - with "1".
     */
    private int[][] seats;

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
     * The setter for the {@link #seats}.
     *
     * @param seats a new value of the {@link #seats}.
     */
    public void setSeats(int @NotNull [] @NotNull [] seats) {
        validateSeats(seats);

        this.seats = seats.clone();
    }

    /**
     * Validates seats.
     *
     * @param seats the value to be validated.
     * @throws IllegalArgumentException if the value either is null or contains null or unsuitable number.
     */
    private void validateSeats(final int[][] seats) throws IllegalArgumentException {
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
