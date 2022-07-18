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
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit tests for the {@link BoxComparator}.
 *
 * @author VitasSalvantes
 * @version 1.0.1
 */
class BoxComparatorTest {

    private int[] testBox1;
    private int[] testBox2;

    @BeforeEach
    void setUp() {
        testBox1 = new int[]{1, 2, 3};
        testBox2 = new int[]{4, 5, 6};
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

        testBox1 = new int[]{3, 2, 1};
        testBox2 = new int[]{5, 6, 4};
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

        testBox1 = new int[]{1, 2, 3};
        testBox2 = null;
        assertThrows(IllegalArgumentException.class, () -> BoxComparator.checkNestable(testBox1, testBox2));

    }

    @Test
    @DisplayName("Unsuitable box")
    void testUnsuitableBox() {
        testBox1 = new int[0];
        assertThrows(IllegalArgumentException.class, () -> BoxComparator.checkNestable(testBox1, testBox2));

        testBox1 = new int[]{1, 2, 3};
        testBox2 = new int[2];
        assertThrows(IllegalArgumentException.class, () -> BoxComparator.checkNestable(testBox1, testBox2));

        testBox2 = new int[]{1, -2, 3};
        assertThrows(IllegalArgumentException.class, () -> BoxComparator.checkNestable(testBox1, testBox2));

        testBox1 = new int[]{1, 2, 0};
        testBox2 = new int[]{1, 2, 3};
        assertThrows(IllegalArgumentException.class, () -> BoxComparator.checkNestable(testBox1, testBox2));
    }
}