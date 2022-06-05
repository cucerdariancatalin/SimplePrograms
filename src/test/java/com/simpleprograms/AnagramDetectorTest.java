package com.simpleprograms;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for the {@link AnagramDetector}.
 *
 * @author VitasSalvantes
 * @version 1.0
 */
class AnagramDetectorTest {

    private AnagramDetector anagramDetector;
    private String testString;

    @BeforeEach
    void setUp() {
        anagramDetector = new AnagramDetector("Primary string");
        testString = "Java";
    }

    @AfterEach
    void tearDown() {
        anagramDetector = null;
        testString = null;
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
