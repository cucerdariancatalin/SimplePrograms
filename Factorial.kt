/**
 * Example of factorial implementation
 *
 * @author VitasSalvantes
 * @version 1.0
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