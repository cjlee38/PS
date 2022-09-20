import sys

input = sys.stdin.readline


def run(size):
    dp = [-1 for _ in range(1000)]
    dp[0] = 0
    dp[1] = 1
    if size <= 1:
        return dp[size]
    for i in range(2, size + 2):
        dp[i] = dp[i - 1] + dp[i - 2]
    return dp[size + 1]


N = int(input().strip())
M = int(input().strip())
vips = [0]
vips.extend([int(input().strip()) for i in range(M)])
vips.append(N + 1)

res = 1
for i, j in zip(vips[:-1], vips[1:]):
    size = j - i - 1
    if size == 0:
        continue
    run1 = run(size)
    res *= run1

print(res)
