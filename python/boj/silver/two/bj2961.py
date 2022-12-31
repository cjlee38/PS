import sys
input = sys.stdin.readline

n = int(input())
sours = []
bitters = []
for _ in range(n):
    sour, bitter = map(int, input().strip().split())
    sours.append(sour)
    bitters.append(bitter)

ans = 9876543210

bit = (2 ** n) - 1
while bit != 0:
    sour_score = 1
    bitter_score = 0
    for i in range(n):
        if bit & (1 << i):  # if 1
            sour_score *= sours[i]
            bitter_score += bitters[i]
    ans = min(ans, abs(sour_score - bitter_score))
    bit -= 1
print(ans)