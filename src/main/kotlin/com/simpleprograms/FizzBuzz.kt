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
 * The program to print numbers from 1 to 100. It prints "Fizz" instead of multiples of
 * three, "Buzz" instead of multiples of five and "FizzBuzz" instead of multiples of both
 * three and five at the same time.
 *
 * @author VitasSalvantes
 * @version 1.1.1
 */
fun main() {
    for (i in 1..100) {
        val output = if (i % 15 == 0) {
            "FizzBuzz"
        } else if (i % 5 == 0) {
            "Buzz"
        } else if (i % 3 == 0) {
            "Fizz"
        } else {
            "$i"
        }

        print(output + if (i == 100) "\n" else ", ")
    }
}
