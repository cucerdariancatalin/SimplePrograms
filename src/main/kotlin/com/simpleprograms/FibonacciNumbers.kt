package com.simpleprograms

/**
 * Example of Fibonacci numbers implementation
 * 
 * @author VitasSalvantes
 * @version 1.0
 */
fun main() {
    println("- How many numbers?")
    val numberOfNumbers = readLine()?.toInt() ?: 1
    print(makeFibonacciNumbers(numberOfNumbers))
}

/** Method that generates Fibonacci numbers */
fun makeFibonacciNumbers(numberOfNumbers: Int): String {
    var fibonacciNumbers: String = "Your numbers: 1 "
    var nextNumber = 1
    var previousNumber = 0
    var currentNumber: Int
    var counter = numberOfNumbers

    while (counter > 1) {
        currentNumber = previousNumber + nextNumber
        previousNumber = nextNumber
        nextNumber = currentNumber
        fibonacciNumbers += "$currentNumber "

        counter--
    }

    return fibonacciNumbers
}