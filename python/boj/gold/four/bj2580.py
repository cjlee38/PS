import sys

input = sys.stdin.readline

SIZE = 9
board = [list(map(int, input().strip().split())) for _ in range(SIZE)]

xy = []
for i in range(SIZE):
    for j in range(SIZE):
        if board[i][j] == 0:
            xy.append((j, i))


def is_possible(board, x, y, v):
    for i in range(SIZE):
        # vertical
        if board[i][x] == v:
            return False
        # horizontal
        if board[y][i] == v:
            return False
    xx = (x // 3) * 3
    yy = (y // 3) * 3
    for i in range(yy, yy + 3):
        for j in range(xx, xx + 3):
            if board[i][j] == v:
                return False
    return True


def run(xy, idx):
    if idx == len(xy):
        for row in board:
            print(" ".join(map(str, row)))
        sys.exit()
    x = xy[idx][0]
    y = xy[idx][1]
    for i in range(1, 9 + 1):
        if is_possible(board, x, y, i):
            board[y][x] = i
            run(xy, idx + 1)
            board[y][x] = 0

run(xy, 0)

'''
0 2 0 9 0 5 0 0 0
5 9 0 0 3 0 2 0 0
7 0 0 6 0 2 0 0 5
0 0 9 3 5 0 4 6 0
0 5 4 0 0 0 7 8 0
0 8 3 0 2 7 5 0 0
8 0 0 2 0 9 0 0 4
0 0 5 0 4 0 0 2 6
0 0 0 5 0 3 0 7 0
'''