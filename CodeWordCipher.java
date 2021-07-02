import java.util.LinkedList;

/**
 * Class with methods for encrypting messages with code word cipher
 *
 * @author VitasSalvantes
 * @version 3.0
 */
public class CodeWordCipher {

    /**
     * New alphabet with code word
     */
    private LinkedList<Character> newAlphabet;

    /**
     * List of letters of the English alphabet
     */
    final private LinkedList<Character> englishAlphabet = new LinkedList<Character>();

    /**
     * En- or decrypted message
     */
    private String outputMessage = "";

    /**
     * Message from user
     */
    private char[] inputMessage;

    /**
     * Code word with which encryption will be carried out
     */
    private char[] codeWord;

    /**
     * Method that launches the program
     */
    public static void main(String[] args) {
        CodeWordCipher cwc = new CodeWordCipher();
        cwc.setInputMessage("Hello world!");
        cwc.setCodeWord("Abrakadabra");
        System.out.println(cwc.encryption());
    }

    /**
     * Method for creating {@link CodeWordCipher#englishAlphabet}
     */
    private void createEnglishAlphabet() {
        for (char letter = 'a'; letter <= 'z'; letter++) {
            englishAlphabet.add(letter);
        }
    }

    /**
     * Method that creates a new alphabet with a {@link CodeWordCipher#codeWord}
     */
    private void createNewAlphabet() {
        newAlphabet = new LinkedList<Character>(englishAlphabet);
        for (char c : codeWord) {
            if (newAlphabet.contains(c)) {
                newAlphabet.remove(newAlphabet.indexOf(c));
                newAlphabet.addFirst(c);
            }
        }
    }

    /**
     * Setter for {@link CodeWordCipher#inputMessage}
     */
    public void setInputMessage(String inputMessage) {
        this.inputMessage = inputMessage.toLowerCase().toCharArray();
    }

    /**
     * Setter for {@link CodeWordCipher#codeWord}
     */
    public void setCodeWord(String codeWord) {
        this.codeWord = codeWord.toLowerCase().toCharArray();
    }

    /**
     * Method for encrypting a user message with code word cipher
     *
     * @return outputMessage {@link CodeWordCipher#outputMessage}
     */
    public String encryption() {
        createEnglishAlphabet();
        createNewAlphabet();

        for (char c : inputMessage) {
            if (englishAlphabet.contains(c)) {
                outputMessage += newAlphabet.get(englishAlphabet.indexOf(c));
            } else {
                outputMessage += c;
            }
        }

        return outputMessage;
    }

    /**
     * Method for decrypting a user message with code word cipher
     *
     * @return outputMessage {@link CodeWordCipher#outputMessage}
     */
    public String decryption() {
        createEnglishAlphabet();
        createNewAlphabet();

        for (char c : inputMessage) {
            if (newAlphabet.contains(c)) {
                outputMessage += englishAlphabet.get(newAlphabet.indexOf(c));
            } else {
                outputMessage += c;
            }
        }

        return outputMessage;
    }
}