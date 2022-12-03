import sys

input = sys.stdin.readline

height, width = map(int, input().strip().split())
board = [[int(i) for i in input().strip()] for _ in range(height)]

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

import heapq


def in_range(x, y):
    return 0 <= x < width and 0 <= y < height


def run(x, y):
    Q = []
    heapq.heappush(Q, (0, x, y, 0))
    visited = [[[False] * 2 for __ in range(width)] for _ in range(height)]
    visited[y][x][0] = True
    while Q:
        p = heapq.heappop(Q)
        if p[1] == width - 1 and p[2] == height - 1:
            return p[0] + 1
        for i in range(4):
            nx = p[1] + dx[i]
            ny = p[2] + dy[i]
            if in_range(nx, ny) and not visited[ny][nx][p[3]]:
                if board[ny][nx] == 1 and p[3] == 0:
                    heapq.heappush(Q, (p[0] + 1, nx, ny, 1))
                    visited[ny][nx][1] = True
                elif board[ny][nx] == 0:
                    heapq.heappush(Q, (p[0] + 1, nx, ny, p[3]))
                visited[ny][nx][p[3]] = True
    return -1


print(run(0, 0))
