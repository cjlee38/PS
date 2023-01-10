import sys
from copy import deepcopy
input = sys.stdin.readline
# 1 up 2 down 3 right 4 left
dx = [-99, 0, 0, 1, -1]
dy = [-99, -1, 1, 0, 0]
class Shark:

    def __init__(self, speed, direction, size):
        self.speed = speed
        self.direction = direction
        self.size = size

    def __repr__(self):
        return f"{self.speed}:{self.direction}:{self.size}"

R, C, m = map(int, input().strip().split())
sharks = []
board = [[None] * C for _ in range(R)]

for _ in range(m):
    r, c, s, d, z = map(int, input().strip().split())
    board[r - 1][c - 1] = Shark(s, d, z)

gotcha = []


def move(origin, copied):
    for i in range(R):
        for j in range(C):
            if origin[i][j] is not None: # shark exists, must be only one
                cur = origin[i][j]
                tx = j
                ty = i
                d = get_direction(cur.direction, tx, ty)
                # vertical
                if d == 1 or d == 2:
                    s = cur.speed % ((R - 1) * 2)
                else: # horizontal
                    s = cur.speed % ((C - 1) * 2)

                while s > 0:
                    tx += dx[d]
                    ty += dy[d]
                    # if edge:
                    d = get_direction(d, tx, ty)
                    s -= 1
                nx = tx
                ny = ty
                cur.direction = d

                nxt = copied[ny][nx]
                if nxt is None:
                    copied[ny][nx] = cur
                else:
                    if cur.size > nxt.size:
                        copied[ny][nx] = cur
                    else:
                        pass # do nothing
    return copied


def get_direction(d, tx, ty):
    if d <= 2:
        if ty == 0 and d == 1:
            d = 2
        elif ty == R - 1 and d == 2:
            d = 1
    if d >= 3:
        if tx == C - 1 and d == 3:
            d = 4
        elif tx == 0 and d == 4:
            d = 3
    return d


for i in range(C):
    # fishing
    for j in range(R):
        if board[j][i] is not None: # not empty
            gotcha.append(board[j][i]) # 0 must be possible
            board[j][i] = None
            break
    # move
    board = move(board, [[None] * C for _ in range(R)])

print(sum([shark.size for shark in gotcha]))


'''
4 6 1
1 6 5 3 1

x x x x x x
x x x x x x
x x x x x x
x x x x x V
'''