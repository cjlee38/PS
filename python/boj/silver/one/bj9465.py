import sys

input = sys.stdin.readline


def solve(n, rows):
    dp = [[0] * (n+1), [0] * (n+1)]
    dp[0][1] = rows[0][0]
    dp[1][1] = rows[1][0]
    for i in range(2, n + 1):
        dp[0][i] = max(dp[1][i - 1], dp[1][i - 2]) + rows[0][i - 1]
        dp[1][i] = max(dp[0][i - 1], dp[0][i - 2]) + rows[1][i - 1]
    return max(dp[0][n], dp[1][n])



T = int(input().strip())
for _ in range(T):
    n = int(input().strip())
    rows = [list(map(int, input().strip().split())), list(map(int, input().strip().split()))]
    print(solve(n, rows))