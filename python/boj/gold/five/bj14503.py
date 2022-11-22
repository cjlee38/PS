import sys
input = sys.stdin.readline

N, M = map(int, input().strip().split())
r, c, d = map(int, input().strip().split())

board = [list(map(int, input().strip().split())) for _ in range(N)]

'''
0 북
1 동
2 남
3 서
'''

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

cnt = 0
while True:
    if board[r][c] == 0:
        board[r][c] = -1
        cnt += 1

    for i in range(-1, -5, -1):
        nd = (d + i) % 4
        nr = r + dy[nd]
        nc = c + dx[nd]
        if board[nr][nc] == 0:
            d = nd
            r = nr
            c = nc
            break
    else:
        backward = (d + 2) % 4
        nr = r + dy[backward]
        nc = c + dx[backward]
        if board[nr][nc] == 1:
            break
        r = nr
        c = nc

print(cnt)