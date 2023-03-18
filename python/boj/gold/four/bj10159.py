import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
G1 = [[False] * n for _ in range(n)]
G2 = [[False] * n for _ in range(n)]
GA = [[False] * n for _ in range(n)]
for _ in range(m):
    a, b = map(int, input().strip().split())
    a -= 1
    b -= 1
    G1[a][b] = True
    G2[b][a] = True

for k in range(n):
    for i in range(n):
        for j in range(n):
            if G1[i][k] and G1[k][j]:
                G1[i][j] = True
            if G2[i][k] and G2[k][j]:
                G2[i][j] = True

for i in range(n):
    for j in range(n):
        GA[i][j] = G1[i][j] | G2[i][j]

for i in GA:
    print(n - sum(i) - 1)