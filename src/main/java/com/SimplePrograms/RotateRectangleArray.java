package com.SimplePrograms;

import java.util.Scanner;

/**
 * Simple program to rotate a rectangle array by 90 degrees clockwise.
 *
 * @author VitasSalvantes
 * @version 1.0
 */
public class RotateRectangleArray {
    /**
     * Method that launches the program.
     */
    public static void main(String[] args) {
        // The Scanner object to get the user input
        Scanner scanner = new Scanner(System.in);

        // Number of rows in the rectangle array
        int rows = scanner.nextInt();

        // Number of columns in the rectangle array
        int columns = scanner.nextInt();

        // The rectangle array
        int[][] rectangle = new int[rows][columns];

        // The rotated rectangle array
        int[][] rotatedRectangle = new int[columns][rows];

        // Fill the rectangle array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                rectangle[i][j] = scanner.nextInt();
            }
        }

        // Rotate the rectangle array
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                // Change row and column indexes
                rotatedRectangle[i][j] = rectangle[rows - 1 - j][i];
            }
        }

        // Print the rotated array
        for (int[] row : rotatedRectangle) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
