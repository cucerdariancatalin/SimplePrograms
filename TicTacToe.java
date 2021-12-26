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

        // Get the current game state from the user
        System.out.println("What's going on?");
        String currentState = scanner.nextLine();

        // The number of the rows on the game field
        int rows = 3;
        // The number of the columns on the game field
        int columns = 3;
        // The two-dimensional array presenting the game field
        char[][] field = new char[rows][columns];

        // Fill the game field with characters from the currentState string
        int currentCharIndex = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                field[i][j] = currentState.charAt(currentCharIndex);
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
                System.out.print(character + " ");
            }
            // Print the right border
            System.out.print("|\n");
        }

        // Print the bottom border
        System.out.println("---------");
    }
}
