import sys

input = sys.stdin.readline

n, k = map(int, input().strip().split())
coins = [int(input()) for _ in range(n)]

MAX = 9876543210
board = [[MAX] * (k + 1)]
board.extend([[0] * (k + 1) for _ in range(n)])

for i in range(1, n + 1):
    for j in range(1, k + 1):
        if coins[i - 1] <= j:
            board[i][j] = min(board[i - 1][j], board[i][j - coins[i - 1]] + 1)
        else:
            board[i][j] = board[i - 1][j]

ans = board[n][k]
if ans == MAX:
    print(-1)
else:
    print(ans)
