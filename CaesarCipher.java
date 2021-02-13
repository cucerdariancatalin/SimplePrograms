import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for encrypting messages with Caesar cipher
 * 
 * @author VitasSalvantes
 * @version 2.0
 */

public class CaesarCipher {

    /** Message from user */
    private String inputMessage;

    /** Encrypted message */
    private String outputMessage = "";

    /** A Scanner class object that accepts user input */
    private Scanner sc = new Scanner(System.in);

    /** List of letters of the German alphabet */
    private ArrayList<Character> deutschAlphabet = new ArrayList<Character>();

    /** A character array containing the processed custom message */
    private char[] chars;

    /** Key used for encryption */
    private int key;

    /** Method that launches the program */
    public static void main(String[] args) {
        CaesarCipher cc = new CaesarCipher();

        System.out.println(cc.encryption(cc.getChars(), cc.createDeutschAlphabet(), cc.getKey()));
    }

    /**
     * Method for creating letters of the German alphabet
     * 
     * @return deutschAlphabet {@link CaesarCipher#deutschAlphabet}
     */
    private ArrayList<Character> createDeutschAlphabet() {
        for (char buchstabe = 'a'; buchstabe <= 'z'; buchstabe++) {
            deutschAlphabet.add(buchstabe);
        }

        deutschAlphabet.add('ä');
        deutschAlphabet.add('ü');
        deutschAlphabet.add('ö');
        deutschAlphabet.add('ß');

        return deutschAlphabet;
    }

    /**
     * Method handling custom message
     * 
     * @return chars {@link CaesarCipher#chars}
     */
    private char[] getChars() {
        System.out.println("Your message:");
        inputMessage = sc.nextLine().toLowerCase();
        chars = inputMessage.toCharArray();
        return chars;
    }

    /**
     * Method that receives and processes a custom key
     * 
     * @return key {@link CaesarCipher#key}
     */
    private int getKey() {
        System.out.println("Your key:");
        key = sc.nextInt();

        key %= 30;

        return key;
    }

    /**
     * A method for encrypting a user message with Caesar cipher
     * 
     * @param chars           {@link CaesarCipher#chars}
     * @param deutschAlphabet {@link CaesarCipher#deutschAlphabet}
     * @param key             {@link CaesarCipher#key}
     * 
     * @return outputMessage {@link CaesarCipher#outputMessage}
     */
    private String encryption(char[] chars, ArrayList<Character> deutschAlphabet, int key) {
        chars = this.chars;
        deutschAlphabet = this.deutschAlphabet;
        key = this.key;

        for (char c : chars) {
            if (deutschAlphabet.contains(c) == true) {
                if ((deutschAlphabet.indexOf(c) + key) > 30) {
                    outputMessage += deutschAlphabet.get(30 % (deutschAlphabet.indexOf(c) + key));
                    continue;
                }
                outputMessage += deutschAlphabet.get(deutschAlphabet.indexOf(c) + key);

            } else {
                outputMessage += c;
            }
        }
        return outputMessage;
    }
}