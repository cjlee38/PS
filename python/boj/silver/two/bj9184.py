import sys
input = sys.stdin.readline

cache = {}


def run(a, b, c):
    key = str([a, b, c])
    if cache.get(key) is not None:
        return cache[key]
    if a <= 0 or b <= 0 or c <= 0:
        cache[key] = 1
        return cache[key]
    if a > 20 or b > 20 or c > 20:
        cache[key] = run(20, 20, 20)
        return cache[key]
    if a < b and b < c:
        cache[key] = run(a, b, c - 1) + run(a, b - 1, c - 1) - run(a, b - 1, c)
        return cache[key]
    cache[key] = run(a - 1, b, c) + run(a - 1, b - 1, c) + run(a - 1, b, c - 1) - run(a - 1, b - 1, c - 1)
    return cache[key]


while True:
    a, b, c = map(int, input().strip().split(" "))
    if a == -1 and b == -1 and c == -1:
        break
    res = run(a, b, c)
    print(f"w({a}, {b}, {c}) = {res}")


