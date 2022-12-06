import sys

input = sys.stdin.readline

n, m = map(int, input().strip().split())

x = 1
for i in range(n, n-m, -1):
    x *= i
y = 1
for i in range(1, m+1):
    y *= i
print(x//y)