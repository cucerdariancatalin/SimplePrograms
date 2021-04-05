import java.util.Scanner;

/**
 * Class-example of factorial implementation
 * 
 * @author VitasSalvantes
 * @version 2.0
 */
public class Factorial {

    /**
     * Method that launches the program
     */
    public static void main(String[] args) {
        int result = 1;
        System.out.println("- Number?");
        int number = new Scanner(System.in).nextInt();
        System.out.print(number + "! = ");

        while (number > 0) {
            result *= number;
            number--;
        }

        System.out.println(result);
    }
}