import sys
input = sys.stdin.readline

n = int(input())

G = [[0] * (n + 1) for _ in range(n+1)]
ans = [0] * (n + 1)
indegree = [0] * (n + 1)

for i in range(1, n+1):
    tem = list(map(int, input().strip().split()))
    ans[i] = tem[0]
    for j in tem[1:-1]:
        G[i][j] = 1
        indegree[i] += 1

from collections import deque
Q = deque()
for i in range(1, n+1):
    if indegree[i] == 0:
        Q.append(i)

while Q:
    p = Q.popleft()
    cur_ans = 0
    for i in range(1, n+1):
        if G[i][p] == 1: # next to pop
            indegree[i] -= 1
            if indegree[i] == 0:
                Q.append(i)
        if G[p][i] == 1: # previous to pop
            cur_ans = max(ans[i], cur_ans)
    ans[p] += cur_ans


print('\n'.join(map(str, ans[1:])))

