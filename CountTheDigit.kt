/**
 * Run a program that counts the number of repetitions of a digit in range of numbers.
 *
 * @author VitasSalvantes
 */
fun main() {
    // Largest number in range
    val largestNumber = 140_132_412

    // Desired digit
    val desiredDigit = 1

    // Number of repetitions of a digit
    var counter = 0

    /* Each number in the range is represented as a string, and the desired digit is represented as a character,
    after which is counted the number of repetitions of a character in a string */
    for (number in 0..largestNumber) {
        for (char in "$number") {
            if (char == desiredDigit.digitToChar()) counter++
        }

        // If the largest number is huge, then the program can take quite a long time
        when (number) {
            1_000_000 -> println("Please wait...")
            100_000_000 -> println("Please wait longer...")
            1_000_000_000 -> {
                println("I was bored. Count it yourself!")
                break
            }
        }
    }

    println("The digit $desiredDigit occurs in sequence from 0 to $largestNumber $counter times")
}