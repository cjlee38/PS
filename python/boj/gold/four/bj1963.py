import sys
input = sys.stdin.readline
import math

primes = [True] * 10000
m = int(math.sqrt(10000))
for i in range(2, m + 1):
    if primes[i]:
        for j in range(i + i, 10000, i):
            primes[j] = False


from heapq import *

def _replace(num, digit, replace):
    x = int(num / (10 ** digit)) % 10
    return num - (x * (10 ** digit)) + (replace * (10 ** digit))

def _run(a, b):
    visited = [False] * 10000
    Q = []
    heappush(Q, (0, a))
    while Q:
        cur_cnt, cur_number = heappop(Q)
        if cur_number == b:
            return cur_cnt
        for i in range(4):
            for j in range(10):
                nxt = _replace(cur_number, i, j)
                if primes[nxt] and not visited[nxt]: # 소수고, 방문하지 않았다면 push
                    if nxt < 1000:
                        continue
                    visited[nxt] = True
                    heappush(Q, (cur_cnt + 1, nxt))
    return "Impossible"


T = int(input())
for _ in range(T):
    a, b = map(int, input().strip().split())
    print(_run(a, b))