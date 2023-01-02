import sys

input = sys.stdin.readline

n = int(input())
roads = list(map(int, input().strip().split()))
stations = list(map(int, input().strip().split()))

ans = 0
cost = 9876543210
for i in range(n - 1):
    cost = min(cost, stations[i])
    ans += cost * roads[i]

print(ans)
