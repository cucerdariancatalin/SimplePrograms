import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class with methods for encrypting messages with Caesar cipher
 * 
 * @author VitasSalvantes
 * @version 5.0
 */

public class CaesarCipher {

    /** Message from user */
    private String inputMessage;

    /** En- or decrypted message */
    private String outputMessage = "";

    /** A Scanner class object that accepts user input */
    final private Scanner sc = new Scanner(System.in);

    /** List of letters of the English alphabet */
    final private ArrayList<Character> englishAlphabet = new ArrayList<Character>();

    /** A character array containing the processed custom message */
    private char[] chars;

    /** Key used for encryption */
    private int key;

    /** Method that launches the program */
    public static void main(String[] args) {
        CaesarCipher cc = new CaesarCipher();

        cc.setInputMessage();
        cc.setKey();
        System.out.println(cc.decryption(cc.getInputMessage(), cc.getKey()));
        System.out.println(cc.encryption(cc.getInputMessage(), cc.getKey()));
    }

    /** Method for creating letters of the English alphabet */
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
    private void setInputMessage() {
        System.out.println("Your message:");
        inputMessage = sc.nextLine().toLowerCase();
    }

    /** Setter for key {@link CaesarCipher#key} */
    private void setKey() {
        System.out.println("Your key:");
        key = Math.abs(sc.nextInt());
    }

    /**
     * Method for encrypting a user message with Caesar cipher
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

        sc.close();
        return outputMessage;
    }

    /**
     * Method for decrypting a user message with Caesar cipher
     * 
     * @return outputMessage {@link CaesarCipher#outputMessage}
     */
    private String decryption(char[] chars, int key) {
        chars = this.chars;
        createEnglishAlphabet();
        key = this.key;

        for (char c : chars) {
            if (englishAlphabet.contains(c) == true) {
                if ((englishAlphabet.indexOf(c) - key) < 0) {
                    outputMessage += englishAlphabet.get(Math.abs(26 - (key - englishAlphabet.indexOf(c))));
                    continue;
                }
                outputMessage += englishAlphabet.get(englishAlphabet.indexOf(c) - key);

            } else {
                outputMessage += c;
            }
        }

        sc.close();
        return outputMessage;
    }
}