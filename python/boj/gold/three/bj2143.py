import sys
from collections import Counter
input = sys.stdin.readline

t = int(input())
input()
A = [0] + list(map(int, input().strip().split()))
input()
B = [0] + list(map(int, input().strip().split()))

for i in range(1, len(A)):
    A[i] += A[i - 1]
for i in range(1, len(B)):
    B[i] += B[i - 1]


def _get_sum(arr, start, end):
    return arr[end] - arr[start - 1]


c = Counter()
ans = 0
for i in range(1, len(A)):
    for j in range(i, len(A)):
        outer = _get_sum(A, i, j)
        c[outer] += 1

for i in range(1, len(B)):
    for j in range(i, len(B)):
        inner = _get_sum(B, i, j)
        x = t - inner
        ans += c[x]
print(ans)
