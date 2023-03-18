import sys
input = sys.stdin.readline

MAX = 9876543210
n = int(input())
friends = [[MAX] * n for _ in range(n)]
for i in range(n):
    friends[i][i] = 0
while True:
    a, b = map(int, input().strip().split())
    if a == -1 and b == -1:
        break

    friends[a - 1][b - 1] = 1
    friends[b - 1][a - 1] = 1

for k in range(n):
    for i in range(n):
        for j in range(n):
            if friends[i][j] > friends[i][k] + friends[k][j]:
                friends[i][j] = friends[i][k] + friends[k][j]

maxes = [max(f) for f in friends]
_min = min(maxes)
ans = []
for i in range(len(maxes)):
    if maxes[i] == _min:
        ans.append(i + 1)

print(_min, len(ans))
print(*ans)
