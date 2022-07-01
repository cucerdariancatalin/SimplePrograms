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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit tests for the {@link CaesarCipher}.
 *
 * @author VitasSalvantes
 * @version 1.0.1
 */
class CaesarCipherTest {

    private CaesarCipher caesarCipher;
    private String testKey;

    @BeforeEach
    void setUp() {
        testKey = "Key";
        caesarCipher = new CaesarCipher(testKey);
    }

    @Test
    @DisplayName("Constructor")
    void testConstructor() {
        caesarCipher = new CaesarCipher(testKey);
        assertEquals(testKey, caesarCipher.getKey());
    }

    @Test
    @DisplayName("Setter")
    void setKey() {
        testKey = "My key";
        caesarCipher.setKey(testKey);
        assertEquals(testKey, caesarCipher.getKey());
    }

    @Test
    @DisplayName("Getter")
    void getKey() {
        caesarCipher = new CaesarCipher(testKey);
        assertEquals(testKey, caesarCipher.getKey());
    }

    @Test
    @DisplayName("Process the user message")
    void processMessage() {
        String testMessage = "Hello, World!";
        String expectedOutput = "\u008C©°°³pd\u009B³¶°¨e";
        assertEquals(expectedOutput, caesarCipher.processMessage(testMessage, true));

        testMessage = expectedOutput;
        expectedOutput = "Hello, World!";
        assertEquals(expectedOutput, caesarCipher.processMessage(testMessage, false));
    }

    @Test
    @DisplayName("Null input")
    void testNullInput() {
        assertThrows(IllegalArgumentException.class, () -> new CaesarCipher(null));
        assertThrows(IllegalArgumentException.class, () -> caesarCipher.setKey(null));
    }

    @Test
    @DisplayName("Empty input")
    void testEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> new CaesarCipher(""));
        assertThrows(IllegalArgumentException.class, () -> caesarCipher.setKey(""));
    }
}