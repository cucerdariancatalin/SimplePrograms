import java.util.Arrays;
import java.util.Scanner;

/**
 * Simple program to compare two boxes.
 *
 * @author VitasSalvantes
 * @version 1.0
 */
public class Boxes {

    /**
     * Method that launches the program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstBox = createBox(scanner);
        int[] secondBox = createBox(scanner);
        String result;

        if (Arrays.compare(firstBox, secondBox) > 0) {
            result = "Box 1 > Box 2";
        } else {
            result = "Box 1 < Box 2";
        }

        for (int i = 0; i < firstBox.length; i++) {
            if (firstBox[i] == secondBox[i]) {
                result = "Incompatible";
                break;
            }
        }

        System.out.println(result);
    }

    /**
     * Method that gets user input and creates a box.
     */
    public static int[] createBox(Scanner scanner) {
        int[] box = new int[3];

        System.out.println("- Sides?");
        for (int i = 0; i < box.length; i++) {
            box[i] = scanner.nextInt();
        }

        Arrays.sort(box);

        return box;
    }
}
