import sys
from copy import deepcopy

input = sys.stdin.readline

n = int(input())
board = [list(map(int, input().strip().split())) for _ in range(n)]

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
ans = -1

def in_range(x, y):
    return 0 <= x < n and 0 <= y < n


def run(board, depth):
    global ans
    if depth == 0:
        ans = max(ans, max([max(b) for b in board]))
        return
    for d in range(4):  # direction
        copy_board = deepcopy(board)
        if d == 0 or d == 3:  # up or left
            move(copy_board, d, range(n))
        else:  # down or right
            move(copy_board, d, range(n - 1, -1, -1))
        run(copy_board, depth - 1)


def move(board, d, rng):
    visited = [[False] * n for _ in range(n)]
    for k in rng:  # y
        for l in rng:  # x
            if board[k][l] != 0:
                move_each(board, visited, d, k, l)


def move_each(board, visited, d, k, l):
    cur = board[k][l]
    x = l
    y = k
    for m in range(1, n):
        nx = x + dx[d]
        ny = y + dy[d]
        if not in_range(nx, ny):
            break
        if board[ny][nx] == 0:
            board[ny][nx] += cur
            board[y][x] = 0
        else:
            if board[ny][nx] == cur and not visited[ny][nx]:
                visited[ny][nx] = True
                board[ny][nx] += cur
                board[y][x] = 0
            return
        x,y = nx, ny

run(board, 5)
print(ans)

'''
5
2 4 8 16 32
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0

4
2 4 16 8
8 4 0 0
16 8 2 0
2 8 2 0
'''