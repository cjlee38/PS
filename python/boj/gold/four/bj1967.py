import sys
sys.setrecursionlimit(10 ** 4)
input = sys.stdin.readline

n = int(input())
G = [[] for k in range(n + 1)]
for _ in range(n - 1):
    p, c, d = map(int, input().strip().split())
    G[p].append((c, d))
    G[c].append((p, d))

ans_dist = 0
ans_node = -1
def dfs(cur, dist):
    global ans_dist, ans_node
    if dist > ans_dist:
        ans_dist = dist
        ans_node = cur

    for next_num, next_dist in G[cur]:
        if not visited[next_num]:
            visited[next_num] = True
            dfs(next_num, dist + next_dist)

visited = [False] * (n + 1)
visited[1] = True
dfs(1, 0)

visited = [False] * (n + 1)
visited[ans_node] = True
dfs(ans_node, 0)

print(ans_dist)

