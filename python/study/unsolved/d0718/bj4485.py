import sys
import heapq
input = sys.stdin.readline

MAX = 9876543210
DX = [0, 1, 0, -1]
DY = [-1, 0, 1, 0]

def input_board(N):
    board = []
    for _ in range(N):
        board.append(list(map(int, input().strip().split(" "))))
    return board


def in_range(N, nx, ny):
    return 0 <= nx < N and 0 <= ny < N


def get_connected(pos, N):
    x = pos[0]
    y = pos[1]
    connected = []
    for dx, dy in zip(DX, DY):
        nx = x + dx
        ny = y + dy
        if in_range(N, nx, ny):
            connected.append((nx, ny))
    return connected


pcount = 1
while True:

    N = int(input())
    if N == 0:
        break
    board = input_board(N)
    dijkstra = [[MAX] * N for _ in range(N)]
    visited = [[False] * N for _ in range(N)]

    dijkstra[0][0] = board[0][0]
    visited[0][0] = True

    PQ = []
    heapq.heappush(PQ, (board[0][0], (0, 0)))
    while len(PQ) != 0:
        g = heapq.heappop(PQ)
        if g[1][0] == N - 1 and g[1][1] == N - 1:
            break
        visited[g[1][0]][g[1][1]] = True
        connected = get_connected(g[1], N)
        for cx, cy in connected:
            if visited[cx][cy]:
                continue
            if dijkstra[cx][cy] > board[cx][cy] + g[0]:
                dijkstra[cx][cy] = board[cx][cy] + g[0]
                heapq.heappush(PQ, (dijkstra[cx][cy], (cx, cy)))
    print(f"Problem {pcount}: {dijkstra[-1][-1]}")
    pcount += 1


