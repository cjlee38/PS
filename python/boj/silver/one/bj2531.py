import sys
input = sys.stdin.readline

n, d, k, c = map(int, input().strip().split())
arr = [int(input()) for _ in range(n)]

eat_free = False
# init

cur = 0
plates = [0] * (d + 1)
for i in range(k):
    if plates[arr[i]] == 0:
        cur += 1
    plates[arr[i]] += 1
if plates[c] == 0:
    eat_free = True
    cur += 1

ans = cur
# middle
for i in range(n - 1):
    plates[arr[i]] -= 1
    if plates[arr[i]] == 0:
        cur -= 1

    if plates[arr[(i + k) % n]] == 0:
        cur += 1
    plates[arr[(i + k) % n]] += 1

    if eat_free and plates[c] != 0:
        eat_free = False
        cur -= 1
    if not eat_free and plates[c] == 0:
        eat_free = True
        cur += 1
    ans = max(ans, cur)
print(ans)