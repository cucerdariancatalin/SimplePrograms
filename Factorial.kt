package com.vitassalvantes.hellokotlin

/**
 * @author VitasSalvantes
 * @version 1.0
 *
 * Method that launches the program
 */
fun main() {
    var result: Int = 1
    println("- Number?")
    var number: Int = readLine()?.toInt() ?: 0
    print("$number! = ")

    while (number > 0) {
        result *= number
        number = number.dec()
    }

    println(result)
}