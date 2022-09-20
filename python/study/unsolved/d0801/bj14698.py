import sys

MOD = 1000000007
input = sys.stdin.readline

import heapq

T = int(input().strip())
for i in range(T):
    N = int(input().strip())
    slimes = list(map(int, input().split(" ")))
    muls = []
    while len(slimes) >= 2:
        left = heapq.heappop(slimes)
        right = heapq.heappop(slimes)
        mul = left * right % MOD
        muls.append(mul)
        heapq.heappush(slimes, mul)

    res = 1
    for j in muls:
        res *= j % MOD
    print(res % MOD)
