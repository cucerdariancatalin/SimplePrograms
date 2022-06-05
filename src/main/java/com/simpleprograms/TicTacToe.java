package com.simpleprograms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Simple implementation of the Tic-tac-toe game.
 *
 * @author VitasSalvantes
 * @version 2.0
 */
public class TicTacToe {

    /**
     * Method that launches the program.
     */
    public static void main(String[] args) {
        // The Scanner object to get the user input
        Scanner scanner = new Scanner(System.in);

        // The size of the game field's side
        int sideSize = 3;

        // The two-dimensional array presenting the game field
        char[][] field = createEmptyField(sideSize);

        // The result of the game
        String result = "";

        // X wins
        boolean xWins = false;

        // O wins
        boolean oWins = false;

        // The win combination of X or O
        char[] oneCharacterRow = new char[field.length];

        // Diagonals of the field
        String firstDiagonal;
        String secondDiagonal;

        // The number of a move
        int move = 1;

        // Do next move
        boolean doNextMove = true;

        while (doNextMove) {
            printField(field);

            getMove(field, scanner, move);

            move++;

            // The rotated field to check columns
            char[][] fieldRotated = new char[field.length][field.length];
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field.length; j++) {
                    fieldRotated[i][j] = field[j][i];
                }
            }

            // Check X rows and columns in the field array
            for (int i = 0; i < field.length; i++) {
                oneCharacterRow[i] = 'X';
            }

            // If a row of the field has three 'X', X wins
            for (char[] row : field) {
                if (Arrays.equals(oneCharacterRow, row)) {
                    xWins = true;
                    break;
                }
            }

            // If a column of the field (a row of the rotatedField) has three 'X', X wins
            for (char[] row : fieldRotated) {
                if (Arrays.equals(oneCharacterRow, row)) {
                    xWins = true;
                    break;
                }
            }

            // Check O rows and columns in the field array
            for (int i = 0; i < field.length; i++) {
                oneCharacterRow[i] = 'O';
            }

            // If a row of the field has three 'O', O wins
            for (char[] row : field) {
                if (Arrays.equals(oneCharacterRow, row)) {
                    oWins = true;
                    break;
                }
            }

            // If a column of the field (a row of the rotatedField) has three 'O', O wins
            for (char[] row : fieldRotated) {
                if (Arrays.equals(oneCharacterRow, row)) {
                    oWins = true;
                    break;
                }
            }

            // Check diagonals
            firstDiagonal = "" + field[0][0] + field[1][1] + field[2][2];
            secondDiagonal = "" + field[0][2] + field[1][1] + field[2][0];

            // If a diagonal has three 'X', X wins
            if (firstDiagonal.equals("XXX") ^ secondDiagonal.equals("XXX")) {
                xWins = true;
            }

            // If a diagonal has three 'O', O wins
            if (firstDiagonal.equals("OOO") ^ secondDiagonal.equals("OOO")) {
                oWins = true;
            }

            // Definite the result
            if (oWins) {
                result = "O wins";
                doNextMove = false;
            } else if (xWins) {
                result = "X wins";
                doNextMove = false;
            } else if (move > 9) {
                result = "Draw";
                doNextMove = false;
            }
        }

        printField(field);

        // Print the result
        System.out.println(result);
    }

    private static void getMove(char[][] field, Scanner scanner, int move) {

        // Get and check coordinates
        while (true) {
            System.out.print("Enter the coordinates: ");

            int coordinateX = getCoordinate(scanner);
            int coordinateY = getCoordinate(scanner);

            if (checkMove(field, coordinateX, coordinateY)) {
                if (move % 2 != 0) {
                    field[coordinateX][coordinateY] = 'X';
                } else {
                    field[coordinateX][coordinateY] = 'O';
                }
                break;
            }
        }
    }

    // Check if user's move is correct
    private static boolean checkMove(char[][] field, int coordinateX, int coordinateY) {
        // Check the cell doesn't exist and the cell isn't free
        if (coordinateX > field.length - 1 || coordinateY > field.length - 1) {
            System.out.println("Coordinates should be from 1 to 3!");
        } else if (field[coordinateX][coordinateY] == 'X' || field[coordinateX][coordinateY] == 'O') {
            System.out.println("This cell is occupied! Choose another one!");
        } else {
            return true;
        }
        return false;
    }

    // Get a coordinate
    private static int getCoordinate(Scanner scanner) {
        while (true) {

            // Check coordinates are not numbers
            if (scanner.hasNextInt()) {
                return scanner.nextInt() - 1;
            } else {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
                continue;
            }
        }
    }

    // Print the field
    public static void printField(char[][] field) {
        // Print the top border
        System.out.println("---------");

        // Print lines
        for (char[] row : field) {
            // Print the left border
            System.out.print("| ");
            // Print one line
            for (char character : row) {
                System.out.print(character + " ");
            }
            // Print the right border
            System.out.print("|\n");
        }

        // Print the bottom border
        System.out.println("---------");
    }

    // Create the empty game field
    public static char[][] createEmptyField(int sideSize) {
        char[][] field = new char[sideSize][sideSize];

        for (int i = 0; i < sideSize; i++) {
            for (int j = 0; j < sideSize; j++) {
                field[i][j] = ' ';
            }
        }

        return field;
    }
}
