import sys

input = sys.stdin.readline

N = int(input())
M = int(input())

directions = {i: [] for i in range(N + 1)}

for i in range(M):
    s, d, w = map(int, input().strip().split(" "))
    row = directions[s]
    for r in row:
        if r[0] == d:  # if same source & destination
            r[1] = min(r[1], w)
            break
    else:
        row.append([d, w])

start, dest = map(int, input().strip().split(" "))

import heapq
MAX = 9876543210
dijkstra = [MAX for _ in range(N + 1)]
dijkstra[start] = 0
PQ = []
heapq.heappush(PQ, (0, start))

while PQ:
    heappop = heapq.heappop(PQ)
    weight = heappop[0]
    number = heappop[1]

    if dijkstra[number] < weight:
        continue
    for connected in directions[number]:
        next_distance = weight + connected[1]
        if next_distance < dijkstra[connected[0]]:
            dijkstra[connected[0]] = next_distance
            heapq.heappush(PQ, [next_distance, connected[0]])

print(dijkstra[dest])