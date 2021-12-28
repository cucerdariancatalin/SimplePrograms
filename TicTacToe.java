import java.util.Arrays;
import java.util.Scanner;

/**
 * Simple implementation of the Tic-tac-toe game.
 *
 * @author VitasSalvantes
 * @version 1.5
 */
public class TicTacToe {

    /**
     * Method that launches the program.
     */
    public static void main(String[] args) {
        // The Scanner object to get the user input
        Scanner scanner = new Scanner(System.in);

        // Get the current field state from the user
        // TODO: 27.12.2021 Check the length of the input
        System.out.println("What's up on the field?");
        System.out.print("Enter cells: ");
        String currentFieldState = scanner.nextLine().toUpperCase();

        // The size of the game field's side
        int sideSize = 3;

        // The two-dimensional array presenting the game field
        char[][] field = new char[sideSize][sideSize];

        // Fill the game field with characters from the currentFieldState string
        int currentCharIndex = 0;
        for (int i = 0; i < sideSize; i++) {
            for (int j = 0; j < sideSize; j++) {
                field[i][j] = currentFieldState.charAt(currentCharIndex);
                currentCharIndex++;
            }
        }

        // Print the top border
        System.out.println("---------");

        // Print lines
        for (char[] row : field) {
            // Print the left border
            System.out.print("| ");
            // Print one line
            for (char character : row) {
                if (character == '_') {
                    System.out.print("  ");
                } else {
                    System.out.print(character + " ");
                }
            }
            // Print the right border
            System.out.print("|\n");
        }

        // Print the bottom border
        System.out.println("---------");

        // Check the current game state
        String currentGameState;

        // X wins and how
        boolean xWins;
        boolean xWinsHorizontally = false;
        boolean xWinsDiagonally = false;
        boolean xWinsVertically = false;

        // O wins and how
        boolean oWins;
        boolean oWinsHorizontally = false;
        boolean oWinsDiagonally = false;
        boolean oWinsVertically = false;

        // Is the currentFieldState impossible
        boolean impossible = false;

        // Does the currentFieldState have any '_' characters
        boolean gameNotFinished = false;

        // The win combination of X or O
        char[] oneCharacterRow = new char[field.length];

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
                xWinsHorizontally = true;
                break;
            }
        }

        // If a column of the field (a row of the rotatedField) has three 'X', X wins
        for (char[] row : fieldRotated) {
            if (Arrays.equals(oneCharacterRow, row)) {
                xWinsVertically = true;
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
                oWinsHorizontally = true;
                break;
            }
        }

        // If a column of the field (a row of the rotatedField) has three 'O', O wins
        for (char[] row : fieldRotated) {
            if (Arrays.equals(oneCharacterRow, row)) {
                oWinsVertically = true;
                break;
            }
        }

        // Diagonals of the field
        String firstDiagonal = "" + field[0][0] + field[1][1] + field[2][2];
        String secondDiagonal = "" + field[0][2] + field[1][1] + field[2][0];

        // If a diagonal has three 'X', X wins
        if (firstDiagonal.equals("XXX") ^ secondDiagonal.equals("XXX")) {
            xWinsDiagonally = true;
        }

        // If a diagonal has three 'O', O wins
        if (firstDiagonal.equals("OOO") ^ secondDiagonal.equals("OOO")) {
            oWinsDiagonally = true;
        }

        // Check impossible states
        // How many Os and Xs does the field have
        String onlyX = currentFieldState.replace("O", "").replace("_", "");
        String onlyO = currentFieldState.replace("X", "").replace("_", "");

        // Definite who is the winner
        xWins = xWinsHorizontally || xWinsDiagonally || xWinsVertically;
        oWins = oWinsHorizontally || oWinsDiagonally || oWinsVertically;

        // Check both diagonals have three 'X' or three 'O'
        if (firstDiagonal.equals("XXX") && secondDiagonal.equals("XXX")) impossible = true;
        if (firstDiagonal.equals("OOO") && secondDiagonal.equals("OOO")) impossible = true;
        // Check the number of characters is wrong
        if (Math.abs(onlyX.length() - onlyO.length()) > 1) impossible = true;
        // Check both row and column of the field have three 'X' or three 'O'
        if (xWinsHorizontally && xWinsDiagonally
                || xWinsDiagonally && xWinsVertically
                || xWinsHorizontally && xWinsVertically) impossible = true;
        if (oWinsHorizontally && oWinsDiagonally
                || oWinsDiagonally && oWinsVertically
                || oWinsHorizontally && oWinsVertically) impossible = true;
        // Check both X and O win
        if (oWins && xWins) impossible = true;

        // Check game finished
        CheckingGameFinished:
        for (char[] row : field) {
            for (char character : row) {
                if (character == '_') {
                    gameNotFinished = true;
                    break CheckingGameFinished;
                }
            }
        }

        // Definite the current game state
        if (impossible) {
            currentGameState = "Impossible";
        } else if (oWins) {
            currentGameState = "O wins";
        } else if (xWins) {
            currentGameState = "X wins";
        } else if (gameNotFinished) {
            currentGameState = "Game not finished";
        } else {
            currentGameState = "Draw";
        }

        // Print the current game state
        System.out.println(currentGameState);

        // Get a move from the user
        // Coordinates of a cell
        int coordinateX;
        int coordinateY;

        // Get and check coordinates
        while (true) {
            System.out.print("Enter the coordinates: ");

            // Check coordinates are not numbers
            if (scanner.hasNextInt()) {
                coordinateX = scanner.nextInt() - 1;
            } else {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (scanner.hasNextInt()) {
                coordinateY = scanner.nextInt() - 1;
            } else {
                System.out.println("You should enter numbers!");
                continue;
            }

            // Check the cell doesn't exist and the cell isn't free
            if (coordinateX > field.length - 1 || coordinateY > field.length - 1) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (field[coordinateX][coordinateY] == 'X' || field[coordinateX][coordinateY] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                field[coordinateX][coordinateY] = 'X';
                break;
            }
        }

        // Print the new field
        // Print the top border
        System.out.println("---------");

        // Print lines
        for (char[] row : field) {
            // Print the left border
            System.out.print("| ");
            // Print one line
            for (char character : row) {
                if (character == '_') {
                    System.out.print("  ");
                } else {
                    System.out.print(character + " ");
                }
            }
            // Print the right border
            System.out.print("|\n");
        }

        // Print the bottom border
        System.out.println("---------");
    }
}
