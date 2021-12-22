import java.util.Scanner;

/**
 * Simple program to find out whether it is possible to break off exactly K segments from the chocolate.
 *
 * @author VitasSalvantes
 * @version 1.0
 */
public class Chocolate {

    /**
     * Method that launches the program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("The length and width of the chocolate:");
        int length = scanner.nextInt();
        int width = scanner.nextInt();

        System.out.println("How many segments do you want to break off?");
        int segmentsNumber = scanner.nextInt();

        boolean moreThanChocolate = segmentsNumber > length * width;
        boolean multipleOfLengthOrWidth = segmentsNumber % length == 0 || segmentsNumber % width == 0;

        System.out.println("\nIs it possible?");
        if (multipleOfLengthOrWidth && !moreThanChocolate) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
