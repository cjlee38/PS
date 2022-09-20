import sys
input = sys.stdin.readline

inputs = list(map(int, input().strip().split(" ")))
N = inputs[0]
probs = [i / 100 for i in inputs[1:]]

visited = [[False] * 30 for _ in range(30)]
visited[14][14] = True

# 동서남북, EWSN
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

ans = 0
def dfs(x, y, prob, depth):
    global ans
    if prob == 0.0:
        return
    if depth == N:
        ans += prob
        return

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if not visited[ny][nx]:
            np = prob * probs[i]

            visited[ny][nx] = True
            dfs(nx, ny, np, depth + 1)
            visited[ny][nx] = False

dfs(14, 14, 1, 0)
print(ans)