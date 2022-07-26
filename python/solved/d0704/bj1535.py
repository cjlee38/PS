import sys
input = sys.stdin.readline

# 50분

n = int(input())
energies = list(map(int, input().split(" ")))
joys = list(map(int, input().split(" ")))

def run(idx, current, joy):
    if idx >= n or current <= 0:
        return joy
    curmax = joy
    for i in range(idx, n):
        if current - energies[i] > 0:
            curmax = max(curmax, run(i + 1, current - energies[i], joy + joys[i]))
    return max(joy, curmax)

print(run(0, 100, 0))
