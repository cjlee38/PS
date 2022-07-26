import sys

input = sys.stdin.readline

n = int(input())
board = []
for i in range(n):
    board.append(list(map(int, input().split(" "))))

MAX = 9876543210
dp = [[MAX, MAX, MAX] for i in range(n)]
dp[0][0] = board[0][0]
dp[0][1] = board[0][1]
dp[0][2] = board[0][2]


def run(score, depth, idx):
    if depth == n - 2:
        return score
    left = (idx - 1) % 3
    right = (idx + 1) % 3
    if board[depth][left] > board[depth][right]:
        minv = board[depth][left]
        minidx = left
    else:
        minv = board[depth][right]
        minidx = right

    dp[depth][idx] = min(dp[depth][idx], minv)

    run(0, depth + 1, left)
    run(0, depth + 1, right)


for idx in range(3):
    print(run(0, 0, idx))
    print(dp)
