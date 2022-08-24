import sys

input = sys.stdin.readline

N = int(input())
words = [input().strip() for i in range(N)]

ORDER = ['a', 'b', 'k', 'd', 'e', 'g', 'h', 'i', 'l', 'm', 'n', 'Z', 'o', 'p', 'r', 's', 't', 'u', 'w', 'y', ]

words = [word.replace('ng', 'Z') for word in words]


def check(x, y):
    xi = 0
    yi = 0
    while True:
        if xi == len(x):
            break
        elif yi == len(y):
            break
        xt = x[xi]
        yt = y[yi]
        xi += 1
        yi += 1
        if xt == yt:
            continue
        return ORDER.index(xt) - ORDER.index(yt)
    return len(x) - len(y)

from functools import cmp_to_key
words.sort(key=cmp_to_key(lambda x, y: check(x, y)))

for word in words:
    print(word.replace('Z', 'ng'))
