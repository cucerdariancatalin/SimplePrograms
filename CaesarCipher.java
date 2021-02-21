import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for encrypting messages with Caesar cipher
 * 
 * @author VitasSalvantes
 * @version 3.0
 */

public class CaesarCipher {

    /** Message from user */
    private String inputMessage;

    /** Encrypted message */
    private String outputMessage = "";

    /** A Scanner class object that accepts user input */
    private Scanner sc = new Scanner(System.in);

    /** List of letters of the German alphabet */
    private ArrayList<Character> englishAlphabet = new ArrayList<Character>();

    /** A character array containing the processed custom message */
    private char[] chars;

    /** Key used for encryption */
    private int key;

    /** Method that launches the program */
    public static void main(String[] args) {
        CaesarCipher cc = new CaesarCipher();

        cc.setInputMessage();
        cc.setKey();
        System.out.println(cc.encryption(cc.getInputMessage(), cc.getKey()));
    }

    /**
     * Method for creating letters of the German alphabet
     * 
     * @return deutschAlphabet {@link CaesarCipher#englishAlphabet}
     */
    private void createEnglishAlphabet() {
        for (char letter = 'a'; letter <= 'z'; letter++) {
            englishAlphabet.add(letter);
        }
    }

    /**
     * Method handling custom message
     * 
     * @return chars {@link CaesarCipher#chars}
     */
    private char[] getInputMessage() {
        chars = inputMessage.toCharArray();
        return chars;
    }

    /**
     * Method that receives and processes a custom key
     * 
     * @return key {@link CaesarCipher#key}
     */
    private int getKey() {
        key %= 25;

        return key;
    }

    /** Setter for inputMessage {@link CaesarCipher#inputMessage} */
    public void setInputMessage() {
        System.out.println("Your message:");
        inputMessage = sc.nextLine().toLowerCase();
    }

    /** Setter for key {@link CaesarCipher#key} */
    public void setKey() {
        System.out.println("Your key:");
        key = sc.nextInt();
    }

    /**
     * A method for encrypting a user message with Caesar cipher
     * 
     * @param chars           {@link CaesarCipher#chars}
     * @param deutschAlphabet {@link CaesarCipher#englishAlphabet}
     * @param key             {@link CaesarCipher#key}
     * 
     * @return outputMessage {@link CaesarCipher#outputMessage}
     */
    private String encryption(char[] chars, int key) {
        chars = this.chars;
        createEnglishAlphabet();
        key = this.key;

        for (char c : chars) {
            if (englishAlphabet.contains(c) == true) {
                if ((englishAlphabet.indexOf(c) + key) > 25) {
                    outputMessage += englishAlphabet.get(Math.abs(26 - (englishAlphabet.indexOf(c) + key)));
                    continue;
                }
                outputMessage += englishAlphabet.get(englishAlphabet.indexOf(c) + key);

            } else {
                outputMessage += c;
            }
        }
        return outputMessage;
    }
}