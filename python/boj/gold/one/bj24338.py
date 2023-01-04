import sys
from collections import deque

input = sys.stdin.readline

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
dd = ['N', 'E', 'S', 'W']

h, w = map(int, input().strip().split())
board = [list(input().strip()) for _ in range(h)]
y, x = map(int, input().strip().split())
x -= 1
y -= 1

visited = [[False] * w for _ in range(h)]
visited[y][x] = True
Q = deque()
Q.append((x, y, []))


def in_range(x, y):
    return 0 <= x < w and 0 <= y < h


def ans_print(board, route):
    for d, x, y in route:
        board[y][x] = d
    for i in range(h):
        for j in range(w):
            if board[i][j] == '?':
                board[i][j] = 'N'
    for i in board:
        print("".join(i))


def already_jump(route, nx, ny):
    for d, x, y in route:
        if x == nx and y == ny:
            return True
    return False


while Q:
    x, y, route = Q.popleft()
    cur = board[y][x]
    if cur == 'P' or cur == 'B':
        ans_print(board, route)
        break
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if not in_range(nx, ny) or visited[ny][nx] or board[ny][nx] == '#':
            continue
        v = board[ny][nx]
        if cur == '.' and v in ['.', 'P', 'B']:
            Q.append((nx, ny, route))
            visited[ny][nx] = True
        elif v == '1' and cur == '1':
            Q.append((nx, ny, route))
            visited[ny][nx] = True
        elif v == '?':
            nnx = nx + dx[i]
            nny = ny + dy[i]
            # up to down, down to up
            if not in_range(nnx, nny) or visited[nny][nnx]:
                continue
            if already_jump(route, nx, ny):
                continue
            if cur == '.' and board[nny][nnx] == '1':
                Q.append((nnx, nny, route + [(dd[i], nx, ny)]))
                visited[nny][nnx] = True
            elif cur == '1' and board[nny][nnx] in ['.', 'P', 'B']:
                Q.append((nnx, nny, route + [(dd[(i + 2) % 4], nx, ny)]))
                visited[nny][nnx] = True
else: # not break == no answer
    print(-1)

'''
1 3
..P
1 1
'''