import sys

input = sys.stdin.readline

n, K = map(int, input().strip().split())
KS = list(map(int, input().strip().split()))

arr = [0] * n
ans = 0
for i in range(K):
    cur = KS[i]
    # when empty
    if cur in arr:
        continue
    for j in range(n):
        if arr[j] == 0:
            arr[j] = cur
            break
    # when full
    else:
        nexts = KS[i:K]
        target_idx = -1
        candidates = []
        for k in range(n):
            if arr[k] in nexts:
                candidates.append((nexts.index(arr[k]), k))
            else:
                target_idx = k
                break
        else: # all found
            _, arr_idx = list(reversed(sorted(candidates)))[0]
            target_idx = arr_idx
        arr[target_idx] = cur
        ans += 1

print(ans)
