package com.simpleprograms

/**
 * Example that prints numbers from 1 to 100. But instead of
 * multiples of three, it prints "Fizz", and instead of numbers that are
 * multiples of five, - "Buzz". Instead of numbers that are multiples of both
 * three and five at the same time, it prints "FizzBuzz".
 * 
 * @author VitasSalvantes
 * @version 1.0
 */
fun main() {
    for (i in 1..100) {
        if (i % 15 == 0) {
            print("FizzBuzz ")
            continue
        }

        if (i % 5 == 0) {
            print("Buzz ")
            continue
        }

        if (i % 3 == 0) print("Fizz ") else print("$i ")
    }
}