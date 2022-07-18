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
 * The program to count the number of repetitions of a digit in range of numbers.
 *
 * @author VitasSalvantes
 * @version 1.0.1
 */
fun main() {
    val largestNumber = 140_132_412

    val desiredDigit = 1

    var counter = 0

    for (number in 0..largestNumber) {
        for (char in "$number") {
            if (char == desiredDigit.digitToChar()) counter++
        }

        // If the largest number is huge, then the program can take quite a long time
        @Suppress("KotlinConstantConditions")
        when (number) {
            1_000_000 -> println("Please wait...")
            100_000_000 -> println("Please wait longer...")
            1_000_000_000 -> {
                println("I was bored. Count it yourself!")
                break
            }
        }
    }

    println("The digit $desiredDigit occurs in sequence from 0 to $largestNumber $counter times")
}
