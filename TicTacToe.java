import java.util.Scanner;

/**
 * Simple implementation of the Tic-tac-toe game.
 *
 * @author VitasSalvantes
 * @version 1.0
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
        String ticTacToeState = scanner.nextLine();

        // The number of the elements in a line
        int lineSize = 3;
        // The number of the lines in the game
        int numberOfLines = 3;
        // The array of the lines
        String[] lines = new String[numberOfLines];


        // The beginning index of a substring, inclusive
        int beginIndex = 0;
        // The ending index of a substring, exclusive
        int endIndex;

        // Fill the lines array with substrings from the ticTacToeState string
        for (int i = 0; i < numberOfLines; i++) {
            endIndex = beginIndex + lineSize;
            lines[i] = ticTacToeState.substring(beginIndex, endIndex).toUpperCase();
            beginIndex += lineSize;
        }

        // Print the top border
        System.out.println("---------");

        // Print lines
        for (String line : lines) {
            // Print the left border
            System.out.print("| ");
            // Print one line
            for (char character : line.toCharArray()) {
                System.out.print(character + " ");
            }
            // Print the right border
            System.out.print("|\n");
        }

        // Print the bottom border
        System.out.println("---------");
    }
}
