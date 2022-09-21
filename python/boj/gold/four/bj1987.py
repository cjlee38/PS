import sys
input = sys.stdin.readline

R, C = map(int, input().strip().split(" "))

board = [list(input().strip()) for _ in range(R)]

visited = set()

# dxy = [(0, -1), (1, 0), (0, 1), (-1, 0)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def in_range(nx, ny):
    return 0 <= nx < C and 0 <= ny < R


ans = -1

def run(x, y, depth):
    global ans
    ans = max(ans, depth)

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if in_range(nx, ny) and board[ny][nx] not in visited:
            visited.add(board[ny][nx])
            run(nx, ny, depth + 1)
            visited.remove(board[ny][nx])
visited.add(board[0][0])
run(0, 0, 1)
print(ans)
