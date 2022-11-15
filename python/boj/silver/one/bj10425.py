import sys

input = sys.stdin.readline

T = int(input())
ans = {}

arr = [0 for _ in range(100_000 + 1)]
arr[1] = 1
arr[2] = 1
for i in range(3, len(arr)):
    arr[i] = arr[i - 1] + arr[i - 2]

dct = {val: idx for idx, val in enumerate(arr)}
dct[1] = 2

for _ in range(T):
    Fn = int(input())
    print(dct[Fn])
