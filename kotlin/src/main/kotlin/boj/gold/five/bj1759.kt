package boj.gold.five

/*
4 6
a t c i s w
 */

fun main() {
    val (L, C) = readln().split(" ").map { it.toInt() }
    val chars = readln().split(" ").sorted()

    val visited = BooleanArray(C)

    recursive(0, chars, visited, L, C)
}

private val vowels = listOf<String>("a", "e", "i", "o", "u")

private fun recursive(index: Int, chars: List<String>, visited: BooleanArray, L: Int, C: Int) {
    if (L == 0) {
        var cur = ""
        var v_count = 0
        var c_count = 0
        for ((idx, b) in visited.withIndex()) {
            if (b) {
                val c = chars[idx]
                if (c in vowels) {
                    v_count++
                } else {
                    c_count++
                }
                cur += chars[idx]
            }
        }
        if (v_count >= 1 && c_count >= 2)
        println(cur)
        return
    }
    for (i in (index until C)) {
        visited[i] = true
        recursive(i + 1, chars, visited, L - 1, C)
        visited[i] = false
    }
}
