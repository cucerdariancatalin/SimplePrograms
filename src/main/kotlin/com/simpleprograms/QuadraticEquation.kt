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

import kotlin.math.sqrt

/**
 * Solves quadratic equations.
 *
 * @author Ivan Bobrov
 * @version 1.0.2
 */
fun main() {
    val a = 2.0
    val b = -5.0
    val c = -63.0

    val answers = if (a == 1.0) pqMethod(b, c) else discriminantMethod(a, b, c)

    println("Answer: ${answers.joinToString()}")
}

// x^2 + px + q = 0 or x^2 + bx + c = 0, a = 1
fun pqMethod(p: Double, q: Double): Array<Double> {
    val x1 = -p / 2 + sqrt((p / 2) * (p / 2) - q)
    val x2 = -p / 2 - sqrt((p / 2) * (p / 2) - q)

    return arrayOf(x1, x2)
}

// ax^2 + bx + c = 0
fun discriminantMethod(a: Double, b: Double, c: Double): Array<Double> {
    val discriminant = b * b - 4 * a * c
    val x1 = (-b + sqrt(discriminant)) / (2 * a)
    val x2 = (-b - sqrt(discriminant)) / (2 * a)

    return arrayOf(x1, x2)
}
