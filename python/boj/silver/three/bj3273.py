import sys
input = sys.stdin.readline

n = int(input())
arr = sorted(list(map(int, input().strip().split())))
x = int(input())

ans = 0

left_index = 0
right_index = n - 1

while left_index < right_index:
    left = arr[left_index]
    right = arr[right_index]
    cur = left + right
    if cur == x:
        ans += 1
        left_index += 1
        right_index -= 1
    elif cur < x:
        left_index += 1
    elif cur > x:
        right_index -= 1

print(ans)