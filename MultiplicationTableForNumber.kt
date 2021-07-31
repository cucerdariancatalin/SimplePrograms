/**
 * A program for printing the multiplication table of one number
 *
 * @author VitasSalvantes
 * @version 1.0
 */
fun main() {
    val firstNumber = 5
    var multiplicationTableForNumber = ""
    for (secondNumber in 1..10) multiplicationTableForNumber += "$firstNumber * $secondNumber = ${firstNumber * secondNumber}\n"

    println(multiplicationTableForNumber.trim())
}