import sys
input = sys.stdin.readline

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

board = [list(input().strip().split()) for _ in range(5)]
ans_set = set()


def run(x, y, depth, cur):
    if depth == 0:
        ans_set.add(cur)
        return
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < 5 and 0 <= ny < 5:
            run(nx, ny, depth - 1, cur + board[ny][nx])


for i in range(5):
    for j in range(5):
        run(j, i, 5, board[i][j])
print(len(ans_set))