

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

d = {
    'U': 0,
    'R': 1,
    'D': 2,
    'L': 3
}


def in_range(x, y):
    return -5 <= x <= 5 and -5 <= y <= 5


def solution(dirs):
    ans = 0
    x = y = 0
    board = [[[False] * 4 for _ in range(11)] for _ in range(11)]
    for dir in dirs:
        n = d[dir]
        nx = x + dx[n]
        ny = y + dy[n]
        if in_range(nx, ny):
            way = board[y][x][n]
            rn = (n + 2) % 4
            rway = board[ny][nx][rn]
            if not way and not rway:
                board[y][x][n] = True
                board[ny][nx][rn] = True
                ans += 1
            x = nx
            y = ny
    return ans

# dirs = "ULURRDLLU"
dirs = "LULLLLLLU"
print(solution(dirs))

