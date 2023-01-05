import sys

input = sys.stdin.readline

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
n = int(input())
students = {}
for _ in range(n * n):
    a, b, c, d, e = map(int, input().strip().split())
    students[a] = [b, c, d, e]

board = [[0] * n for _ in range(n)]

import heapq


def in_range(x, y):
    return 0 <= x < n and 0 <= y < n


def find_pos(board, cur, friends):
    Q = []
    for i in range(n):
        for j in range(n):
            if board[i][j] != 0:
                continue
            f_cnt = 0
            e_cnt = 0
            for k in range(4):
                nx = j + dx[k]
                ny = i + dy[k]
                if in_range(nx, ny):
                    if board[ny][nx] in friends:
                        f_cnt += 1
                    elif board[ny][nx] == 0:
                        e_cnt += 1
            heapq.heappush(Q, (4 - f_cnt, 4 - e_cnt, i, j))

    f_cnt, e_cnt, y, x = heapq.heappop(Q)
    return x, y


for cur, friends in students.items():
    x, y = find_pos(board, cur, friends)
    board[y][x] = cur

ans = 0
for i in range(n):
    for j in range(n):
        cnt = 0
        for k in range(4):
            nx = j + dx[k]
            ny = i + dy[k]

            if in_range(nx, ny) and board[ny][nx] in students[board[i][j]]:
                cnt += 1
        if cnt != 0:
            ans += 10 ** (cnt - 1)
print(ans)