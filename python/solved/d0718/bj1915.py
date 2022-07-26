import sys

input = sys.stdin.readline

n, m = map(int, input().strip().split(" "))
MAX = 0
board = []
for i in range(n):
    lst = list(map(int, list(input().strip())))
    if sum(lst) > 0:
        MAX = 1
    board.append(lst)
    # board.append(list(map(int, list(input().strip()))))



for i in range(1, n):
    for j in range(1, m):
        if board[i][j] == 0:
            continue
        minn = min(board[i - 1][j], board[i][j - 1], board[i - 1][j - 1])
        if minn > 0:
            board[i][j] = minn + 1
            MAX = max(MAX, board[i][j])

print(MAX * MAX)

from pprint import pprint

pprint(board)
'''
1 5
00000
'''

'''
4 4
0000
0110
0111
0011
'''

'''
2 2
00
00
'''