import sys

input = sys.stdin.readline

n = int(input())
board = [input() for _ in range(5)]

number_string = [
    "###...#.###.###.#.#.###.###.###.###.###",
    "#.#...#...#...#.#.#.#...#.....#.#.#.#.#",
    "#.#...#.###.###.###.###.###...#.###.###",
    "#.#...#.#.....#...#...#.#.#...#.#.#...#",
    "###...#.###.###...#.###.###...#.###.###",
]

def _split(board, cnt):
    numbers = []
    for i in range(cnt):
        number = []
        for j in range(5):
            number.append(board[j][i * 4:i * 4 + 3])
        numbers.append(number)
    return numbers


numbers = _split(number_string, 10)
board = _split(board, n)


def _compare(n, b):
    for i in range(5):
        for j in range(3):
            if n[i][j] == '.' and b[i][j] == '#': # 불가능한 경우
                return False
    return True


ans = []
for b in board:
    cur = []
    for i in range(len(numbers)):
        n = numbers[i]
        cmp = _compare(n, b)
        if cmp: # possible
            cur.append(i)
    ans.append(cur)

def _sum(x):
    res = 0
    digit = 1
    for i in x[::-1]:
        res += i * digit
        digit *= 10
    return res

ans2 = 0
digit = 1

for i in ans[::-1]:
    if not i:
        print(-1)
        exit()
    ans2 += (sum(i) / len(i)) * digit
    digit *= 10

print(ans2)