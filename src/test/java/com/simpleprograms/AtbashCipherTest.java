package com.simpleprograms;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for the {@link AtbashCipher}.
 *
 * @author VitasSalvantes
 * @version 1.0
 */
class AtbashCipherTest {

    private AtbashCipher atbashCipher;
    private String testMessage;

    @BeforeEach
    void setUp() {
        atbashCipher = new AtbashCipher();
        testMessage = "Java";
    }

    @AfterEach
    void tearDown() {
        atbashCipher = null;
        testMessage = null;
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