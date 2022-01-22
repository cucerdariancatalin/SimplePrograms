import java.util.Scanner;

/**
 * Simple implementation of the Collatz conjecture.
 *
 * @author VitasSalvantes
 * @version 1.0
 */
public class CollatzConjecture {

    /**
     * Method that launches the program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("- Number?");
        int number = scanner.nextInt();
        StringBuilder sequence = new StringBuilder(number + " ");

        while (number != 1) {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number = number * 3 + 1;
            }
            sequence.append(number).append(" ");
        }

        System.out.print(sequence);
    }
}
