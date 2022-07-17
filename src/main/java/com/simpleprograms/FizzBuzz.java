/*
 * MIT License
 *
 * Copyright (c) 2022 VitasSalvantes
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

/**
 * The solution of the famous "FizzBuzz" task.
 *
 * @author VitasSalvantes
 * @version 3.0.1
 */

public class FizzBuzz {

    /**
     * Prints numbers from 1 to 100. It prints "Fizz" instead of multiples of three,
     * "Buzz" instead of multiples of five and "FizzBuzz" instead of multiples of both
     * three and five at the same time.
     */
    public static void doFizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            final String output;

            if (i % 15 == 0) {
                output = "FizzBuzz";
            } else if (i % 5 == 0) {
                output = "Buzz";
            } else if (i % 3 == 0) {
                output = "Fizz";
            } else {
                output = Integer.toString(i);
            }

            System.out.printf("%s%s", output, i == 100 ? "\n" : ", ");
        }
    }

    /**
     * The example of using the program.
     */
    public static void main(String[] args) {
        FizzBuzz.doFizzBuzz();
    }
}
