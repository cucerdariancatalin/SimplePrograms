import java.util.ArrayList;

/**
 * Class for encrypting messages with Atbash cipher
 *
 * @author VitasSalvantes
 * @version 3.0
 */

public class AtbashCipher {

    /**
     * List of letters of the English alphabet
     */
    private final ArrayList<Character> englishAlphabet = new ArrayList<Character>();

    /**
     * En- or decrypted message
     */
    private String outputMessage = "";

    /**
     * Message from user
     */
    private char[] inputMessage;

    /**
     * Method that launches the program
     */
    public static void main(String[] args) {
        AtbashCipher ac = new AtbashCipher();
        ac.setInputMessage("Hello world!");
        System.out.println(ac.encryption());
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
     * Setter for {@link AtbashCipher#inputMessage}
     */
    public void setInputMessage(String inputMessage) {
        this.inputMessage = inputMessage.toLowerCase().toCharArray();
    }

    /**
     * Method for encrypting a user message with Atbash cipher
     */
    public String encryption() {
        createEnglishAlphabet();

        for (char c : inputMessage) {
            if (englishAlphabet.contains(c)) {
                outputMessage += englishAlphabet.get(25 - englishAlphabet.indexOf(c));
            } else {
                outputMessage += c;
            }
        }

        return outputMessage;
    }
}