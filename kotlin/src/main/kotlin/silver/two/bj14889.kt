package silver.two

import kotlin.math.abs
import kotlin.math.min

var N = -1
var ans = Int.MAX_VALUE

fun main() {
    N = readln().toInt()
    val range = 0 until N
    val board = range.map { readln().split(" ").map { it.toInt() } }


    val visited = range.map { false }.toMutableList()
    start(board, 0,  0, visited, N/2)
    println(ans)
}

fun start(board: List<List<Int>>, pos:Int, depth: Int, visited: MutableList<Boolean>, max: Int) {
    if (depth == max) {
        return calc(board, visited)
    }

    for (i in pos until visited.size) {
        if (visited[i]) continue
        visited[i] = true
        start(board, i, depth + 1, visited, max)
        visited[i] = false

    }
}

fun calc(board: List<List<Int>>, visited: MutableList<Boolean>) {
    var leftSum = 0
    var rightSum = 0
    for (i in 0 until N) {
        for (j in 0 until N) {
            if (visited[i] and visited[j]) leftSum += board[i][j]
            if (!visited[i] and !visited[j]) rightSum += board[i][j]
        }
    }
    ans = min(ans, abs(leftSum - rightSum))
}
