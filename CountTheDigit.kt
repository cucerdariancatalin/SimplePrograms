fun main() {
    val maxNumber = 140_132_412
    val soughtDigit = 1

    var counter = 0

    for (number in 0..maxNumber) {
        for (char in "$number") {
            if (char == soughtDigit.digitToChar()) counter++
        }

        when (number) {
            1_000_000 -> println("Please wait...")
            100_000_000 -> println("Please wait longer...")
            1_000_000_000 -> {
                println("I was bored. Count it yourself!")
                break
            }
        }
    }

    println("The digit $soughtDigit occurs in sequence from 0 to $maxNumber $counter times")
}