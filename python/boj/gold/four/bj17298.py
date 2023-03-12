import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().strip().split()))

stack = []

for i in range(n):
    while stack and arr[stack[-1]] < arr[i]:
        arr[stack.pop()] = arr[i]
    stack.append(i)

while stack:
    arr[stack.pop()] = -1

print(*arr)

