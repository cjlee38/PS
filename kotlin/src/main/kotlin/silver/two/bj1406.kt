package silver.two

import java.util.Stack

fun moveCursor(source: Stack<Char>, dest: Stack<Char>) {
    if (source.empty()) return
    dest.push(source.pop())
}

fun delete(left: Stack<Char>) {
    if (!left.empty()) left.pop()
}

fun insert(left: Stack<Char>, command: String) {
    val split = command.split(" ")
    left.push(split[1][0])
}

fun main() {
    val left = Stack<Char>()
    val right = Stack<Char>()

    readln().toCharArray().forEach { left.push(it) }

    val N = readln().toInt()
    for (i in 0 until N) {
        val command = readln()
        when(command) {
            "L" -> moveCursor(left, right)
            "D" -> moveCursor(right, left)
            "B" -> delete(left)
            else -> insert(left, command)
        }
    }
    print(left.joinToString(""))
    println(right.reversed().joinToString(""))
}
