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

import java.util.Scanner;

/**
 * The program to find the first unique character in a string.
 *
 * @author VitasSalvantes
 * @version 2.0.0
 */
public class FirstUniqueCharacterInString {

    public static @Nullable Character findFirstUniqueChar(final @NotNull String string) {
        validateString(string);

        final char[] chars = string.toCharArray();

        for (char uniqueCharCandidate : chars) {
            int occurrenceNumber = 0;

            for (char character : chars) {
                if (uniqueCharCandidate == character) {
                    occurrenceNumber++;
                }
            }

            if (occurrenceNumber == 1) {
                return uniqueCharCandidate;
            }
        }

        return null;
    }

    /**
     * Validates a string.
     *
     * @param string the string to be validated.
     */
    private static void validateString(final String string) {
        if (string == null) {
            throw new IllegalArgumentException("The string must not be null");
        }

        if (string.length() == 0) {
            throw new IllegalArgumentException("The string must not be empty");
        }
    }

    /**
     * The example of using the program.
     */
    public static void main(String[] args) {
        System.out.println("- String?");
        final String string = new Scanner(System.in).nextLine();

        System.out.printf("The first unique char: %c", FirstUniqueCharacterInString.findFirstUniqueChar(string));
    }
}
