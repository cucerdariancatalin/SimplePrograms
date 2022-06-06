package com.simpleprograms;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit tests for the {@link BoxComparator}.
 *
 * @author VitasSalvantes
 * @version 1.0
 */
class BoxComparatorTest {

    private int[] testBox1;
    private int[] testBox2;

    @BeforeEach
    void setUp() {
        testBox1 = new int[] {1, 2, 3};
        testBox2 = new int[] {4, 5, 6};
    }

    @AfterEach
    void tearDown() {
        testBox1 = null;
        testBox2 = null;
    }

    @Test
    @DisplayName("Check the boxes are nestable")
    void checkNestable() {
        final String box1IsGreater = "Box 1 > Box 2";
        final String box2IsGreater = "Box 1 < Box 2";
        final String incompatible = "Incompatible";

        assertEquals(box2IsGreater, BoxComparator.checkNestable(testBox1, testBox2));
        assertEquals(box1IsGreater, BoxComparator.checkNestable(testBox2, testBox1));

        testBox2 = testBox1;
        assertEquals(incompatible, BoxComparator.checkNestable(testBox1, testBox2));

        testBox1 = new int[] {3, 2, 1};
        testBox2 = new int[] {5, 6, 4};
        assertEquals(box2IsGreater, BoxComparator.checkNestable(testBox1, testBox2));

        testBox1 = new int[]{4, 2, 8};
        testBox2 = new int[]{3, 2, 1};
        assertEquals(box1IsGreater, BoxComparator.checkNestable(testBox1, testBox2));

        testBox2 = new int[]{2, 9, 1};
        assertEquals(incompatible, BoxComparator.checkNestable(testBox1, testBox2));
    }

    @Test
    @DisplayName("Null box")
    void testNullBox() {
        testBox1 = null;
        assertThrows(IllegalArgumentException.class, () -> BoxComparator.checkNestable(testBox1, testBox2));

        testBox1 = new int[] {1, 2, 3};
        testBox2 = null;
        assertThrows(IllegalArgumentException.class, () -> BoxComparator.checkNestable(testBox1, testBox2));

    }

    @Test
    @DisplayName("Unsuitable box")
    void testUnsuitableBox() {
        testBox1 = new int[0];
        assertThrows(IllegalArgumentException.class, () -> BoxComparator.checkNestable(testBox1, testBox2));

        testBox1 = new int[] {1, 2, 3};
        testBox2 = new int[2];
        assertThrows(IllegalArgumentException.class, () -> BoxComparator.checkNestable(testBox1, testBox2));

        testBox2 = new int[] {1, -2, 3};
        assertThrows(IllegalArgumentException.class, () -> BoxComparator.checkNestable(testBox1, testBox2));

        testBox1 = new int[] {1, 2, 0};
        testBox2 = new int[] {1, 2, 3};
        assertThrows(IllegalArgumentException.class, () -> BoxComparator.checkNestable(testBox1, testBox2));
    }
}