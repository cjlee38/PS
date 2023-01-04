import sys
from collections import deque
from typing import List, Set

input = sys.stdin.readline

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

h, w = map(int, input().strip().split())
board = [list(input().strip()) for _ in range(h)]

# a b c d e f = 6
# 4 dimension
visited = [[[] for _ in range(w)] for _ in range(h)]
Q = deque()
for i in range(h):
    for j in range(w):
        if board[i][j] == '0':
            board[i][j] = '.'
            Q.append((j, i, 0, set()))  # x, y, keys

def in_range(x, y):
    return 0 <= x < w and 0 <= y < h


# check this complexity
# key를 줍고나면 다시 방황할 수 있다.
def is_visited(keys_visited: List[Set], keys: Set):
    if keys in keys_visited:
        return True
    return False

KEYS = ['a', 'b', 'c', 'd', 'e', 'f']
DOORS = [key.upper() for key in KEYS]

while Q:
    x, y, cnt, keys = Q.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if not in_range(nx, ny) or is_visited(visited[ny][nx], keys):
            continue
        elif board[ny][nx] == '#':
            continue
        elif board[ny][nx] == '.':
            visited[ny][nx].append(keys)
            Q.append((nx, ny, cnt + 1, keys))
        elif board[ny][nx] in KEYS:
            new_keys = keys | {board[ny][nx]}
            visited[ny][nx].append(new_keys)
            Q.append((nx, ny, cnt + 1, new_keys))
        elif board[ny][nx] in DOORS:
            if not board[ny][nx].lower() in keys: # what error ?
                continue # impossible
            Q.append((nx, ny, cnt + 1, keys))
            visited[ny][nx].append(keys)
        elif board[ny][nx] == '1': # answer
            print(cnt + 1)
            exit()
        else:
            print("error", board[ny][nx])
            raise "FUCK?"
else:
    print(-1)