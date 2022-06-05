package com.simpleprograms

/**
 * The program to implement the bubble sort algorithm.
 *
 * @author VitasSalvantes
 * @version 1.5
 */
fun main() {
    val array = arrayOf(10, 4, 6, 0, 5, 8, 9, 1, 3, 2, 7)
    var buffer: Int

    for (i in array.indices) {
        for (j in 1 until array.size) {
            if (array[j - 1] > array[j]) {
                buffer = array[j - 1]
                array[j - 1] = array[j]
                array[j] = buffer
            }
        }
    }

    print(array.contentToString())
}