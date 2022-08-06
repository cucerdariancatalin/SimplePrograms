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

import java.util.Arrays;

/**
 * Implementation of the right rotation.
 *
 * @author Ivan Bobrov
 * @version 2.0.0
 */
public class RightRotation {

    /**
     * Rotates an array right.
     *
     * @param array          the array to be rotated.
     * @param rotationNumber the number of rotations.
     */
    public static void rotate(final int @NotNull [] array, final int rotationNumber) {
        validateArray(array);
        validateRotationNumber(rotationNumber);
        final int optimizedRotationNumber = rotationNumber % array.length;

        for (int i = 0; i < optimizedRotationNumber; i++) {
            final int buffer = array[array.length - 1];
            System.arraycopy(array, 0, array, 1, array.length - 1);
            array[0] = buffer;
        }
    }

    /**
     * Validates an array.
     *
     * @param array the array to be validated.
     */
    private static void validateArray(final int @Nullable [] array) {
        if (array == null) {
            throw new IllegalArgumentException("The array must not be null");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("The array must not be empty");
        }
    }

    /**
     * Validates a rotation number.
     *
     * @param rotationNumber the number to be validated.
     */
    private static void validateRotationNumber(final int rotationNumber) {
        if (rotationNumber < 0) {
            throw new IllegalArgumentException("The rotation number must not be less than 0");
        }
    }



    /**
     * The example of using the program.
     */
    public static void main(String[] args) {
        final int[] array = {5, 1, 2, 3, 4};

        System.out.println(Arrays.toString(array));
        RightRotation.rotate(array, 4);
        System.out.println(Arrays.toString(array));
    }

}
