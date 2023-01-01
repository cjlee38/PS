import sys
input = sys.stdin.readline

n, k = map(int, input().strip().split())
coins = [int(input()) for _ in range(n)]

dp = [0] * (k + 1)
dp[0] = 1
for i in range(1, n + 1):
    for j in range(1, k + 1):
        # 금액 k에서,
        if j >= coins[i-1]:
            dp[j] += dp[j - coins[i-1]]
print(dp[k])