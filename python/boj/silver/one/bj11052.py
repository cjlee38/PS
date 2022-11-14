import sys

input = sys.stdin.readline

N = int(input())
prices = list(map(int, input().strip().split(" ")))

board = [[0 for _ in range(len(prices))] for __ in range(N + 1)]

for i in range(1, N + 1):
    for j in range(len(prices)):
        if i <= j:
            board[i][j] = board[i][j - 1]
        else:
            board[i][j] = max(board[i][j - 1], board[i - (j + 1)][j] + prices[j])

print(board[N][N-1])
