import sys
from collections import deque
from copy import deepcopy

# 약 1시간 20분

input = sys.stdin.readline

tc = int(input())

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

MAX = 9876543210
MAX2 = 9876543219
def in_range(x, y, w, h):
    return 0 <= x < w and 0 <= y < h


def go(board, w, h, sign):
    num_board = [[MAX2] * w for _ in range(h)]
    Q = deque()
    for i in range(h):
        for j in range(w):
            if board[i][j] == "#":
                num_board[i][j] = MAX
            elif board[i][j] == sign:
                num_board[i][j] = 0
                Q.append((j, i))

    cnt = 1
    while len(Q) != 0:
        Q = go2(Q, num_board, cnt, h, w)
        cnt += 1
    return num_board


def go2(Q, board, cnt, h, w):
    NQ = deque()
    while len(Q) != 0:
        x, y = Q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if in_range(nx, ny, w, h) and board[ny][nx] != MAX and board[ny][nx] == MAX2:
                board[ny][nx] = cnt
                NQ.append((nx, ny))
    return NQ


def is_edge(x, y, w, h):
    return x == 0 or y == 0 or x == w - 1 or y == h - 1


def start(board, w, h):
    fire_board = go(deepcopy(board), w, h, "*")
    sang_board = go(deepcopy(board), w, h, "@")

    ans = []
    from pprint import pprint
    for i in range(h):
        for j in range(w):
            if is_edge(j, i, w, h):
                s, f = sang_board[i][j], fire_board[i][j]
                if type(s) == int and type(f) == int and s < f:
                        ans.append(s)

    # pprint(fire_board)
    # pprint(sang_board)
    # pprint(ans)
    # pprint("==============================")
    if len(ans) == 0:
        print("IMPOSSIBLE")
    else:
        print(min(ans) + 1)


for c in range(tc):
    w, h = map(int, input().split())
    board = []
    for i in range(h):
        board.append(list(input().strip()))
    start(board, w, h)

'''
1
4 3
####
#*@.
####
'''

'''
1
2 2
@#
#*
'''
