import kotlin.test.todo

/**
 * Run the program that finds the integer roots of a polynomial
 *
 * @author VitasSalvantes
 */
// Ax^4 + Bx^3 + Cx^2 + Dx + E = 0
// A, B, C, D, E - coefficients
// x - variable
// Ax^4 != 0 => 4 roots
// TODO: 16.09.2021 Create class polynomial
fun main() {
    // 0x^4 + 0x^3 + x^2 - x - 2 = 0, roots: -1, 2
    // Coefficients
    // TODO: 16.09.2021 Add user's input
    val A = 0
    val B = 0
    val C = 1
    val D = -1
    val E = -2
    val coefficients = listOf(A, B, C, D, E)

    // Minimum value of the checkable root
    var minEquationRoot = -2

    // Maximum value of the checkable root
    var maxEquationRoot = 3

    // "Correct" roots
    val roots = mutableSetOf<Int>()

    // "Wrong" roots
    val notRoots = mutableSetOf<Int>()

    // Check all roots from minimum to maximum root
    for (verifiableRoot in minEquationRoot..maxEquationRoot) {
        // If the root has already been checked, then skip it
        if (roots.contains(verifiableRoot) || notRoots.contains(verifiableRoot)) continue

        if (checkRoot(coefficients, verifiableRoot)) {
            roots.add(verifiableRoot)
        } else {
            notRoots.add(verifiableRoot)
        }
    }

    if (roots.isNotEmpty()) {
        println(roots.sorted())
    } else {
        TODO("Add setting a new range")
        println(
            "There are no integer roots in $minEquationRoot..$maxEquationRoot range. " +
                    "Check the correctness of the input and try to increase the range."
        )
    }
}

/**
 * Root check using Horner's scheme
 */
fun checkRoot(coefficients: List<Int>, verifiableRoot: Int): Boolean {
    // The sum of the product of the root by the current value (according to the scheme) and the next coefficient
    var result = 0

    // See Horner's scheme
    for (coefficient in coefficients) {
        result = verifiableRoot * result + coefficient
    }

    // If there is no remainder as a result (the result is 0), then the correct root is found
    return result == 0
}
