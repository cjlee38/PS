import sys
input = sys.stdin.readline

n = int(input())
lines = []
for i in range(n):
    a, b = map(int, input().strip().split())
    a += 1000000000
    b += 1000000000
    lines.append((a, b))

lines.sort()
start = -1
end = -1
cur = 0
for line in lines:
    if end < line[0]: # separated new line
        start = line[0]
        end = line[1]
        cur += line[1] - line[0]
    elif line[0] <= end < line[1]: # stretch
        cur += line[1] - end
        end = line[1]
    else: # included
        pass # do nothing
print(cur)