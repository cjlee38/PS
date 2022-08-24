import sys
input = sys.stdin.readline

N, K = map(int, input().strip().split(" "))
students = {
    0: {
        1: 0,
        2: 0,
        3: 0,
        4: 0,
        5: 0,
        6: 0
    },
    1: {
        1: 0,
        2: 0,
        3: 0,
        4: 0,
        5: 0,
        6: 0
    }
}
for i in range(N):
    S, Y = map(int, input().strip().split(" "))
    students[S][Y] += 1

import math

rooms = 0
for gender in students:
    for year in students[gender]:
        now = students[gender][year]
        rooms += math.ceil(now / K)
print(rooms)

