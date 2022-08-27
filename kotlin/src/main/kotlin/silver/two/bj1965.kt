package silver.two

fun main() {
    val N = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }

    val dp = mutableListOf(0)

    var ret = 0
    for (number in numbers) {
        if (number > dp[ret]) {
            ret++
            dp.add(number)
        } else {
            val loc = binarySearch(dp, 0, ret, number)
            dp[loc] = number
        }
    }
    println(ret)
}

fun binarySearch(dp: MutableList<Int>, low: Int, high: Int, number: Int): Int {
    if (low == high) return low

    val mid = (low + high) / 2
    if (dp[mid] == number) return mid
    if (dp[mid] < number) return binarySearch(dp, mid + 1, high, number)
    return binarySearch(dp, low, mid, number)
}
