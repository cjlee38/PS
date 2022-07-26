import sys

# 약 30분

input = sys.stdin.readline

n, m = map(int, input().split(" "))
board = []
for i in range(n):
    board.append(list(input()))
pr, pc = map(int, input().split(" "))

dd = {
    'U': 0,
    'R': 1,
    'D': 2,
    'L': 3
}
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
MAX = 9876543210


def in_range(pr, pc):
    return 0 <= pr < n and 0 <= pc < m


def run(direction, pr, pc):
    count = 0
    visited = [[[False, False, False, False] for i in range(m)] for j in range(n)]
    while in_range(pr, pc) and board[pr][pc] != 'C':
        if visited[pr][pc][direction]:
            return MAX
        count += 1
        visited[pr][pc][direction] = True
        if board[pr][pc] == "/":
            if direction % 2 == 0:
                direction += 1
            else:
                direction -= 1
        if board[pr][pc] == "\\":
            direction = 4 - (direction + 1)
        pr += dy[direction]
        pc += dx[direction]
    return count


directions = ['U', 'R', 'D', 'L']
ress = []
for direction in directions:
    res = run(dd[direction], pr - 1, pc - 1)
    if res == MAX:
        print(direction)
        print('Voyager')
        break
    else:
        ress.append([direction, res])
else:
    m = max(ress, key=lambda x: x[1])
    print(m[0])
    print(m[1])

# 우측일떄
# 0 -> 1
# 1 -> 0
# 2 -> 3
# 3 -> 2

# 좌측일때
# 0 -> 3
# 1 -> 2
# 2 -> 1
# 3 -> 0
