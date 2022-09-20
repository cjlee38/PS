import sys

# 30분

input = sys.stdin.readline

n = int(input())
signs = list(input().strip().split(" "))

visited = [False] * 10
board = [-1] * 10
answers = []


def to_answer(board):
    s = ""
    for b in board:
        if b != -1:
            s += str(b)
    return s


def compare(sign, cur, prev):
    if sign == '>':
        return prev > cur
    return prev < cur


def run(idx):
    if idx == n:
        answers.append(to_answer(board))
        return
    for i in range(0, 10):
        if not visited[i] and compare(signs[idx], i, board[idx]):
            visited[i] = True
            board[idx + 1] = i
            run(idx + 1)
            board[idx + 1] = -1
            visited[i] = False


for num in range(0, 10):
    visited[num] = True
    board[0] = num
    run(0)
    board[0] = -1
    visited[num] = False

print(max(answers, key=lambda x: int(x)))
print(min(answers, key=lambda x: int(x)))
