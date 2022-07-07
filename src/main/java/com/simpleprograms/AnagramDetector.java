/*
 * MIT License
 *
 * Copyright (c) 2022 VitasSalvantes
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.simpleprograms;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * The program to detect an anagram.
 *
 * @author VitasSalvantes
 * @version 3.0.2
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
        return primaryString;
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
     * Validates an input string.
     *
     * @param string the string to be validated.
     */
    private void validateString(final String string) {
        if (string == null) {
            throw new IllegalArgumentException("The string must not be null.");
        }

        if (string.length() == 0) {
            throw new IllegalArgumentException("The string must contain at least one character.");
        }
    }

    /**
     * Checks the {@link #primaryString} is an anagram of the input string.
     *
     * @param string the string to be checked.
     * @return boolean true if it is and boolean false if is not.
     */
    public boolean checkForAnagram(final @NotNull String string) {
        validateString(string);

        final char[] primaryWordLetters = primaryString.toCharArray();
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
