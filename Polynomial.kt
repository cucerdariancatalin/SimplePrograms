import kotlin.test.todo

// Ax^4 + Bx^3 + Cx^2 + Dx + E = 0
// A, B, C, D, E - coefficients
// x - variable
// Ax^4 != 0 => 4 roots
fun main() {
    // 0x^4 + 0x^3 + x^2 - x - 2 = 0, roots: -1, 2
    val A = 0
    val B = 0
    val C = 1
    val D = -1
    val E = -2

    val coefficients = listOf(A, B, C, D, E)
    var minEquationRoot = -2
    var maxEquationRoot = 3
    val roots = mutableSetOf<Int>()
    TODO("Add <Boolean>")

    for (verifiableRoot in minEquationRoot..maxEquationRoot) {
        if(checkRoot(coefficients, verifiableRoot)) {
            roots.add(verifiableRoot)
            TODO("Add if verifiableRoot exist...")
        }
    }

    if (roots.isNotEmpty()) {
        println(roots)
    } else {
        println("Something is wrong...")
    }
}

fun checkRoot(coefficients: List<Int>, verifiableRoot: Int): Boolean {
    // Yeah!
    var result = 0
    for (coefficients in coefficients) {
        result = verifiableRoot * result + coefficients
    }
    // Yeah!
    return result == 0
}
