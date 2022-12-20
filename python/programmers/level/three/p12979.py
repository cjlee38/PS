import math


def solution(n, stations, w):
    ans = 0
    s = 1
    width = (w * 2) + 1
    for station in stations:
        ans += max(math.ceil((station - w - s) / width), 0)
        s = station + w + 1
    if s <= n:
        ans += math.ceil((n - s + 1) / width)
    return ans


print(solution(11, [4, 11], 1)) # 3
print(solution(16, [9], 2)) # 3
print(solution(11, [4, 10], 1))

