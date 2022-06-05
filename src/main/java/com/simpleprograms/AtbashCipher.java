package com.simpleprograms;

import org.jetbrains.annotations.NotNull;

/**
 * The program to en- and decrypt messages using the Atbash cipher.
 *
 * @author VitasSalvantes
 * @version 5.0
 */
public class AtbashCipher {

    /**
     * The method en- or decrypts the message using the Atbash cipher.
     *
     * @param inputMessage the message to be en- or decrypted.
     * @return the en- or decrypted message.
     */
    public @NotNull String processMessage(final @NotNull String inputMessage) {
        validateMessage(inputMessage);

        final var outputMessage = new StringBuilder();

        for (int i = 0; i < inputMessage.length(); i++) {
            outputMessage.append((char) (Character.MAX_VALUE - inputMessage.charAt(i)));
        }

        return outputMessage.toString();
    }

    /**
     * Validate an input message.
     *
     * @param message the string to be validated.
     * @throws IllegalArgumentException if the message is null.
     * @throws IllegalArgumentException if the message is empty.
     */
    private void validateMessage(final String message) throws IllegalArgumentException {
        if (message == null) {
            throw new IllegalArgumentException("The message must not be null.");
        }

        if (message.length() == 0) {
            throw new IllegalArgumentException("The message must not be empty.");
        }
    }

    /**
     * The example of using the program.
     */
    public static void main(String[] args) {
        final var cipher = new AtbashCipher();
        final var userMessage = "Hello, World!";

        System.out.println(userMessage);
        System.out.println(cipher.processMessage(userMessage));
        System.out.println(cipher.processMessage("ﾷﾚﾓﾓﾐￓ\uFFDFﾨﾐﾍﾓﾛ\uFFDE"));
    }
}