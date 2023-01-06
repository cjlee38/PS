import sys
import heapq


input = sys.stdin.readline

T = int(input())


def run(start):
    Q = []
    distances = [9876543210] * (n + 1)
    distances[start] = 0
    heapq.heappush(Q, (0, start))

    while Q:
        cur_dist, cur_node = heapq.heappop(Q)
        if cur_dist > distances[cur_node]:
            continue
        for next_node, next_dist in G[cur_node]:
            sum_dist = cur_dist + next_dist
            if sum_dist < distances[next_node]:
                distances[next_node] = sum_dist
                heapq.heappush(Q, (sum_dist, next_node))
    return distances

for _ in range(T):
    n, m, t = map(int, input().strip().split())
    s, g, h = map(int, input().strip().split())

    G = {k: [] for k in range(1, n+1)}
    for _ in range(m):
        # from, to, distance
        a, b, d = map(int, input().strip().split())
        G[a].append((b, d)) # heap ? or d, b instead ?
        G[b].append((a, d))
    candidates = [int(input()) for _ in range(t)]

    s_distances = run(s)
    g_distances = run(g)
    h_distances = run(h)
    ans = []
    for candidate in candidates:
        if s_distances[g] + g_distances[h] + h_distances[candidate] == s_distances[candidate]:
            ans.append(candidate)
        elif s_distances[h] + h_distances[g] + g_distances[candidate] == s_distances[candidate]:
            ans.append(candidate)
    print(*sorted(ans))