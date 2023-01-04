import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
board = [list(input().strip()) for _ in range(n)]
heights = [list(map(int, input().strip().split())) for _ in range(n)]
visited = [[False] * n for _ in range(n)]

dx = [0, 1, 1, 1, 0, -1, -1, -1]
dy = [-1, -1, 0, 1, 1, 1, 0, -1]

nums = set()
total = 0
num = -1
x = y = -1
for i in range(n):
    for j in range(n):
        if board[i][j] == 'P':
            num = heights[i][j]
            x, y = j, i
            board[i][j] = '.'
        if board[i][j] == 'K':
            total += 1
        nums.add(heights[i][j])

nums = list(sorted(list(nums)))
l_idx = 0
r_idx = nums.index(num)


def in_range(x, y):
    return 0 <= x < n and 0 <= y < n


def run(l_num, r_num):
    if not l_num <= heights[y][x] <= r_num:
        return False
    Q = deque()
    Q.append((x, y))
    visited = [[False] * n for _ in range(n)]
    visited[y][x] = True
    cnt = 0
    while Q:
        px, py = Q.popleft()
        for i in range(8):
            nx = px + dx[i]
            ny = py + dy[i]
            if in_range(nx, ny) and not visited[ny][nx] and l_num <= heights[ny][nx] <= r_num:
                visited[ny][nx] = True
                if board[ny][nx] == 'K':
                    cnt += 1
                Q.append((nx, ny))
    return cnt == total

ans = 9876543210
while l_idx < len(nums):
    found = run(nums[l_idx], nums[r_idx])
    if found:
        ans = min(ans, nums[r_idx] - nums[l_idx])
        l_idx += 1
    elif r_idx + 1 < len(nums):
        r_idx += 1
    else:
        break


print(ans)