import sys

input = sys.stdin.readline

n, m = map(int, input().strip().split())

G = [None] * (n + 1)
D = [0] * (m + 1)

for i in range(1, n + 1):
    g = list(map(int, input().strip().split()))
    G[i] = g[1:]

ans = 0


def dfs(cur, visited):
    nxts = G[cur]
    for nxt in nxts:
        if visited[nxt]:
            continue
        visited[nxt] = True
        if D[nxt] == 0 or dfs(D[nxt], visited):
            D[nxt] = cur
            return True
    return False


for i in range(1, n + 1):
    visited = [False] * (m + 1)
    cnt = 0
    if dfs(i, visited):
        cnt += 1
    ans = max(ans, cnt)

print(len(D) - D.count(0))

'''
4 6
2 2 5
3 2 3 4
2 1 5
3 1 2 5 6

A B C D E
    (1) (2) (3) (4) (5)
 A       X           X
 B       X   X   X
 C   X               X
 D   X   X           X
 E       X
'''
