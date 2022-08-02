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

package com.simpleprograms

/**
 * Finds integer roots of a polynomial using Horner's method.
 *
 * @author Ivan Bobrov
 * @version 1.0.1
 */
// Ax^4 + Bx^3 + Cx^2 + Dx + E = 0
// A, B, C, D, E - coefficients
// x - variable
// Ax^4 != 0 => 4 roots
fun main() {
    // 0x^4 + 0x^3 + x^2 - x - 2 = 0, roots: -1, 2
    // Coefficients
    val coefficientA = 0
    val coefficientB = 0
    val coefficientC = 1
    val coefficientD = -1
    val coefficientE = -2
    val coefficients = listOf(coefficientA, coefficientB, coefficientC, coefficientD, coefficientE)

    // Minimum value of the checkable root
    val minEquationRoot = -2

    // Maximum value of the checkable root
    val maxEquationRoot = 3

    // "Correct" roots
    val roots = mutableSetOf<Int>()

    // "Wrong" roots
    val notRoots = mutableSetOf<Int>()

    // Check all roots from minimum to maximum root
    for (verifiableRoot in minEquationRoot..maxEquationRoot) {
        // If the root has already been checked, then skip it
        if (roots.contains(verifiableRoot) || notRoots.contains(verifiableRoot)) continue

        if (checkRoot(coefficients, verifiableRoot)) {
            roots.add(verifiableRoot)
        } else {
            notRoots.add(verifiableRoot)
        }
    }

    if (roots.isNotEmpty()) {
        println(roots.sorted())
    } else {
        println(
            "There are no integer roots in $minEquationRoot..$maxEquationRoot range. " +
                    "Check the correctness of the input and try to increase the range."
        )
    }
}

/**
 * Checks a root using Horner's method.
 */
fun checkRoot(coefficients: List<Int>, verifiableRoot: Int): Boolean {
    // The sum of the product of the root by the current value (according to the scheme) and the next coefficient
    var result = 0

    // See Horner's method
    for (coefficient in coefficients) {
        result = verifiableRoot * result + coefficient
    }

    // If there is no remainder as a result (the result is 0), then the correct root is found
    return result == 0
}
