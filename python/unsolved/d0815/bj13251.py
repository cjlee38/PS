import sys
input = sys.stdin.readline

M = int(input().strip())
Ns = list(map(int, input().strip().split(" ")))
K = int(input().strip())
SUM = sum(Ns)

ans = 0

for N in Ns:
    cur = 1
    now_sum = SUM
    for i in range(K):
        cur *= (N/now_sum)
        now_sum -= 1
        N -= 1
    ans += cur

print(ans)
