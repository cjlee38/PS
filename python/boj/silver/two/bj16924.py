import sys

input = sys.stdin.readline
h, w = map(int, input().strip().split())
board = [input().strip() for _ in range(h)]
m = min(h, w)
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]


def in_range(x, y):
    return 0 <= x < w and 0 <= y < h


def run(board, visited, x, y):
    for i in range(1, m + 1):
        for j in range(4):
            nx = x + (dx[j] * i)
            ny = y + (dy[j] * i)
            if not in_range(nx, ny) or not board[ny][nx] == '*': # fails
                return i - 1
        else: # ok
            visited[y][x] = True
            for j in range(4):
                nx = x + (dx[j] * i)
                ny = y + (dy[j] * i)
                visited[ny][nx] = True


visited = [[False] * w for _ in range(h)]
ans = []
for i in range(h):
    for j in range(w):
        if board[i][j] == '*':
            s = run(board, visited, j, i)
            if s > 0:
                ans.append((i + 1, j + 1, s))

for i in range(h):
    for j in range(w):
        if board[i][j] == '*' and not visited[i][j]:
            print(-1)
            exit()

print(len(ans))
for i in range(len(ans)):
    print(" ".join(map(str, ans[i])))
