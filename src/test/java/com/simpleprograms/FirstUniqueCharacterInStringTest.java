/*
 * MIT License
 *
 * Copyright (c) 2022 VitasSalvantes
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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for the {@link FirstUniqueCharacterInString}.
 *
 * @author VitasSalvantes
 * @version 1.0.0
 */
class FirstUniqueCharacterInStringTest {

    @Test
    @DisplayName("Find the first unique character in a valid string")
    void findFirstUniqueChar() {
        assertEquals('a', FirstUniqueCharacterInString.findFirstUniqueChar("a"));
        assertEquals('a', FirstUniqueCharacterInString.findFirstUniqueChar("aA"));
        assertEquals('e', FirstUniqueCharacterInString.findFirstUniqueChar("HelloH"));
        assertEquals('W', FirstUniqueCharacterInString.findFirstUniqueChar("Hello World! Hello!"));
        assertNull(FirstUniqueCharacterInString.findFirstUniqueChar("Hello World! Hello World!"));
    }

    @Test
    @DisplayName("Find the first unique character in an invalid string")
    void findFirstUniqueCharInvalidString() {
        //noinspection ConstantConditions
        assertThrows(IllegalArgumentException.class, () -> FirstUniqueCharacterInString.findFirstUniqueChar(null));
        assertThrows(IllegalArgumentException.class, () -> FirstUniqueCharacterInString.findFirstUniqueChar(""));
    }
}
