/**
 * MIT License
 * <p>
 * Copyright (c) 2021 VitasSalvantes
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
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

/**
 * The program to en- and decrypt messages using the Caesar cipher.
 *
 * @author VitasSalvantes
 * @version 7.5.1
 */
public class CaesarCipher {

    /**
     * The key is used to en- or decrypt the message.
     */
    private String key;

    /**
     * The constructor sets a default value of the {@link #key}.
     *
     * @param key - a default value of the {@link #key}.
     */
    public CaesarCipher(final @NotNull String key) {
        validateInput(key);

        this.key = key;
    }

    /**
     * The setter for the {@link #key}.
     *
     * @param key a new value of the {@link #key}.
     */
    public void setKey(final @NotNull String key) {
        validateInput(key);

        this.key = key;
    }

    /**
     * The getter for the {@link #key}.
     *
     * @return the {@link #key}.
     */
    public @NotNull String getKey() {
        return key;
    }

    /**
     * Converts the {@link #key} to a number.
     *
     * @return the {@link #key} as a number.
     */
    private int convertKeyToInt() {
        int numberKey = 0;

        for (int i = 0; i < key.length(); i++) {
            numberKey += Character.getNumericValue(key.charAt(i));
        }

        return numberKey % Character.MAX_CODE_POINT;
    }

    /**
     * En- or decrypts the message using the Atbash cipher.
     *
     * @param inputMessage the message to be en- or decrypted.
     * @param isEncryption the flag to choose the process option (en- or decrypt).
     * @return the en- or decrypted message .
     */
    public @NotNull String processMessage(final @NotNull String inputMessage,
                                          final boolean isEncryption) {
        validateInput(inputMessage);

        final int numberKey = convertKeyToInt();
        final var outputMessage = new StringBuilder();

        for (int i = 0; i < inputMessage.length(); i++) {
            if (isEncryption) {
                outputMessage.append(Character.toString(inputMessage.charAt(i) + numberKey));
            } else {
                outputMessage.append(Character.toString(inputMessage.charAt(i) - numberKey));
            }
        }

        return outputMessage.toString();
    }

    /**
     * Validates the user input.<br>
     * The method is used to validate a new value of the {@link #key} and the input message.
     *
     * @param input the user input (string) to be validated.
     * @throws IllegalArgumentException if either the {@link #key} or the user input are null or empty.
     */
    private void validateInput(final String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("The input must not be null");
        }

        if (input.length() == 0) {
            throw new IllegalArgumentException("The input must contain at least one character.");
        }
    }

    /**
     * The example of using the program.
     */
    public static void main(String[] args) {
        final var caesarCipher = new CaesarCipher("Key");

        final String message = "Hello, World!";
        final String encryptedMessage = caesarCipher.processMessage(message, true);
        System.out.printf("%s%n%s%n%s%n", message, encryptedMessage, caesarCipher.processMessage(encryptedMessage, false));
    }
}
