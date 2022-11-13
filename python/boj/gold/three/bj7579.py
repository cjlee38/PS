import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split(" "))  # number of apps, additional memory for new app
memories = [0] + list(map(int, input().strip().split(" ")))  # memories in use
costs = [0] + list(map(int, input().strip().split(" ")))  # costs to rerun

dp = [[0] * (sum(costs) + 1) for i in range(len(costs) + 1)]

MAX = 9876543210
ans = MAX
for i in range(1, N + 1):
    for j in range(0, len(dp[i])):
        if j - costs[i] >= 0:
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - costs[i]] + memories[i])
        else:
            dp[i][j] = dp[i - 1][j]
        if dp[i][j] >= M:
            ans = min(ans, j)

print(ans if ans != MAX else 0)