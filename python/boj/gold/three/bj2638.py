import sys
from collections import deque
input = sys.stdin.readline
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

h, w = map(int, input().strip().split())
board = [list(map(int, input().strip().split())) for _ in range(h)]

def in_range(x, y):
    return 0 <= x < w and 0 <= y < h


def run(board):
    airs = [[False] * w for _ in range(h)]
    cheese = [[0] * w for _ in range(h)]
    Q = deque()
    Q.append((0, 0))
    airs[0][0] = True
    while Q:
        x, y = Q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if not in_range(nx, ny) or airs[ny][nx]:
                continue
            if board[ny][nx] == 1:
                cheese[ny][nx] += 1
                continue
            airs[ny][nx] = True
            Q.append((nx, ny))
    found = False
    for i in range(h):
        for j in range(w):
            if cheese[i][j] >= 2:
                board[i][j] = 0
                found = True
    if not found:
        return False # done
    return True

ans = 0
while True:
    res = run(board)
    if not res:
        break
    ans += 1
print(ans)

