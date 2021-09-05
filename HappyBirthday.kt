/**
 * Run the program that prints a cake in the console depending on the age of the birthday person
 *
 * @author VitasSalvantes
 */
fun main() {
    // The age of the birthday person
    val age = 24
    // The number of the layers in the cake
    val layers = 5

    printCakeCandles(age)
    printCakeTop(age)
    printCakeBottom(age, layers)
}

/**
 * Function for printing candles on a cake
 *
 * @param age the age of the birthday person
 */
fun printCakeCandles(age: Int) {
    print(" ")
    repeat(age) {
        print(",")
    }

    println()

    print(" ")
    repeat(age) {
        print("|")
    }

    println()
}

/**
 * Function for printing the top layer of a cake
 *
 * @param age the age of the birthday person
 */
fun printCakeTop(age: Int) {
    repeat(age + 2) {
        print("=")
    }
    println()
}

/**
 * Function for printing the bottom layers of a cake
 *
 * @param age the age of the birthday person
 * @param layers the number of the layers in the cake
 */
fun printCakeBottom(age: Int, layers: Int) {
    repeat(layers) {
        repeat(age + 2) {
            print("@")
        }
        println()
    }
}