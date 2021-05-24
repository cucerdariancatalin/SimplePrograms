import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for encrypting messages with Atbash cipher
 * 
 * @author VitasSalvantes
 * @version 1.5
 */

public class AtbashCipher {

    /** List of letters of the English alphabet */
    private final ArrayList<Character> englishAlphabet = new ArrayList<Character>();

    /** Message from user */
    private String inputMessage;

    /** En- or decrypted message */
    private String outputMessage = "";

    /** A character array containing the processed custom message */
    private char[] chars;

    /** Method that launches the program */
    public static void main(String[] args) {
        AtbashCipher ac = new AtbashCipher();
        ac.setInputMessage();
        System.out.println(ac.encryption());
    }

    /** Method for creating letters of the English alphabet */
    private void createEnglishAlphabet() {
        for (char letter = 'a'; letter <= 'z'; letter++) {
            englishAlphabet.add(letter);
        }
    }

    /**
     * Setter for {@link AtbashCipher#inputMessage} and {@link AtbashCipher#chars}
     */
    private void setInputMessage() {
        System.out.println("Your message:");
        inputMessage = new Scanner(System.in).nextLine().toLowerCase();
        chars = inputMessage.toCharArray();
    }

    /** Method for encrypting a user message with Atbash cipher */
    private String encryption() {
        createEnglishAlphabet();

        for (char c : chars) {
            if (englishAlphabet.contains(c)) {
                outputMessage += englishAlphabet.get(25 - englishAlphabet.indexOf(c));
            } else {
                outputMessage += c;
            }
        }

        return outputMessage;
    }
}