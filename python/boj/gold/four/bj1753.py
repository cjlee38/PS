import sys

input = sys.stdin.readline

MAX = 9876543210
V, E = list(map(int, input().strip().split(" ")))
K = int(input().strip())


class Pair:
    def __init__(self, dest, weight):
        self.dest = dest
        self.weight = weight

    def __repr__(self):
        return "({}, {})".format(self.dest, self.weight)

    def __lt__(self, other):
        return self.weight < other.weight


graph = {i: [] for i in range(1, V + 1)}

for i in range(E):
    u, v, w = list(map(int, input().strip().split(" ")))
    pair = Pair(v, w)
    for p in graph[u]:
        if p.dest == pair.dest:
            p.weight = min(p.weight, pair.weight)
            break
    else:
        graph[u].append(pair)

import heapq


def run(start):
    distances = [MAX for _ in range(V + 1)]

    heap = []
    heapq.heappush(heap, Pair(start, 0))
    while len(heap) != 0:
        pair = heapq.heappop(heap)

        if pair.weight > distances[pair.dest]:
            continue
        for connected in graph[pair.dest]:
            next_distance = connected.weight + pair.weight
            if distances[connected.dest] > next_distance:
                distances[connected.dest] = next_distance
                heapq.heappush(heap, Pair(connected.dest, next_distance))
    return distances

result = run(K)
ans = []
for idx, i in enumerate(result):
    if idx == 0: # ignore first
        continue
    if idx == K:
        ans.append('0')
    elif i == MAX:
        ans.append('INF')
    else:
        ans.append(str(i))

print("\n".join(ans))