package programmers.level.three

import programmers.util.assert
import java.util.Stack

fun main() {
    val p = p81303()
    assert("OOOOXOOO") { p.solution(8, 2, arrayOf("D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z")) }
    assert("OOXOXOOO") { p.solution(8, 2, arrayOf("D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C")) }
    assert("XOX") { p.solution(3, 0, arrayOf("D 2", "C", "Z", "C", "Z", "C", "U 1", "C")) }
    assert("XXX") { p.solution(3, 0, arrayOf("C", "C", "C")) }
    assert("XXO") { p.solution(3, 0, arrayOf("C", "C", "C", "Z")) }
    assert("OOO") { p.solution(3, 0, arrayOf("C", "C", "C", "Z", "Z", "Z")) }
}

class p81303 {

    fun solution(n: Int, k: Int, command: Array<String>): String {
        var cursor = k
        val deleted = Stack<Int>()
        var tableSize = n

        for (cmd in command) {
            val c = cmd.split(" ")
            when (c[0]) {
                "D" -> cursor += c[1].toInt()
                "U" -> cursor -= c[1].toInt()
                "C" -> {
                    tableSize--
                    deleted.add(cursor)
                    cursor = if (cursor == tableSize) cursor - 1 else cursor
                }
                "Z" -> {
                    tableSize++
                    cursor = if (deleted.pop() <= cursor) cursor + 1 else cursor
                }
            }
        }
        val sb = StringBuilder()
        sb.append("O".repeat(tableSize))
        while (!deleted.isEmpty()) {
            sb.insert(deleted.pop(), 'X')
        }

        return sb.toString()
    }
}
