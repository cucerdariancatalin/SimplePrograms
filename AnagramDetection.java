import java.util.Arrays;
import java.util.Scanner;

/**
 * Simple program for detecting anagram
 * 
 * @author VitasSalvantes
 * @version 1.0
 */
public class AnagramDetection {

    /** Method that launches the program */
    public static void main(String[] args) {
        System.out.println("- Your word?");
        char[] abrakadabra = new Scanner(System.in).next().toLowerCase().toCharArray();
        System.out.println("- Your abrakadabra?");
        char[] word = new Scanner(System.in).next().toLowerCase().toCharArray();

        Arrays.sort(word);
        Arrays.sort(abrakadabra);

        System.out.println("- Is anagram?\n" + Arrays.equals(word, abrakadabra));
    }
}