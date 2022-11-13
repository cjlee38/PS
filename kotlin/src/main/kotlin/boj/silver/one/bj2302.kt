package boj.silver.one

const val MAX = 40

fun main() {
    val N = readln().toInt()
    val m = readln().toInt()
    val vips = (0 until m).map { readln().toInt() }

    val solve = solve(N, vips)
    println(solve)
}

fun solve(n: Int, vips: List<Int>): Int {
    val sizes = mutableListOf<Int>()
    var left = 0
    for (vip in vips + (n + 1)) {
        val size = vip - left - 1
        left = vip
        sizes += size
    }
    val map = sizes.map { fibo(it) }
    var x = 1
    for (m in map) {
        x *= m
    }
    return x
}

private fun fibo(size: Int): Int {
    val dp = IntArray(MAX) { 1 }
    for (i in (2..size)) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    return dp[size]
}
