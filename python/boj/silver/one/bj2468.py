import sys
from collections import deque
input = sys.stdin.readline

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

n = int(input())
board = [list(map(int, input().strip().split())) for _ in range(n)]

ans = 1


def in_range(x, y):
    return 0 <= x < n and 0 <= y < n


def run(board, visited, x, y, r):
    Q = deque()
    visited[y][x] = True
    Q.append((x, y))

    while Q:
        px, py = Q.popleft()
        for i in range(4):
            nx = px + dx[i]
            ny = py + dy[i]
            if in_range(nx, ny) and not visited[ny][nx] and board[ny][nx] > r:
                visited[ny][nx] = True
                Q.append((nx, ny))



for r in range(1, 100 + 1):
    visited = [[False] * n for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(n):
            if not visited[i][j] and board[i][j] > r:
                run(board, visited, j, i, r)
                cnt += 1
    ans = max(ans, cnt)
    if cnt == 0:
        break
print(ans)
