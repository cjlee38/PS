package boj.gold.five

import kotlin.math.min

private val MAX = 987653210

fun main() {
    val N = readln().toInt() // number of cities
    val M = readln().toInt() // number of buses

    val board = Array(N) { i -> IntArray(N) }

    (0 until M).map {
        readln().split(" ")
            .map { it.toInt() }
    }.forEach {
        if (board[it[0]][it[1]] == 0) {
            board[it[0]][it[1]] = it[2]
        } else {
            board[it[0]][it[1]] = min(board[it[0]][it[1]], it[2])
        }
    }
    val (source, destination) = readln().split(" ").map { it.toInt() }

    val directions = IntArray(N) { MAX }
    directions[source - 1] = 0

}
