package com.simpleprograms;

import java.util.Objects;

/**
 * The program to en- and decrypt messages using the Caesar cipher.
 *
 * @author VitasSalvantes
 * @version 7.0
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
    public CaesarCipher(final String key) {
        this.key = Objects.requireNonNullElse(key, "");
    }

    /**
     * The setter for the {@link #key}.
     *
     * @param key a new value of the {@link #key}.
     */
    public void setKey(final String key) {
        this.key = Objects.requireNonNullElse(key, "");
    }

    /**
     * The getter for the {@link #key}.
     *
     * @return the {@link #key}.
     */
    public String getKey() {
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
    public String processMessage(final String inputMessage,
                                 final boolean isEncryption) {
        if (inputMessage == null) {
            return "";
        }

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
     * The method launches the program.
     */
    public static void main(String[] args) {
        final var cipher = new CaesarCipher("");

        final String[] keys = {"My key", "", null, Character.toString(Character.MAX_VALUE - 1)};
        final String message = "Hello, World!";
        final var encryptedMessage = new StringBuilder();
        final var decryptedMessage = new StringBuilder();

        for (String key : keys) {
            cipher.setKey(key);

            System.out.println(cipher.getKey() + ":\n");

            encryptedMessage.append(cipher.processMessage(message, true));
            decryptedMessage.append(cipher.processMessage(encryptedMessage.toString(), false));

            System.out.println(message);
            System.out.println(encryptedMessage);
            System.out.println(decryptedMessage + "\n");

            // Change the message to null to check the message is null
            if (message != null) {
                encryptedMessage.delete(0, message.length());
                decryptedMessage.delete(0, message.length());
            }
        }
    }
}