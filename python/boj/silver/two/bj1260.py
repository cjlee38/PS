import sys
from collections import deque

input = sys.stdin.readline


n, m, v = map(int, input().strip().split())
G = {i: [] for i in range(1, n + 1)}

for i in range(m):
    s, e = map(int, input().strip().split())
    G[s].append(e)
    G[e].append(s)

for g in G.values():
    g.sort()

dfs_res = []
dfs_visited = [False] * (n + 1)


def _dfs(s):
    dfs_visited[s] = True
    dfs_res.append(s)
    for n in G[s]:
        if dfs_visited[n]:
            continue
        _dfs(n)


bfs_res = []
Q = deque()
bfs_visited = [False] * (n + 1)


def _bfs(s):
    Q.append(s)
    bfs_visited[s] = True
    while Q:
        c = Q.popleft()
        bfs_res.append(c)
        for n in G[c]:
            if bfs_visited[n]:
                continue
            bfs_visited[n] = True
            Q.append(n)

_dfs(v)
_bfs(v)
print(" ".join(map(str, dfs_res)))
print(" ".join(map(str, bfs_res)))
