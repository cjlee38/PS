import sys

input = sys.stdin.readline

from collections import deque

dice = deque([deque([0]), deque([0] * 3), deque([0]), deque([0])])
dx = [1, -1, 0, 0]  # 동, 서, 북, 남
dy = [0, 0, -1, 1]
n, m, y, x, k = map(int, input().strip().split())

board = [list(map(int, input().strip().split())) for _ in range(n)]


def in_range(x, y):
    return 0 <= x < m and 0 <= y < n


def go(i):
    if i == 1:
        t = dice[1].popleft()
        u = dice[3][0]
        dice[3][0] = t
        dice[1].append(u)
    elif i == 2:
        t = dice[1].pop()
        u = dice[3][0]
        dice[3][0] = t
        dice[1].appendleft(u)
    elif i == 3:
        dice[0][0], dice[1][1], dice[2][0], dice[3][0] = dice[3][0], dice[0][0], dice[1][1], dice[2][0]
    else:
        dice[0][0], dice[1][1], dice[2][0], dice[3][0] = dice[1][1], dice[2][0], dice[3][0], dice[0][0]

ks = map(int, input().strip().split())
ans = []
for i in ks:
    nx = x + dx[i - 1]
    ny = y + dy[i - 1]
    if not in_range(nx, ny):
        continue
    go(i)
    x = nx
    y = ny
    ans.append(str(dice[3][0]))
    if board[y][x] == 0:
        board[y][x] = dice[1][1]
    else:
        dice[1][1] = board[y][x]
        board[y][x] = 0

print("\n".join(ans))




'''
  2
1 3 6
  5
  4
'''