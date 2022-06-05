package com.SimplePrograms;

import java.util.Scanner;

/**
 * Simple program to find the suitable row in the cinema.
 *
 * @author VitasSalvantes
 * @version 1.0
 */
public class Cinema {
    public static void main(String[] args) {
        // The Scanner object to get the user input
        Scanner scanner = new Scanner(System.in);

        // The number of rows in the cinema
        int rows = scanner.nextInt();

        // The number of seats in the row
        int seats = scanner.nextInt();

        // The two-dimensional array representing all seat in the cinema
        int[][] cinemaSeats = new int[rows][seats];

        // The number of free seats in the row
        int freeSeats = 1;

        // The suitable row
        int luckyRow = 0;

        // Obtaining information about free seats from the user and filling the cinemaSeats array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinemaSeats[i][j] = scanner.nextInt();
            }
        }

        // The number of free neighbouring seats to find
        int tickets = scanner.nextInt();

        // Look for the suitable row with free neighboring seats
        SearchingFreeSeats:
        for (int i = 0; i < cinemaSeats.length; i++) {
            for (int j = 1; j < cinemaSeats[i].length; j++) {
                if (cinemaSeats[i][j] == 0 && cinemaSeats[i][j] == cinemaSeats[i][j - 1]) {
                    freeSeats++;
                } else {
                    freeSeats = 1;
                }

                // If the suitable row is founded, stop the loop
                if (freeSeats == tickets) {
                    luckyRow = i + 1;
                    break SearchingFreeSeats;
                }
            }

            // Set the number to default before checking the next row
            freeSeats = 1;
        }

        // Print the number of the suitable row
        System.out.println(luckyRow);
    }
}
