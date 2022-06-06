package com.simpleprograms;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit tests for the {@link CaesarCipher}.
 *
 * @author VitasSalvantes
 * @version 1.0
 */
class CaesarCipherTest {

    private CaesarCipher caesarCipher;
    private String testKey;

    @BeforeEach
    void setUp() {
        testKey = "Key";
        caesarCipher = new CaesarCipher(testKey);
    }

    @AfterEach
    void tearDown() {
        testKey = null;
        caesarCipher = null;
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