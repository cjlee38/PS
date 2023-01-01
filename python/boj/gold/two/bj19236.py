import sys
input = sys.stdin.readline
from copy import deepcopy
dx = [0, -1, -1, -1, 0, 1, 1, 1]
dy = [-1, -1, 0, 1, 1, 1, 0, -1]

def in_range(x, y):
    return 0 <= x < 4 and 0 <= y < 4

def find_fish(board, n):
    for i in range(4):
        for j in range(4):
            if board[i][j][0] == n:
                return j, i
    return -1, -1


def move_fish(board, fx, fy, fd, sx, sy):
    for i in range(8):
        nd = (fd + i) % 8
        nx = fx + dx[nd]
        ny = fy + dy[nd]
        if not in_range(nx, ny) or (nx == sx and ny == sy):
            continue
        board[fy][fx][1] = nd
        board[ny][nx], board[fy][fx] = board[fy][fx], board[ny][nx] # swap
        break

max_score = -1
def run(sx, sy, score, board):
    global max_score
    score += board[sy][sx][0]
    max_score = max(max_score, score)
    board[sy][sx][0] = 0

    for cur in range(1, 17):
        fx, fy = find_fish(board, cur)
        if fx == -1 and fy == -1:
            continue
        move_fish(board, fx, fy, board[fy][fx][1], sx, sy)

    sd = board[sy][sx][1]
    while True:
        sx += dx[sd]
        sy += dy[sd]
        if not in_range(sx, sy):
            break
        if board[sy][sx][0] > 0: # to eat
            run(sx, sy, score, deepcopy(board))



board = []
for i in range(4):
    row = list(map(int, input().strip().split()))
    temp_board = []
    for j in range(4):
        f = [row[j * 2], row[(j * 2) + 1] - 1]
        temp_board.append(f)
    board.append(temp_board)
run(0, 0, 0, board)
print(max_score)