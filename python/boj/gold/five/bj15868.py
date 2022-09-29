import sys
input = sys.stdin.readline

N, M = map(int, input().strip().split(" "))
city = [list(map(int, input().strip().split(" "))) for _ in range(N)]

homes = []
stores = []
for i in range(N):
    for j in range(N):
        cur = city[i][j]
        if cur == 1:
            homes.append((i + 1, j + 1))
        elif cur == 2:
            stores.append((i + 1, j + 1))


MAX = 9876543210
ans = MAX
def calculate(visited):
    global ans
    cur_stores = []
    for i in range(len(visited)):
        if not visited[i]:
            cur_stores.append(stores[i])
    _sum = 0
    for home in homes:
        _min = MAX
        for store in cur_stores:
            dist = abs(home[0] - store[0]) + abs(home[1] - store[1])
            _min = min(_min, dist)
        _sum += _min
    ans = min(_sum, ans)


def recursive(visited, depth, index):
    if depth == 0:
        calculate(visited)
        return

    for i in range(index, len(visited)):
        if not visited[i]:
            visited[i] = True
            recursive(visited, depth - 1, i + 1)
            visited[i] = False


visited = [False] * len(stores)
recursive(visited, len(stores) - M, 0)
print(ans)