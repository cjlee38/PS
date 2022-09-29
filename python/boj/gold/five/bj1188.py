import sys

input = sys.stdin.readline

N = int(input())  # number of people
start, dest = map(int, input().strip().split(" "))

graph = {i: [] for i in range(1, N + 1)}
for i in range(int(input())):
    x, y = map(int, input().strip().split(" "))  # x = parent, y = child
    graph[x].append(y)
    graph[y].append(x)

MAX = 9876543210
import heapq
distances = [MAX] * (N + 1)
PQ = []
heapq.heappush(PQ, (0, start))

while PQ:
    current_distance, current_vertex = heapq.heappop(PQ)

    if current_distance > distances[current_vertex]:
        continue

    for next_vertex in graph[current_vertex]:
        next_distance = current_distance + 1
        if next_distance < distances[next_vertex]:
            distances[next_vertex] = next_distance
            heapq.heappush(PQ, (next_distance, next_vertex))

print(distances[dest] if distances[dest] != MAX else -1)



