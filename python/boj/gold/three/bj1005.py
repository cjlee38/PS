import sys
input = sys.stdin.readline
from collections import deque

t = int(input())
for _ in range(t):
    n, k = map(int, input().strip().split())
    G = [[0] * (n + 1) for __ in range(n + 1)]
    indegree = [0] * (n + 1)
    times = [0] + list(map(int, input().strip().split()))
    for i in range(k):
        x, y = map(int, input().strip().split())
        G[x][y] = 1 # check x,y or y,x
        indegree[y] += 1
    target = int(input())

    Q = deque()
    for i in range(1, n + 1):
        if indegree[i] == 0:
            Q.append(i)

    while Q:
        cur = Q.popleft()
        prev_time = 0
        for i in range(1, n + 1):
            if G[cur][i] == 1:
                indegree[i] -= 1
                if indegree[i] <= 0:
                    Q.append(i)

            # previous of current
            if G[i][cur] == 1:
                prev_time = max(times[i], prev_time)
        times[cur] += prev_time
        if cur == target:
            break
    print(times[target])
