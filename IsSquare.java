import java.util.Scanner;

/**
 * Simple program for defining squares
 * 
 * @author VitasSalvantes
 * @version 1.0
 */
public class IsSquare {

    /** Method that launches the program */
    public static void main(String[] args) {
        System.out.println("Your number:");
        int n = new Scanner(System.in).nextInt();
        System.out.println(Math.sqrt(n) % 1 == 0);
    }
}