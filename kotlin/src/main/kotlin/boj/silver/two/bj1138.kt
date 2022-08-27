package boj.silver.two

fun main() {
    val N = readln().toInt()
    val lefts = readln().split(" ").map { it.toInt() }

    val line = (0 until N).map { 0 }.toMutableList()

    for ((num, left) in lefts.withIndex()) {
        var life = left
        for (i in 0 until line.size) {
            if (life == 0 && line[i] == 0) {
                line[i] = num + 1
                break
            }
            if (line[i] == 0) life--
        }
    }

    println(line.joinToString(" "))
}
