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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit tests for the {@link RightRotation}.
 *
 * @author Ivan Bobrov
 * @version 1.0.0
 */
class RightRotationTest {

    @Test
    @DisplayName("Rotate an array right")
    void rotate() {
        int[] testArray = new int[]{1, 2, 3, 4, 5};
        RightRotation.rotate(testArray, 0);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, testArray);

        testArray = new int[]{1, 2, 3, 4, 5};
        RightRotation.rotate(testArray, testArray.length * 10);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, testArray);

        testArray = new int[]{2, 3, 4, 5, 1};
        RightRotation.rotate(testArray, 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, testArray);

        testArray = new int[]{5, 1, 2, 3, 4};
        RightRotation.rotate(testArray, 4);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, testArray);

        testArray = new int[]{1};
        RightRotation.rotate(testArray, 10);
        assertArrayEquals(new int[]{1}, testArray);
    }

    @Test
    @DisplayName("Rotate an invalid array right")
    void rotateInvalidArray() {
        //noinspection ConstantConditions
        assertThrows(IllegalArgumentException.class, () -> RightRotation.rotate(null, 1));
        assertThrows(IllegalArgumentException.class, () -> RightRotation.rotate(new int[0], 1));
    }

    @Test
    @DisplayName("Rotate an array right by an invalid rotation number")
    void rotateInvalidRotationNumber() {
        for (int i = -10; i < 0; i++) {
            final int finalI = i;
            assertThrows(IllegalArgumentException.class, () -> RightRotation.rotate(new int[]{1}, finalI));
        }
    }

}
