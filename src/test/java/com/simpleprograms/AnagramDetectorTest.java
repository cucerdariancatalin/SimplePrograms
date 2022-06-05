package com.simpleprograms;

import org.junit.jupiter.api.*;

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
        Assertions.assertEquals(anagramDetector.getPrimaryString(), testString);
    }

    @Test
    @DisplayName("Primary word getter")
    void testGetter() {
        anagramDetector = new AnagramDetector(testString);
        Assertions.assertEquals(anagramDetector.getPrimaryString(), testString);
    }

    @Test
    @DisplayName("Primary word setter")
    void testSetter() {
        anagramDetector.setPrimaryString(testString);
        Assertions.assertEquals(anagramDetector.getPrimaryString(), testString);
    }

    @Test
    @DisplayName("Null string")
    void testNullCharacterSet() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new AnagramDetector(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> anagramDetector.setPrimaryString(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> anagramDetector.checkForAnagram(null));
    }

    @Test
    @DisplayName("Empty string")
    void testEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new AnagramDetector(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> anagramDetector.setPrimaryString(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> anagramDetector.checkForAnagram(""));
    }

    @Test
    @DisplayName("Checking for an anagram")
    void testCheckForAnagram() {
        anagramDetector.setPrimaryString("mama");

        testString = "amam";
        Assertions.assertTrue(anagramDetector.checkForAnagram(testString));

        testString = "amma";
        Assertions.assertTrue(anagramDetector.checkForAnagram(testString));

        testString = "aamm";
        Assertions.assertTrue(anagramDetector.checkForAnagram(testString));

        testString = "mama ";
        Assertions.assertFalse(anagramDetector.checkForAnagram(testString));

        testString = "ma";
        Assertions.assertFalse(anagramDetector.checkForAnagram(testString));

        testString = "MamA";
        Assertions.assertFalse(anagramDetector.checkForAnagram(testString));

        testString = "maaaammmmma";
        Assertions.assertFalse(anagramDetector.checkForAnagram(testString));

        anagramDetector.setPrimaryString("papa");

        testString = "appa";
        Assertions.assertTrue(anagramDetector.checkForAnagram(testString));

        testString = "mama";
        Assertions.assertFalse(anagramDetector.checkForAnagram(testString));
    }
}
