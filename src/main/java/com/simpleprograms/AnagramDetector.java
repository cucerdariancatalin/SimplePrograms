package com.simpleprograms;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * The program to detect an anagram.
 *
 * @author VitasSalvantes
 * @version 3.0
 */
public class AnagramDetector {

    /**
     * The string to compare with other strings.
     */
    private @NotNull String primaryString;

    /**
     * The default constructor.
     *
     * @param primaryString a default value of the {@link #primaryString}.
     */
    public AnagramDetector(final @NotNull String primaryString) {
        validateString(primaryString);

        this.primaryString = primaryString;
    }

    /**
     * The getter for the {@link #primaryString}.
     *
     * @return the {@link #primaryString}.
     */
    public @NotNull String getPrimaryString() {
        return this.primaryString;
    }

    /**
     * The setter for the {@link #primaryString}.
     *
     * @param primaryString a new value of the {@link #primaryString}.
     */
    public void setPrimaryString(final @NotNull String primaryString) {
        validateString(primaryString);

        this.primaryString = primaryString;
    }

    /**
     * Validate an input string.
     *
     * @param string the string to be validated.
     * @throws NullPointerException     if the string is null.
     * @throws IllegalArgumentException if the string is empty.
     */
    private void validateString(final String string) throws IllegalArgumentException {
        if (string == null) {
            throw new IllegalArgumentException("The string must not be null.");
        }

        if (string.length() == 0) {
            throw new IllegalArgumentException("The string must contain at least one character.");
        }
    }

    /**
     * Check the {@link #primaryString} is an anagram of the input string.
     *
     * @param string the string to be checked.
     * @return boolean true if it is and boolean false if is not.
     */
    public boolean checkForAnagram(@NotNull String string) {
        validateString(string);

        final char[] primaryWordLetters = this.primaryString.toCharArray();
        final char[] wordLetters = string.toCharArray();

        Arrays.sort(primaryWordLetters);
        Arrays.sort(wordLetters);

        return Arrays.equals(primaryWordLetters, wordLetters);
    }

    /**
     * The example of using the program.
     */
    public static void main(String[] args) {
        final var anagramDetector = new AnagramDetector("Mama and papa");
        System.out.println(anagramDetector.getPrimaryString());

        System.out.println(anagramDetector.checkForAnagram("amMa dan paap"));

        anagramDetector.setPrimaryString("Papa and mama");

        System.out.println(anagramDetector.getPrimaryString());

        System.out.println(anagramDetector.checkForAnagram("amma"));
    }
}