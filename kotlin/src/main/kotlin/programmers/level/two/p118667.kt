package programmers.level.two

import programmers.util.assert

fun main() {
    val problem = p118667()
    assert(2) { problem.solution(intArrayOf(3, 2, 7, 2), intArrayOf(4, 6, 5, 1)) }
    assert(7) { problem.solution(intArrayOf(1, 2, 1, 2), intArrayOf(1, 10, 1, 2)) }
    assert(-1) { problem.solution(intArrayOf(1, 1), intArrayOf(1, 5)) }
    assert(-1) { problem.solution(intArrayOf(1), intArrayOf(3)) }
    assert(0) { problem.solution(intArrayOf(1), intArrayOf(1)) }
    assert(4) { problem.solution(intArrayOf(1, 1, 1), intArrayOf(5, 1, 1)) }
    assert(15) { problem.solution(intArrayOf(1, 1, 1, 8, 10, 9), intArrayOf(1, 1, 1, 1, 1, 1)) }
}

class p118667 {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var cnt = 0

        var leftSum = queue1.sumOf { it.toLong() }
        var rightSum = queue2.sumOf { it.toLong() }
        val leftQ = ArrayDeque(queue1.toList())
        val rightQ = ArrayDeque(queue2.toList())

        while ((leftSum != rightSum) and (cnt <= (queue1.size + queue2.size) * 1.5)) { // and no answer ?
            if (leftSum > rightSum) {
                val pop = leftQ.removeFirst()
                rightQ.addLast(pop)

                leftSum -= pop
                rightSum += pop
            } else {
                val pop = rightQ.removeFirst()
                leftQ.addLast(pop)

                leftSum += pop
                rightSum -= pop
            }
            cnt++
        }
        return if (leftSum != rightSum) -1 else cnt
    }
}
