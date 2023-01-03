import sys
from collections import deque

input = sys.stdin.readline
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
h, w = map(int, input().strip().split())
board = [list(input().strip()) for _ in range(h)]

visited = [[[[False] * w for _ in range(h)] for _ in range(w)] for _ in range(h)]

bx = by = rx = ry = hx = hy = 0
for i in range(h):
    for j in range(w):
        if board[i][j] == 'B':
            bx, by = j, i
        elif board[i][j] == 'R':
            rx, ry = j, i
        elif board[i][j] == 'O':
            hx, hy = j, i

ans = -1
visited[ry][rx][by][bx] = True


def run(board, visited):
    # heap ?
    Q = deque()
    Q.append((0, rx, ry, bx, by))
    while Q:
        depth, prx, pry, pbx, pby = Q.popleft()
        for d in range(4):
            nrx, nry = move(board, d, prx, pry)
            nbx, nby = move(board, d, pbx, pby)
            if board[nby][nbx] == 'O':
                continue
            if board[nry][nrx] == 'O': # blue not in hole
                return depth + 1
            nbx, nby, nrx, nry = backwards(d, nbx, nby, nrx, nry, pbx, pby, prx, pry)
            if not visited[nry][nrx][nby][nbx]:
                visited[nry][nrx][nby][nbx] = True
                if depth < 9:
                    Q.append((depth + 1, nrx, nry, nbx, nby))
    return -1


def backwards(d, nbx, nby, nrx, nry, pbx, pby, prx, pry):
    if nrx == nbx and nry == nby:
        red_distance = abs(nrx - prx) + abs(nry - pry)
        blue_distance = abs(nbx - pbx) + abs(nby - pby)
        if red_distance > blue_distance:
            nrx -= dx[d]
            nry -= dy[d]
        else:
            nbx -= dx[d]
            nby -= dy[d]
    return nbx, nby, nrx, nry


def move(board, d, rx, ry):
    while True:
        nrx = rx + dx[d]
        nry = ry + dy[d]
        if board[nry][nrx] == '#':
            break
        if board[nry][nrx] == 'O':
            return nrx, nry  # what to do ?
        rx = nrx
        ry = nry
    return rx, ry


print(run(board, visited))
