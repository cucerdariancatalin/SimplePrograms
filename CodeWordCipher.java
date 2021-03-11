import java.util.LinkedList;
import java.util.Scanner;

/**
 * Class with methods for encrypting messages with code word cipher
 * 
 * @author VitasSalvantes
 * @version 1.5
 */
public class CodeWordCipher {

    /** New alphabet with code word */
    private LinkedList<Character> newAlphabet;

    /** List of letters of the English alphabet */
    final private LinkedList<Character> englishAlphabet = new LinkedList<Character>();

    /** A Scanner class object that accepts user input */
    final private Scanner sc = new Scanner(System.in);

    /** Message from user */
    private String inputMessage = "";

    /** Encrypted message */
    private String outputMessage = "";

    /** Code word with which encryption will be carried out */
    private String codeWord = "";

     /** A character array containing the processed custom message */
    private char[] messageToChars;

     /** A character array containing the processed code word */
    private char[] codeWordToChars;

    /** Method that launches the program */
    public static void main(String[] args) {
        CodeWordCipher cwp = new CodeWordCipher();

        cwp.setInputMessage();
        cwp.setCodeWord();

        System.out.println(cwp.encryption());
    }

    /** Method for creating {@link CodeWordCipher#englishAlphabet} */
    private void createEnglishAlphabet() {
        for (char letter = 'a'; letter <= 'z'; letter++) {
            englishAlphabet.add(letter);
        }
    }

    /** Method that creates a new alphabet with a {@link CodeWordCipher#codeWord} */
    private void createNewAlphabet() {
        newAlphabet = new LinkedList<Character>(englishAlphabet);
        for (char c : codeWordToChars) {
            if (newAlphabet.contains(c)) {
                newAlphabet.remove(newAlphabet.indexOf(c));
                newAlphabet.addFirst(c);
            }
        }
    }

    /** Setter for {@link CodeWordCipher#inputMessage} */
    private void setInputMessage() {
        System.out.println("- Your message:");
        inputMessage = sc.nextLine().toLowerCase();
        messageToChars = inputMessage.toCharArray();
    }

    /** Setter for {@link CodeWordCipher#codeWord} */
    private void setCodeWord() {
        System.out.println("- Your code word:");
        codeWord = sc.nextLine().toLowerCase();

        codeWordToChars = new char[codeWord.length()];
        for (int i = codeWord.length() - 1; i >= 0; i--) {
            codeWordToChars[i] = codeWord.charAt(i);
        }
    }

    /**
     * A method for encrypting a user message with code word cipher
     * 
     * @return outputMessage {@link CodeWordCipher#outputMessage}
     */
    private String encryption() {
        createEnglishAlphabet();
        createNewAlphabet();

        for (char c : messageToChars) {
            if (englishAlphabet.contains(c)) {
                outputMessage += newAlphabet.get(englishAlphabet.indexOf(c));
            } else {
                outputMessage += c;
            }
        }

        sc.close();
        return outputMessage;
    }
}