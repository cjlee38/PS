import sys
input = sys.stdin.readline

n = int(input())
ans = 0
queens = [-1] * n

def possible(row):
    for i in range(row):
        if queens[row] == queens[i]:
            return False
        if abs(row - i) == abs(queens[row] - queens[i]):
            return False
    return True


def run(row):
    global ans
    if row == n:
        ans += 1
        return
    i = row
    for j in range(n):
        queens[row] = j
        if possible(row):
            run(row + 1)
run(0)
print(ans)