
def solution(word):
    ans = 0
    base = "AEIOU"
    nums = [781, 156, 31, 6, 1]

    for i in range(len(word)):
        idx = base.index(word[i])
        ans += idx * nums[i]
    return ans + len(word)

print(solution('I'))