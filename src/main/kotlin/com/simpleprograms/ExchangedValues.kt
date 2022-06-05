package com.simpleprograms

/**
 * Example of exchanging the values of two variables without using the third
 * 
 * @author VitasSalvantes
 * @version 1.0
 */
fun  main() {
    var a = 1
    var b = 2
    println("$a and $b")
    a += b
    b = a - b
    a -= b
    println("$a and $b")
}