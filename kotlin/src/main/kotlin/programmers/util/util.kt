package programmers.util

fun assert(answer: Any, runnable: () -> Any) {
    val result = runnable.invoke()
    if (result != answer) {
        throw RuntimeException("$result != $answer")
    }
}
