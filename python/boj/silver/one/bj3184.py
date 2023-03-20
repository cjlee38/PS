import sys
input = sys.stdin.readline

h, w = map(int, input().strip().split())
board = [input() for _ in range(h)]
visited = [[False] * w for _ in range(h)]

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

def in_range(x, y):
    return 0 <= x < w and 0 <= y < h


def _count(x, y, visited):
    Q = []
    Q.append((x, y))
    visited[y][x] = True
    sheep = 0
    wolf = 0
    while Q:
        cx, cy = Q.pop()
        if board[cy][cx] == 'o':
            sheep += 1
        elif board[cy][cx] == 'v':
            wolf += 1

        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if in_range(nx, ny) and not visited[ny][nx] and board[ny][nx] != '#':
                visited[ny][nx] = True
                Q.append((nx, ny))
    return sheep, wolf

sheep = 0
wolf = 0
for i in range(h):
    for j in range(w):
        if board[i][j] != "#" and not visited[i][j]:
            s, ww = _count(j, i, visited)
            if s > ww:
                sheep += s
            else:
                wolf += ww

print(sheep, wolf)