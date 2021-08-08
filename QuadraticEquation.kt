import kotlin.math.sqrt

/**
 * A program for solving quadratic equations
 *
 * @author VitasSalvantes
 * @version 1.0
 */
fun main() {
    val a: Double = 2.0
    val b: Double = -5.0
    val c: Double = -63.0

    val answers = if (a == 1.0) pqMethod(b, c) else diskriminantMethod(a, b, c)

    println("Answer: ${answers.joinToString()}")

    println("Diskriminant: ${diskriminantMethod(a, b, c).joinToString()}")
    println("PQ-method: ${pqMethod(b, c).joinToString()}")
}

// x^2 + px + q = 0
fun pqMethod(p: Double, q: Double): Array<Double> {
    val x1 = -p / 2 + sqrt((p / 2) * (p / 2) - q)
    val x2 = -p / 2 - sqrt((p / 2) * (p / 2) - q)
    return arrayOf(x1, x2)
}

// ax^2 + bx + c = 0
fun diskriminantMethod(a: Double, b: Double, c: Double): Array<Double> {
    val diskriminant = b * b - 4 * a * c
    val x1 = (-b + sqrt(diskriminant)) / (2 * a)
    val x2 = (-b - sqrt(diskriminant)) / (2 * a)
    return arrayOf(x1, x2)
}
