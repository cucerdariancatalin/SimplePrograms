import java.util.Arrays;

/**
 * The program to detect an anagram.
 *
 * @author VitasSalvantes
 * @version 2.0
 */
public class AnagramDetector {

    /**
     * Some meaningless set of letters for which an anagram is being search.
     */
    private char[] characterSet;

    /**
     * The getter for the {@link #characterSet}.
     *
     * @return {@link #characterSet}.
     */
    public char[] getCharacterSet() {
        return characterSet;
    }

    /**
     * The setter for the {@link #characterSet}.
     *
     * @param characterSet - new value for the {@link #characterSet}.
     */
    public void setCharacterSet(char... characterSet) {
        this.characterSet = characterSet.clone();
        Arrays.sort(this.characterSet);
    }

    /**
     * The default constructor.
     *
     * @param characterSet - a value for the {@link #characterSet}.
     */
    public AnagramDetector(char... characterSet) {
        this.characterSet = characterSet;
        Arrays.sort(this.characterSet);
    }

    /**
     * Check the {@link #characterSet} is an anagram of the input word.
     *
     * @param word - the word to be checked.
     * @return boolean true if it is and boolean false if is not.
     */
    public boolean checkForAnagram(String word) {
        final char[] wordLetters = word.toCharArray();

        Arrays.sort(wordLetters);
        return Arrays.equals(this.characterSet, wordLetters);
    }

    /**
     * The method launches the program.
     */
    public static void main(String[] args) {
        final var detector = new AnagramDetector('l', 'l', 'a', 'a');

        System.out.println(detector.checkForAnagram("alla"));
        System.out.println(detector.checkForAnagram("lala"));

        System.out.println();

        detector.setCharacterSet('o', 'p', 'a');
        System.out.printf("New character set: %s%n", Arrays.toString(detector.getCharacterSet()));

        System.out.println();

        System.out.println(detector.checkForAnagram("alla"));
        System.out.println(detector.checkForAnagram("lala"));
        System.out.println(detector.checkForAnagram("apo"));
        System.out.println(detector.checkForAnagram("opa"));

    }
}