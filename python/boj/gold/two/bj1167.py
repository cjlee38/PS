import sys
input = sys.stdin.readline

n = int(input())
G = {k: [] for k in range(1, n + 1)}
for _ in range(n):
    cur = list(map(int, input().strip().split()))
    num = cur[0]
    i = 1

    while cur[i] != -1:
        nxt = cur[i]
        dist = cur[i + 1]
        G[num].append((nxt, dist))
        i += 2


_max = 0
ans = -1
def run(cur_num, cur_dist, visited):
    global _max, ans
    if cur_dist > _max:
        _max = cur_dist
        ans = cur_num

    for next_num, next_dist in G[cur_num]:
        if not visited[next_num]:
            visited[next_num] = True
            run(next_num, next_dist + cur_dist, visited)

visited = [False] * (n + 1)
visited[1] = True
run(1, 0, visited)

visited = [False] * (n + 1)
visited[ans] = True
run(ans, 0, visited)
print(_max)
