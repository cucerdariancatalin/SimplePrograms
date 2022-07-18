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
 * Run the program that prints a cake in the console depending on the age of the birthday person
 *
 * @author VitasSalvantes
 */
fun main() {
    // The age of the birthday person
    val age = 24
    // The number of the layers in the cake
    val layers = 5

    printCakeCandles(age)
    printCakeTop(age)
    printCakeBottom(age, layers)
}

/**
 * Function for printing candles on a cake
 *
 * @param age the age of the birthday person
 */
fun printCakeCandles(age: Int) {
    print(" ")
    repeat(age) {
        print(",")
    }

    println()

    print(" ")
    repeat(age) {
        print("|")
    }

    println()
}

/**
 * Function for printing the top layer of a cake
 *
 * @param age the age of the birthday person
 */
fun printCakeTop(age: Int) {
    repeat(age + 2) {
        print("=")
    }
    println()
}

/**
 * Function for printing the bottom layers of a cake
 *
 * @param age the age of the birthday person
 * @param layers the number of the layers in the cake
 */
fun printCakeBottom(age: Int, layers: Int) {
    repeat(layers) {
        repeat(age + 2) {
            print("@")
        }
        println()
    }
}