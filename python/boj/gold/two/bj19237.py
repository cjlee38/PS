import sys
input = sys.stdin.readline
# up down left right
dx = [-999, 0, 0, -1, 1]
dy = [-999, -1, 1, 0, 0]

n, m, k = map(int, input().strip().split())
# n = size
# m = number of sharks
# k = smell timeout
board = [list(map(int, input().strip().split())) for _ in range(n)]
smell_board = [[[0, 0]] * n for _ in range(n)]
directions = [-999] + list(map(int, input().strip().split()))
priorities = {i: {} for i in range(1, m + 1)}
for i in range(1, m + 1):
    cur = priorities[i]
    for i in range(1, 5): # up down left right
        cur[i] = list(map(int, input().strip().split()))

def smell():
    for i in range(n):
        for j in range(n):
            if board[i][j] == 0:
                if smell_board[i][j][1] > 0:
                    smell_board[i][j][1] -= 1 # fades
                if smell_board[i][j][1] <= 0:
                    smell_board[i][j] = [0, 0]
            else: # shark exists
                smell_board[i][j] = [board[i][j], k] # number, time


def in_range(x, y):
    return 0 <= x < n and 0 <= y < n


def get_next_position(shark_number, cur_direction, x, y):
    # when no smell
    for next_direction in priorities[shark_number][cur_direction]:
        nx = x + dx[next_direction]
        ny = y + dy[next_direction]
        if not in_range(nx, ny):
            continue
        if smell_board[ny][nx][1] == 0: # no smell
            return nx, ny, next_direction

    # with smell
    for next_direction in priorities[shark_number][cur_direction]:
        nx = x + dx[next_direction]
        ny = y + dy[next_direction]
        if not in_range(nx, ny):
            continue
        if smell_board[ny][nx][0] == shark_number:
            return nx, ny, next_direction
    raise Exception()

def move(origin, copied):
    global stop
    shark_count = 0
    for i in range(n):
        for j in range(n):
            if origin[i][j] == 0:
                continue
                # move shark
            shark_count += 1
            shark_number = origin[i][j]
            cur_direction = directions[shark_number]
            nx, ny, nd = get_next_position(shark_number, cur_direction, j, i)
            directions[shark_number] = nd
            if copied[ny][nx] == 0: # no fight
                copied[ny][nx] = shark_number
            else: # fight
                if shark_number < copied[ny][nx]:
                    copied[ny][nx] = shark_number # replace
            copied[i][j] = 0
    if shark_count == 1:
        stop = True
    return copied

stop = False
cnt = 0
from copy import deepcopy
smell()
while cnt <= 1000:
    cnt += 1
    smell()
    board = move(board, deepcopy(board))
    if stop:
        print(cnt - 1)
        exit()
print(-1)