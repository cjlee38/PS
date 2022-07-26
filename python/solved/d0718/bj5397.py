import sys
input = sys.stdin.readline


T = int(input())

from collections import deque
for _ in range(T):
    left = deque()
    right = deque()
    string = input().strip()

    for s in string:
        if s == "<":
            if len(left) != 0:
                right.append(left.pop())
        elif s == ">":
            if len(right) != 0:
                left.append(right.pop())
        elif s == "-":
            if len(left) != 0:
                left.pop()
        else:
            left.append(s)

    while len(right) != 0:
        left.append(right.pop())
    print("".join(left))
