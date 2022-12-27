import sys

input = sys.stdin.readline
board = [[False] * 101 for _ in range(101)]
n = int(input())

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]


def grow(dragon, x, y):
    t_dragon = []
    for d in dragon[::-1]:
        nd = (d + 1) % 4
        x += dx[nd]
        y += dy[nd]
        board[y][x] = True
        t_dragon.append(nd)
    dragon.extend(t_dragon)
    return x, y

for _ in range(n):
    x, y, d, g = map(int, input().strip().split())
    board[y][x] = True
    head_x = x + dx[d]
    head_y = y + dy[d]
    board[head_y][head_x] = True
    dragon = [d]
    for _ in range(g):
        head_x, head_y = grow(dragon, head_x, head_y)

ans = 0
for i in range(100):
    for j in range(100):
        if board[i][j] and board[i + 1][j] and board[i][j + 1] and board[i + 1][j + 1]:
            ans += 1
print(ans)
