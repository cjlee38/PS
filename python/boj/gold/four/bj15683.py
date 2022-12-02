import sys

input = sys.stdin.readline

height, width = map(int, input().strip().split())
room = [list(map(int, input().strip().split())) for _ in range(height)]
sights = [[0] * width for _ in range(height)]
ans = 9876543210

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

colors = {
    5: [[0, 1, 2, 3]],
    2: [[0, 2], [1, 3]],
    1: [[0], [1], [2], [3]],
    3: [[0, 1], [1, 2], [2, 3], [3, 0]],
    4: [[3, 0, 1], [0, 1, 2], [1, 2, 3], [2, 3, 0]]
}


def in_range(x, y):
    return 0 <= x < width and 0 <= y < height


def color(y, x, dirs, z):
    for d in dirs:
        nx = x
        ny = y
        while True:
            nx = nx + dx[d]
            ny = ny + dy[d]
            if not in_range(nx, ny) or room[ny][nx] == 6:
                break
            sights[ny][nx] += z

cctvs = []
for i in range(height):
    for j in range(width):
        if room[i][j] != 0:
            sights[i][j] = 999
            if room[i][j] != 6:
                cctvs.append((i, j, room[i][j]))

def run(cctvs, idx):
    global ans
    if idx >= len(cctvs):
        cnt = 0
        for i in range(height):
            cnt += sights[i].count(0)
        ans = min(ans, cnt)
        return

    cctv = cctvs[idx]
    my_colors = colors[cctv[2]]
    for c in my_colors:
        color(cctv[0], cctv[1], c, 1)
        run(cctvs, idx + 1)
        color(cctv[0], cctv[1], c, -1)

run(cctvs, 0)
print(ans)
