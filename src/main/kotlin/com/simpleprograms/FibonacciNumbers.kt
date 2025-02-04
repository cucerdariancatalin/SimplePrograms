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
 * Simple implementation of the Fibonacci numbers.
 *
 * @author Ivan Bobrov
 * @version 2.0.0
 */
fun main() {
    println("- How many numbers?")
    val numberOfNumbers = readLine()?.toInt() ?: 1
    print(makeFibonacciNumbers(numberOfNumbers))
}

/**
 * Computes Fibonacci numbers.
 */
fun makeFibonacciNumbers(maxIndex: Int) {
    var nextNumber = 0
    var sum = 1

    for (index in 1..maxIndex) {
        print("$nextNumber" + if (index == maxIndex) "\n" else ", ")

        val currentNumber = nextNumber
        nextNumber = sum
        sum += currentNumber
    }
}
