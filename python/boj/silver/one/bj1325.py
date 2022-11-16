import sys, collections

input = sys.stdin.readline

N, M = map(int, input().strip().split())
G = [[] * (N + 1) for _ in range(N + 1)]


for _ in range(M):
    s, e = map(int, input().strip().split())
    G[e].append(s)

ans_list = [0] * (N + 1)


DQ = collections.deque()
for start in range(1, N+1):
    DQ.append(start)
    visited = [False] * (N + 1)
    visited[start] = True
    cnt = 1
    while DQ:
        pop = DQ.popleft()
        for nxt in G[pop]:
            if not visited[nxt]:
                DQ.append(nxt)
                visited[nxt] = True
                cnt += 1
    ans_list[start] = cnt

mac = max(ans_list)
for i in range(1, N + 1):
    if ans_list[i] == mac:
        print(i, end = ' ')


'''
8 6
2 1
3 1
4 1
5 1
7 6
8 7

4 4
1 2
2 3
3 4
4 1
'''