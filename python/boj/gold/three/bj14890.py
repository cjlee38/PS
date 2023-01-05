import sys

input = sys.stdin.readline

def check(row):
    visited = [False] * N
    h = row[0]
    for i in range(1, N):  # N - L - 1?
        if row[i] == h:
            continue
        elif row[i] > h: # 오르막길
            if i < L:
                return False
            for j in range(L):
                if row[i - j - 1] != row[i] - 1 or visited[i - j - 1]:
                    return False
                visited[i - j - 1] = True
            cnt = 1
        else: # 내리막길
            if i + (L - 1) >= N:
                return False
            for j in range(L):
                if row[i - 1] - 1 != row[i + j] or visited[i + j]:
                    return False
                visited[i + j] = True
            cnt = 1
        h = row[i]
    return True

# N = 5
# L = 1
# print(check([4, 6, 6, 5, 5]))


N, L = map(int, input().strip().split())
board = [list(map(int, input().strip().split())) for _ in range(N)]

ans = 0
for i in range(N):  # horizontal
    if check(board[i]):
        ans += 1
for i in range(N):
    if check([board[j][i] for j in range(N)]): # vertical
        ans += 1
print(ans)
