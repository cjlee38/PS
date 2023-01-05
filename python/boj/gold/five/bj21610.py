import sys

input = sys.stdin.readline

n, m = map(int, input().strip().split())
board = [list(map(int, input().strip().split())) for _ in range(n)]
directions = [list(map(int, input().strip().split())) for _ in range(m)]

ddx = (-1, 1, 1, -1)
ddy = (-1, -1, 1, 1)
dx = (-1, -1, 0, 1, 1, 1, 0, -1)
dy = (0, -1, -1, -1, 0, 1, 1, 1)

clouds = [(0, n-1), (1, n-1), (0, n-2), (1, n-2)]


for direction in directions:
    d = direction[0] - 1
    s = direction[1]
    moved_clouds = []
    visited = [[False] * n for _ in range(n)]
    for x, y in clouds:
        nx = (x + (dx[d] * s)) % n
        ny = (y + (dy[d] * s)) % n
        board[ny][nx] += 1
        moved_clouds.append((nx, ny))
        visited[ny][nx] = True

    for x, y in moved_clouds: # 물복사
        cnt = 0
        for j in range(4):
            nx = x + ddx[j]
            ny = y + ddy[j]
            if 0 <= nx < n and 0 <= ny < n and board[ny][nx] > 0:
                cnt += 1
        board[y][x] += cnt

    new_clouds = []
    for i in range(n):
        for j in range(n):
            if board[i][j] >= 2 and not visited[i][j]:
                board[i][j] -= 2
                new_clouds.append((j, i))
    clouds = new_clouds

ans = 0
for row in board:
    for i in row:
        ans += i
print(ans)
