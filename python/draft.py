import sys
input = sys.stdin.readline

N = int(input())
cities = list(map(int, input().split(" ")))
M = int(input())

S = sum(cities)
diff = S - M
def check(threshold):
    now_diff = sum([city - threshold for city in cities if city > threshold])
    return diff >= now_diff


if S <= M:
    print(max(cities))
else:
    mini = min(cities)
    maxi = max(cities)
    while mini <= maxi:
        mid = (mini + maxi) // 2
        if check(mid):
            maxi = mid
        print(mini, mid, maxi)




