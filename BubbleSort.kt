/**
 * Example of bubble sort implementation
 *
 * @author VitasSalvantes
 * @version 1.0
 */
fun main() {
    val array = arrayOf(10, 4, 6, 0, 5, 8, 9, 1, 3, 2, 7)

    for (i in array) {
        for (j in 0..array.size - 2) {
            if (array[j] > array[j + 1]) {
                array[j] += array[j + 1]
                array[j + 1] = array[j] - array[j + 1]
                array[j] -= array[j + 1]
            }
        }
    }

    print(array.contentToString())
}