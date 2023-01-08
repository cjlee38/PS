import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().strip().split()))

if n == 1:
    print("A")
    exit()
if n == 2:
    d = arr[1] - arr[0]
    if d == 0:
        print(arr[0])
    else:
        print("A")
    exit()

diffs = []
for i in range(1, n):
    diffs.append(arr[i] - arr[i - 1])

x = diffs[0]
y = diffs[1] / x if x != 0 else float(0)
if not y.is_integer():
    print("B")
    exit()
y = int(y)
for i in range(1, n):
    prev = arr[i - 1]
    cur = arr[i]
    if prev + x != cur:
        print("B")
        break
    x = x * y
else: # all ok
    print(arr[-1] + x)
