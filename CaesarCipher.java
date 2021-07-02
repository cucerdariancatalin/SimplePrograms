import java.util.ArrayList;

/**
 * Class with methods for encrypting messages with Caesar cipher
 *
 * @author VitasSalvantes
 * @version 5.0
 */

public class CaesarCipher {

    /**
     * En- or decrypted message
     */
    private String outputMessage = "";

    /**
     * List of letters of the English alphabet
     */
    final private ArrayList<Character> englishAlphabet = new ArrayList<Character>();

    /**
     * Message from user
     */
    private char[] inputMessage;

    /**
     * Key used for encryption
     */
    private int key;

    /**
     * Method that launches the program
     */
    public static void main(String[] args) {
        CaesarCipher cc = new CaesarCipher();
        cc.setInputMessage("Hello world!");
        cc.setKey(4);
        System.out.println(cc.encryption());
    }

    /**
     * Method for creating letters of the English alphabet
     */
    private void createEnglishAlphabet() {
        for (char letter = 'a'; letter <= 'z'; letter++) {
            englishAlphabet.add(letter);
        }
    }

    /**
     * Setter for inputMessage {@link CaesarCipher#inputMessage}
     */
    public void setInputMessage(String inputMessage) {
        this.inputMessage = inputMessage.toLowerCase().toCharArray();
    }

    /**
     * Setter for key {@link CaesarCipher#key}
     */
    public void setKey(int key) {
        this.key = Math.abs(key % 25);
    }

    /**
     * Method for encrypting a user message with Caesar cipher
     *
     * @return outputMessage {@link CaesarCipher#outputMessage}
     */
    public String encryption() {
        createEnglishAlphabet();

        for (char c : inputMessage) {
            if (englishAlphabet.contains(c)) {
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

    /**
     * Method for decrypting a user message with Caesar cipher
     *
     * @return outputMessage {@link CaesarCipher#outputMessage}
     */
    public String decryption() {
        createEnglishAlphabet();

        for (char c : inputMessage) {
            if (englishAlphabet.contains(c)) {
                if ((englishAlphabet.indexOf(c) - key) < 0) {
                    outputMessage += englishAlphabet.get(Math.abs(26 - (key - englishAlphabet.indexOf(c))));
                    continue;
                }
                outputMessage += englishAlphabet.get(englishAlphabet.indexOf(c) - key);

            } else {
                outputMessage += c;
            }
        }

        return outputMessage;
    }
}