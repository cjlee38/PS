
N = int(input())

board = [[' '] * (N) for _ in range(N)]

def run(depth, x, y):
    if depth == 1:
        board[y][x] = '*'
        return
    for i in range(3):
        for j in range(3):
            if i == 1 and j == 1:
                continue
            ndepth = depth // 3
            nx = (i * ndepth)
            ny = (j * ndepth)
            run(ndepth, x + nx, y + ny)

run(N, 0, 0)
for i in range(N):
    print("".join(board[i]))
