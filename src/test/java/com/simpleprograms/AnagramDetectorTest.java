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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit tests for the {@link AnagramDetector}.
 *
 * @author VitasSalvantes
 * @version 1.0.1
 */
class AnagramDetectorTest {

    private AnagramDetector anagramDetector;
    private String testString;

    @BeforeEach
    void setUp() {
        anagramDetector = new AnagramDetector("Primary string");
        testString = "Java";
    }

    @Test
    @DisplayName("Constructor")
    void testConstructor() {
        anagramDetector = new AnagramDetector(testString);
        assertEquals(anagramDetector.getPrimaryString(), testString);
    }

    @Test
    @DisplayName("Primary word getter")
    void getPrimaryString() {
        anagramDetector = new AnagramDetector(testString);
        assertEquals(anagramDetector.getPrimaryString(), testString);
    }

    @Test
    @DisplayName("Primary word setter")
    void setPrimaryString() {
        anagramDetector.setPrimaryString(testString);
        assertEquals(anagramDetector.getPrimaryString(), testString);
    }

    @Test
    @DisplayName("Null string")
    void testNullString() {
        assertThrows(IllegalArgumentException.class, () -> new AnagramDetector(null));
        assertThrows(IllegalArgumentException.class, () -> anagramDetector.setPrimaryString(null));
        assertThrows(IllegalArgumentException.class, () -> anagramDetector.checkForAnagram(null));
    }

    @Test
    @DisplayName("Empty string")
    void testEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> new AnagramDetector(""));
        assertThrows(IllegalArgumentException.class, () -> anagramDetector.setPrimaryString(""));
        assertThrows(IllegalArgumentException.class, () -> anagramDetector.checkForAnagram(""));
    }

    @Test
    @DisplayName("Checking for an anagram")
    void checkForAnagram() {
        anagramDetector.setPrimaryString("mama");

        testString = "amam";
        assertTrue(anagramDetector.checkForAnagram(testString));

        testString = "amma";
        assertTrue(anagramDetector.checkForAnagram(testString));

        testString = "aamm";
        assertTrue(anagramDetector.checkForAnagram(testString));

        testString = "mama ";
        assertFalse(anagramDetector.checkForAnagram(testString));

        testString = "ma";
        assertFalse(anagramDetector.checkForAnagram(testString));

        testString = "MamA";
        assertFalse(anagramDetector.checkForAnagram(testString));

        testString = "maaaammmmma";
        assertFalse(anagramDetector.checkForAnagram(testString));

        anagramDetector.setPrimaryString("papa");

        testString = "appa";
        assertTrue(anagramDetector.checkForAnagram(testString));

        testString = "mama";
        assertFalse(anagramDetector.checkForAnagram(testString));
    }
}
