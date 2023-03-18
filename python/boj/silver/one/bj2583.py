import sys
input = sys.stdin.readline

m, n, k = map(int, input().strip().split())
board = [[False] * n for _ in range(m)]


def _draw(x1, y1, x2, y2):
    for i in range(y1, y2): # 0 ~ 4
        for j in range(x1, x2): # 2 ~ 4
            board[i][j] = True

for _ in range(k):
    x1, y1, x2, y2 = map(int, input().strip().split())
    _draw(x1, y1, x2, y2)


dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
ans = []


def in_range(x, y):
    return 0 <= x < n and 0 <= y < m


def _count(i, j):
    Q = []
    board[i][j] = True
    Q.append((i, j))
    cur_ans = 0
    while Q:
        y, x = Q.pop()
        cur_ans += 1
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if in_range(nx, ny) and not board[ny][nx]:
                board[ny][nx] = True
                Q.append((ny, nx))
    return cur_ans

for i in range(m):
    for j in range(n):
        if not board[i][j]:
            ans.append(_count(i, j))

print(len(ans))
print(*sorted(ans))