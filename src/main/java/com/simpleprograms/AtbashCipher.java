/*
 * MIT License
 *
 * Copyright (c) 2022 Ivan Bobrov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to
 * whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.simpleprograms;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The program to en- and decrypt messages using the Atbash cipher.
 *
 * @author Ivan Bobrov
 * @version 5.0.3
 */
public class AtbashCipher {

    /**
     * En- or decrypts the message using the Atbash cipher.
     *
     * @param inputMessage the message to be en- or decrypted.
     *
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
     * Validates an input message.
     *
     * @param message the string to be validated.
     */
    private void validateMessage(final @Nullable String message) {
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
