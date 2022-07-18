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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit tests for the {@link AtbashCipher}.
 *
 * @author VitasSalvantes
 * @version 1.0.1
 */
class AtbashCipherTest {

    private AtbashCipher atbashCipher;
    private String testMessage;

    @BeforeEach
    void setUp() {
        atbashCipher = new AtbashCipher();
        testMessage = "Java";
    }

    @Test
    @DisplayName("Process message")
    void processMessage() {
        assertNotEquals(testMessage, atbashCipher.processMessage(testMessage));

        testMessage = "Hello, World!";
        assertEquals("ﾷﾚﾓﾓﾐￓ\uFFDFﾨﾐﾍﾓﾛ\uFFDE", atbashCipher.processMessage(testMessage));
    }

    @Test
    @DisplayName("Empty message")
    void testEmptyMessage() {
        testMessage = "";

        assertThrows(IllegalArgumentException.class, () -> atbashCipher.processMessage(testMessage));
    }

    @Test
    @DisplayName("Null message")
    void testNullMessage() {
        testMessage = null;

        assertThrows(IllegalArgumentException.class, () -> atbashCipher.processMessage(testMessage));
    }
}