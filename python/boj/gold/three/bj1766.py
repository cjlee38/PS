import sys
import heapq
input = sys.stdin.readline

n, m = map(int, input().strip().split())
G = [[] for _ in range(n + 1)]
level = [0] * (n + 1)
for _ in range(m):
    a, b = map(int, input().strip().split())
    G[a].append(b)
    level[b] += 1

Q = []
for i in range(1, n + 1):
    if level[i] == 0:
        heapq.heappush(Q, i)
ans = []
while Q:
    cur = heapq.heappop(Q)
    ans.append(cur)
    nxts = G[cur]
    for nxt in nxts:
        level[nxt] -= 1
        if level[nxt] == 0:
            heapq.heappush(Q, nxt)
print(*ans)
# level <- int ? == G = lst