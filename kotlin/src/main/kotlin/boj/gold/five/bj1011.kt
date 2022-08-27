package boj.gold.five

import kotlin.math.sqrt

fun main() {
    val N = readln().toInt()
    for (i in (0 until N)) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        println(solve(x, y))
    }
}

fun solve(x: Int, y: Int): Int {
    val sqrt = sqrt((y - x).toDouble())
    val ans = sqrt.toInt() * 2 // peak * 2
    val fraction = sqrt.rem(1)
    return if (fraction == 0.0) ans - 1 else if (fraction < 0.5) ans else ans + 1
}
