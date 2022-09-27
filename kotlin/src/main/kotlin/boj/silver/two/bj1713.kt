package boj.silver.two

data class Picture(val number: Int, var age: Int, var count: Int)

private fun replace(pictures: MutableList<Picture>, vote: Int, age: Int) {
    val filtered = pictures.filter { picture -> picture.count == pictures.minOf { it.count } }
    val rmIndex =
        if (filtered.size == 1) pictures.indexOf(filtered[0]) else pictures.indexOfFirst { picture -> picture.age == filtered.minOf { it.age } }
    pictures[rmIndex] = Picture(vote, age, 1)
}

fun main() {
    val N = readln().toInt()
    readln()
    val votes = readln().split(" ").map { it.toInt() }

    val pictures = mutableListOf<Picture>()
    for ((age, vote) in votes.withIndex()) {
        val find = pictures.find { it.number == vote }
        if (find != null) {
            find.count++
            continue
        }

        if (pictures.size >= N) replace(pictures, vote, age)
        else pictures.add(Picture(vote, age, 1))
    }
    println(pictures.map { it.number }.sorted().joinToString(" "))
}
