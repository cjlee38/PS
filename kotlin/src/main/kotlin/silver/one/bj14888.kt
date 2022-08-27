package silver.one

import kotlin.math.max
import kotlin.math.min


private var maxx = Integer.MIN_VALUE
private var minn = Integer.MAX_VALUE

private fun main() {
    val N = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }
    // + - * /
    val operators = readln().split(" ").map { it.toInt() }.toMutableList()

    run(numbers[0], 1, numbers, operators)
    println(maxx)
    println(minn)
}

private fun run(sum: Int, index: Int, numbers: List<Int>, operators: MutableList<Int>) {
    if (operators.sum() == 0) {
        maxx = max(maxx, sum)
        minn = min(minn, sum)
        return
    }

    for ((idx, count) in operators.withIndex()) {
        if (count > 0) {
            val op = findOperator(idx)
            val curSum = op(sum, numbers[index])
            operators[idx]--
            run(curSum, index + 1, numbers, operators)
            operators[idx]++
        }
    }
}

private fun findOperator(index: Int): (Int, Int) -> Int {
    return when(index) {
        0 -> { a: Int, b: Int -> a + b }
        1 -> { a: Int, b: Int -> a - b }
        2 -> { a: Int, b: Int -> a * b }
        else -> { a: Int, b: Int -> a / b }
    }
}
