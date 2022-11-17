import sys
from collections import deque
input = sys.stdin.readline

N, M, K = map(int, input().strip().split())

board = [[0] * M for _ in range(N)]
for _ in range(K):
    r, c = map(int, input().strip().split())
    board[r - 1][c - 1] = 1

dxy = [(0, -1), (1, 0), (0, 1), (-1, 0)]


def in_range(x, y):
    return 0 <= x < M and 0 <= y < N

def find_max(board, y, x):
    DQ = deque()
    DQ.append((x, y))
    board[y][x] = 0
    score = 1
    while DQ:
        px, py = DQ.popleft()

        for dx, dy in dxy:
            nx = px + dx
            ny = py + dy
            if in_range(nx, ny) and board[ny][nx] == 1:
                score += 1
                board[ny][nx] = 0
                DQ.append((nx, ny))
    return score




ans = 0
for i in range(len(board)):
    for j in range(len(board[i])):
        if board[i][j] == 1:
            cur = find_max(board, i, j)
            ans = max(cur, ans)

print(ans)
