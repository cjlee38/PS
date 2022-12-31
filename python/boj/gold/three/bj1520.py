import sys

input = sys.stdin.readline

h, w = map(int, input().strip().split())
board = [list(map(int, input().strip().split())) for _ in range(h)]

class Queue:
    def __init__(self):
        self._dict = dict()
        pass
    def append(self, key, value):
        if not self._dict.get(key):
            self._dict[key] = 0
        self._dict[key] += value
    def popleft(self):
        key = next(iter(self._dict))
        return key, self._dict.pop(key)

Q = Queue()
Q.append((0, 0), 1)

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
ans = 0

def in_range(x, y):
    return 0 <= x < w and 0 <= y < h


while len(Q._dict) != 0:
    xy, n = Q.popleft()
    x = xy[0]
    y = xy[1]
    if x == w - 1 and y == h - 1:
        ans += n
        continue

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if in_range(nx, ny) and board[y][x] > board[ny][nx]:
            Q.append((nx, ny), n)


print(ans)