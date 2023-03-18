import sys
input = sys.stdin.readline

h, w = map(int, input().strip().split())
arr = list(map(int, input().strip().split()))
ans = 0
for i in range(1, w - 1):
    height = min(max(arr[:i]), max(arr[i+1:]))
    if arr[i] < height:
        ans += height - arr[i]
print(ans)