import sys
input = sys.stdin.readline

n = int(input())
words = [input().strip() for _ in range(n)]

ans = ''
for i in range(len(words[0])):
    s = set([words[j][i] for j in range(n)])
    if len(s) == 1:
        ans += words[0][i]
    else:
        ans += '?'
print(ans)
