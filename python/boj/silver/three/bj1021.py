import sys
input = sys.stdin.readline

from collections import deque

n, m = map(int, (input().strip().split()))
targets = list(map(int, (input().strip().split())))

arr = deque([i for i in range(1, n + 1)])
ans = 0

def _find(arr, t):
    idx = arr.index(t)
    cnt = 0
    if len(arr) / 2 > idx:
        while arr[0] != t:
            cnt += 1
            arr.append(arr.popleft())
    else:
        while arr[0] != t:
            cnt += 1
            arr.appendleft(arr.pop())
    arr.popleft()
    return cnt


for t in targets:
    ans += _find(arr, t)
print(ans)