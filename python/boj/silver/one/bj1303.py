import sys
input = sys.stdin.readline

w, h = map(int, input().strip().split())
board = [input() for _ in range(h)]
visited = [[False] * w for _ in range(h)]

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

def in_range(x, y):
    return 0 <= x < w and 0 <= y < h

def _count(x, y, color):
    Q = [(x, y)]
    visited[y][x] = True

    cnt = 0
    while Q:
        cx, cy = Q.pop()
        cnt += 1
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if in_range(nx, ny) and not visited[ny][nx] and color == board[ny][nx]:
                visited[ny][nx] = True
                Q.append((nx, ny))
    return cnt


white = 0
blue = 0
for i in range(h):
    for j in range(w):
        if visited[i][j]:
            continue
        if board[i][j] == 'W':
            white += _count(j, i, 'W') ** 2
        else:
            blue += _count(j, i, 'B') ** 2

print(white, blue)

'''
5 6
WBWWW
WWWWW
BBBBB
BBBWW
WWWWW
WWWWW
'''