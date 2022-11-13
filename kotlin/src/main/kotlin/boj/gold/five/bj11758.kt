package boj.gold.five

fun main() {
    val (x1, y1) = readln().split(" ").map { it.toInt() }
    val (x2, y2) = readln().split(" ").map { it.toInt() }
    val (x3, y3) = readln().split(" ").map { it.toInt() }

    val a = x1 * y2 + x2 * y3 + x3 * y1
    val b = y1 * x2 + y2 * x3 + y3 * x1

    println(if (a - b > 0) 1 else if (a == b) 0 else -1)
}
