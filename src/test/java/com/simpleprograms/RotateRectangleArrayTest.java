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

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit tests for the {@link RotateRectangleArray}.
 *
 * @author Ivan Bobrov
 * @version 1.0.0
 */
class RotateRectangleArrayTest {

    @Test
    @DisplayName("Rotate an array")
    void rotate() {
        assertTrue(Arrays.deepEquals(
                new int[][]{
                        {1},
                        {2},
                        {3}
                },
                RotateRectangleArray.rotate(
                        new int[][]{
                                {1, 2, 3}
                        }
                )
        ));

        assertTrue(Arrays.deepEquals(
                new int[][]{
                        {1, 2, 3}
                },
                RotateRectangleArray.rotate(
                        new int[][]{
                                {3},
                                {2},
                                {1}
                        }
                )
        ));

        assertTrue(Arrays.deepEquals(
                new int[][]{
                        {4, 1},
                        {5, 2},
                        {6, 3}
                },
                RotateRectangleArray.rotate(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6}
                        }
                )
        ));

        assertTrue(Arrays.deepEquals(
                new int[][]{
                        {6, 5, 4},
                        {3, 2, 1}
                },
                RotateRectangleArray.rotate(
                        new int[][]{
                                {4, 1},
                                {5, 2},
                                {6, 3}
                        }
                )
        ));
    }

    @Test
    @DisplayName("Rotate an invalid array")
    void rotateInvalidArray() {
        //noinspection ConstantConditions
        assertThrows(IllegalArgumentException.class, () -> RotateRectangleArray.rotate(null));
        assertThrows(IllegalArgumentException.class, () -> RotateRectangleArray.rotate(new int[0][0]));
        assertThrows(IllegalArgumentException.class, () -> RotateRectangleArray.rotate(new int[1][0]));

        //noinspection ConstantConditions
        assertThrows(
                IllegalArgumentException.class,
                () -> RotateRectangleArray.rotate(
                        new int[][]{
                                null,
                                {1, 2, 3}
                        }
                )
        );

        //noinspection ConstantConditions
        assertThrows(
                IllegalArgumentException.class,
                () -> RotateRectangleArray.rotate(
                        new int[][]{
                                {1, 2, 3},
                                null,
                                {4, 5, 6}
                        }
                )
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> RotateRectangleArray.rotate(
                        new int[][]{
                                {1, 2, 3},
                                {},
                                {4, 5, 6}
                        }
                )
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> RotateRectangleArray.rotate(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9, 10, 11}
                        }
                )
        );

    }

}
