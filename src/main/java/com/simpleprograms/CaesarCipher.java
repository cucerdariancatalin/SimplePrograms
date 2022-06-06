package com.simpleprograms;

import org.jetbrains.annotations.NotNull;

/**
 * The program to en- and decrypt messages using the Caesar cipher.
 *
 * @author VitasSalvantes
 * @version 7.5
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
        return this.key;
    }

    /**
     * The method converts the {@link #key} to a number.
     *
     * @return the {@link #key} as a number.
     */
    private int convertKeyToInt() {
        int numberKey = 0;

        for (int i = 0; i < this.key.length(); i++) {
            numberKey += Character.getNumericValue(this.key.charAt(i));
        }

        return numberKey % Character.MAX_CODE_POINT;
    }

    /**
     * The method en- or decrypt the message using the Atbash cipher.
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
     * Validate the user input.<br>
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