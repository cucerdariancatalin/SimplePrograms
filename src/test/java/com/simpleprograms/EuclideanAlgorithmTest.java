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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JUnit tests for the {@link EuclideanAlgorithm}.
 *
 * @author Ivan Bobrov
 * @version 1.0.1
 */
class EuclideanAlgorithmTest {

    int testFirstInteger;
    int testSecondInteger;



    @Test
    @DisplayName("Calculate GCD of the valid integers")
    void calculateGCD() {
        testFirstInteger = 1;
        testSecondInteger = testFirstInteger;
        assertEquals(1, EuclideanAlgorithm.calculateGCD(testFirstInteger, testSecondInteger));

        testFirstInteger = 4;
        testSecondInteger = 2;
        assertEquals(2, EuclideanAlgorithm.calculateGCD(testFirstInteger, testSecondInteger));
        assertEquals(2, EuclideanAlgorithm.calculateGCD(testSecondInteger, testFirstInteger));

        testFirstInteger = 544;
        testSecondInteger = 391;
        assertEquals(17, EuclideanAlgorithm.calculateGCD(testFirstInteger, testSecondInteger));

        testFirstInteger = 123;
        testSecondInteger = 1673598;
        assertEquals(3, EuclideanAlgorithm.calculateGCD(testFirstInteger, testSecondInteger));

        testFirstInteger = 2;
        testSecondInteger = 17;
        assertEquals(1, EuclideanAlgorithm.calculateGCD(testFirstInteger, testSecondInteger));
    }

    @Test
    @DisplayName("Calculate GCD of the invalid integers")
    void calculateGCDInvalidIntegers() {
        testFirstInteger = 0;
        testSecondInteger = testFirstInteger;
        assertThrows(
                IllegalArgumentException.class,
                () -> EuclideanAlgorithm.calculateGCD(testFirstInteger, testSecondInteger)
        );

        testFirstInteger = 0;
        testSecondInteger = 1;
        assertThrows(
                IllegalArgumentException.class,
                () -> EuclideanAlgorithm.calculateGCD(testFirstInteger, testSecondInteger)
        );

        testFirstInteger = 1;
        testSecondInteger = 0;
        assertThrows(
                IllegalArgumentException.class,
                () -> EuclideanAlgorithm.calculateGCD(testFirstInteger, testSecondInteger)
        );

        testFirstInteger = -1;
        testSecondInteger = 1;
        assertThrows(
                IllegalArgumentException.class,
                () -> EuclideanAlgorithm.calculateGCD(testFirstInteger, testSecondInteger)
        );
    }

}
