import java.util.Scanner;

/**
 * A simple program that squares all the digits of a number
 * 
 * @author VitasSalvantes
 * @version 1.0
 */
public class SquareEveryDigit {

    /** Method that launches the program */
    public static void main(String[] args) {
        System.out.println("- Your number:");
        String s = new Scanner(System.in).next();
        char[] c = s.toCharArray();
        s = "";

        for (char ch : c) {
            s += Integer.parseInt(String.valueOf(ch)) * Integer.parseInt(String.valueOf(ch));
        }

        System.out.println(Integer.parseInt(s));
    }
}
