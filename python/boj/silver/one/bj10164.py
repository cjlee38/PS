import sys

input = sys.stdin.readline

n, m, k = map(int, input().strip().split())


def run(board, init):
    board[1][1] = init
    for i in range(1, len(board)):
        for j in range(1, len(board[i])):
            board[i][j] = max(board[i][j], board[i - 1][j] + board[i][j - 1])
    return board[-1][-1]


if k == 0:
    board = [[0] * (m + 1) for _ in range(n + 1)]
    print(run(board, 1))
else:
    ox, oy = (k - 1) % m, (k - 1) // m
    board = [[0] * (ox + 1 + 1) for _ in range(oy + 1 + 1)]
    temp = run(board, 1)
    board = [[0] * (m - ox + 1) for _ in range(n - oy + 1)]
    print(run(board, temp))
