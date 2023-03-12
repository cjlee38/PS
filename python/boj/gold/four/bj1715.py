import sys
input = sys.stdin.readline

from heapq import *

n = int(input())
arr = [int(input()) for _ in range(n)]

heapify(arr)
ans = 0
while len(arr) != 1:
    a = heappop(arr)
    b = heappop(arr)
    ans += a + b
    heappush(arr, a + b)

print(ans)


