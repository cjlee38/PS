import sys

input = sys.stdin.readline

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

w, h = map(int, input().strip().split())
board = [list(input().strip()) for _ in range(h)]
visited = [[False for _ in range(w)] for _ in range(h)]

import heapq
Q = []
heapq.heappush(Q, (0, 0, 0)) # cnt, x, y
visited[0][0] = True


def in_range(x, y):
    return 0 <= x < w and 0 <= y < h


while Q:
    c, x, y = heapq.heappop(Q)
    if x == w - 1 and y == h -1:
        print(c)
        break
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        nc = c
        if not in_range(nx, ny) or visited[ny][nx]:
            continue
        if board[ny][nx] == '1':
            nc = c + 1
        visited[ny][nx] = True
        heapq.heappush(Q, (nc, nx, ny))


