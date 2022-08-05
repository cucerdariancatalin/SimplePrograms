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

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The program rotates a rectangle array by 90 degrees clockwise.
 *
 * @author Ivan Bobrov
 * @version 2.0.0
 */
public class RotateRectangleArray {

    /**
     * Rotates a rectangle array right.
     *
     * @param array the rectangle array to be rotated.
     *
     * @return a rotated copy of the rectangle array.
     */
    public static int @NotNull [] @NotNull [] rotate(final int @NotNull [] @NotNull [] array) {
        validateRectangleArray(array);
        final int @NotNull [] @NotNull [] rotatedArray = new int[array[0].length][array.length];

        for (int i = 0; i < rotatedArray.length; i++) {
            for (int j = 0; j < rotatedArray[i].length; j++) {
                rotatedArray[i][j] = array[array.length - 1 - j][i];
            }
        }

        return rotatedArray;
    }

    /**
     * Validates a rectangle array.
     *
     * @param array the rectangle array to be validated.
     */
    private static void validateRectangleArray(final int @Nullable [] @Nullable [] array) {
        if (array == null) {
            throw new IllegalArgumentException("The array must not be null");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("The array must not be empty");
        }

        for (int[] row : array) {
            if (row == null) {
                throw new IllegalArgumentException("The row must not be null");
            }

            if (row.length == 0) {
                throw new IllegalArgumentException("The row must not be empty");
            }

            //noinspection ConstantConditions
            if (row.length != array[0].length) {
                throw new IllegalArgumentException("The array must be rectangle");
            }
        }
    }

    /**
     * The example of using the program.
     */
    public static void main(String[] args) {
        final int[][] rotatedArray = RotateRectangleArray.rotate(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        });

        for (int[] row : rotatedArray) {
            for (int i = 0; i < row.length; i++) {
                System.out.printf("%d" + (i == row.length - 1 ? "%n" : " "), row[i]);
            }
        }
    }

}
