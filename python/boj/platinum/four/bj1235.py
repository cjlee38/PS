import sys
input = sys.stdin.readline

n = int(input())
numbers = [input().strip() for _ in range(n)]
k = -1

while True:
    currents = set([n[k:] for n in numbers])
    if len(currents) == len(numbers):
        break
    k -= 1

print(-k)