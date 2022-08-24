import sys

input = sys.stdin.readline
MOD = 1_000_000_007

N = int(input().strip())
dp = [-1] * 1516

dp[1] = 0
dp[2] = 1
dp[3] = 1

for i in range(4, N + 1):
    dp[i] = dp[i - 1] + dp[i - 2] % MOD

print(dp[N], dp[N - 1])

